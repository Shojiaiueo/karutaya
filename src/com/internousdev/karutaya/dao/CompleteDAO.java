package com.internousdev.karutaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.karutaya.util.DBConnector;

public class CompleteDAO {
	DBConnector db=new DBConnector();


	//クレジット払いの場合
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


	//銀行振込みの場合
	public int purchaseoutline(int userid,int total,int addressid,String howdeliver,String howpay){
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

}
