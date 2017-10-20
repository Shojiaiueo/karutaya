package com.internousdev.karutaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.karutaya.util.DBConnector;

public class CartItemDeleteDAO {
	public int cartitemdelete(int sessionid,int itemid){
		int result=0;
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="DELETE FROM cart WHERE sessionid=? AND itemid=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, sessionid);
			ps.setInt(2, itemid);
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
