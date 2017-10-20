package com.internousdev.karutaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.karutaya.util.DBConnector;

public class AddressCreateCompleteDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();


	private String sql = "INSERT INTO address(userid, addressname, addressnumber, address) VALUES(?, ? ,?, ?)";

	public int createAddress(int userId, String addressname, String addressnumber, String address) throws SQLException {
		int result=0;

		if((addressname != null)&&(addressnumber != null)&&(address != null)){

		    try {
			    PreparedStatement preparedStatement = connection.prepareStatement(sql);
			    preparedStatement.setInt(1, userId);
			    preparedStatement.setString(2, addressname);
			    preparedStatement.setString(3, addressnumber);
			    preparedStatement.setString(4, address);

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
