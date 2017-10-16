package com.internousdev.karutaya.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.karutaya.util.DBConnector;

public class UserCreateConfirmDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private int result;

	public int check(String email){
		result=0;
		String sql = "SELECT userid FROM users where email = ?";

		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				result++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
