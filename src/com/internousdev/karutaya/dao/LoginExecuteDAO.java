package com.internousdev.karutaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.karutaya.dto.LoginDTO;
import com.internousdev.karutaya.util.DBConnector;

public class LoginExecuteDAO {
	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();
	private String sql="SELECT * FROM users WHERE email=? AND password=?";
	private int result;


	public LoginDTO login(String email,String password){
		result=0;
		LoginDTO loginDTO = new LoginDTO();

		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
			loginDTO.setEmail(email);
			loginDTO.setPassword(password);
			loginDTO.setUserId(rs.getInt("userid"));
			loginDTO.setUserName(rs.getString("username"));
			}else{
				loginDTO.setUserId(0);
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
		return loginDTO;

	}


	public int getResult() {
		return result;
	}


	public void setResult(int result) {
		this.result = result;
	}

}
