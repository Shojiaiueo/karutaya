package com.internousdev.karutaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.karutaya.util.DBConnector;

public class CartUpdateDAO {
	public int cartupdate(int quantity,int sessionid,int itemid){
		int result=0;
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="UPDATE cart SET quantity=? WHERE sessionid=? AND itemid=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, quantity);
			ps.setInt(2, sessionid);
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

}
