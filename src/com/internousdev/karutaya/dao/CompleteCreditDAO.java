package com.internousdev.karutaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.karutaya.util.DBConnector;

public class CompleteCreditDAO {
	    DBConnector db=new DBConnector();

	    public boolean creditcheck(String credittype,String creditnumber,String creditsecurity,int creditM,int creditY){
	    	boolean result=false;
	    	Connection con=db.getCreditConnection(credittype);
	    	String sql="SELECT * FROM credit_card WHERE credit_number=? AND security_code=? AND expiration_month=? AND expiration_year=?";
	    	try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, creditnumber);
				ps.setString(2, creditsecurity);
				ps.setInt(3, creditM);
				ps.setInt(4, 2000+creditY);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					result=true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
		    	try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		    }
	    	return result;
	    }

		public int purchaseoutlinecredit(int userid,int total,int addressid,String howdeliver,String howpay,String creditnumber){
			Connection con=db.getConnection();
			String sql="INSERT INTO purchaseoutlines(userid,total,addressid,howdeliver,howpay,creditnumber) VALUES(?,?,?,?,?,?)";
			int result=0;

			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, userid);
				ps.setInt(2, total);
				ps.setInt(3, addressid);
				ps.setString(4, howdeliver);
				ps.setString(5,howpay);
				ps.setString(6, creditnumber);
				result=ps.executeUpdate();
				} catch (SQLException e) {
				e.printStackTrace();
			    }finally{
			    	try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			    }
			return result;
		}

		//purchasedetailにpurchaseoutlineの最新のpurchaseoutlineidを使ってぶち込む。
		public int purchasedetail(int itemid,int quantity){
			int result=0;
			int purchaseoutlineid=0;
			Connection con=db.getConnection();
			String sql="SELECT purchaseoutlineid FROM purchaseoutlines";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					purchaseoutlineid=rs.getInt("purchaseoutlineid");
				}

			} catch (SQLException e) {
			    e.printStackTrace();
			    return 0;
			}

			String sql2="INSERT INTO purchasedetails(purchaseoutlineid,itemid,quantity) VALUES(?,?,?)";


			try {
				PreparedStatement ps=con.prepareStatement(sql2);
				ps.setInt(1, purchaseoutlineid);
				ps.setInt(2, itemid);
				ps.setInt(3, quantity);

				result=ps.executeUpdate();
				} catch (SQLException e) {
				e.printStackTrace();
			    }finally{
			    	try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			    }
			return result;
		}

		public int cartrefresh(int sessionid){
			Connection con=db.getConnection();
			String sql="DELETE FROM cart WHERE sessionid=?";
			int result=0;

			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, sessionid);
				result=ps.executeUpdate();
				} catch (SQLException e) {
				e.printStackTrace();
			    }finally{
			    	try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			    }
			return result;
		}

}
