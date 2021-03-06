package com.internousdev.karutaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.karutaya.util.DBConnector;

public class CompleteDAO {
	DBConnector db=new DBConnector();

	public int purchaseoutline(int userid,int total,int addressid,String howdeliver,String howpay){
		Connection con=db.getConnection();
		String sql="INSERT INTO purchaseoutlines(userid,total,addressid,howdeliver,howpay) VALUES(?,?,?,?,?)";
		int result=0;

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, total);
			ps.setInt(3, addressid);
			ps.setString(4, howdeliver);
			ps.setString(5,howpay);
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

	public int stockcheck(int itemid){
		int result=0;
		Connection con=db.getConnection();
		String sql="SELECT stocks FROM items WHERE itemid=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, itemid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				result=rs.getInt("stocks");
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

	public int salesstocks(int itemid,int quantity){
		int result=0;
		Connection con=db.getConnection();
		String sql="UPDATE items SET stocks=stocks-?,sales=sales+? WHERE itemid=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, quantity);
			ps.setInt(2, quantity);
			ps.setInt(3, itemid);
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
