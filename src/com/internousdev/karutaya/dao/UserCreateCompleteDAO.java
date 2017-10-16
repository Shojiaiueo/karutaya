package com.internousdev.karutaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.karutaya.util.DBConnector;

public class UserCreateCompleteDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();


	private String sql = "INSERT INTO users(email, password, username) VALUES(?, ? ,?)";

	public int createUser(String email, String password, String userName) throws SQLException {
		int result=0;

		if((email!=null)&&(password!=null)&&(userName!=null)){

		    try {
			    PreparedStatement preparedStatement = connection.prepareStatement(sql);
			    preparedStatement.setString(1, email);
			    preparedStatement.setString(2, password);
			    preparedStatement.setString(3, userName);

			    result=preparedStatement.executeUpdate();

		      } catch(Exception e) {
			    e.printStackTrace();
		      } finally {
			     connection.close();
		      }
		}
		return result;
	}
}
