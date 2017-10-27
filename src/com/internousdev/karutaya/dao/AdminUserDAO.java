package com.internousdev.karutaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.karutaya.dto.LoginDTO;
import com.internousdev.karutaya.util.DBConnector;

public class AdminUserDAO {
	DBConnector db=new DBConnector();

	public ArrayList<LoginDTO> users(){
		ArrayList<LoginDTO> userList=new ArrayList<>();
		Connection con=db.getConnection();
		String sql="SELECT * FROM users";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				LoginDTO dto=new LoginDTO();
				dto.setAdminflag(rs.getInt("adminflag"));
				dto.setDeleteflag(rs.getInt("deleteflag"));
				dto.setEmail(rs.getString("email"));
				dto.setPassword(rs.getString("password"));
				dto.setUserId(rs.getInt("userid"));
				dto.setUserName(rs.getString("username"));
				userList.add(dto);
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
		return userList;
	}


}
