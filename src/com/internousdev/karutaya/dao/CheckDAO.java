package com.internousdev.karutaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.karutaya.dto.AddressDTO;
import com.internousdev.karutaya.util.DBConnector;

public class CheckDAO {
	private DBConnector dbConnector = new DBConnector();
	AddressDTO dto=new AddressDTO();

	public AddressDTO address(int userId,int addressid){
		Connection connection = dbConnector.getConnection();
		String sql="SELECT * FROM address WHERE userid=? AND addressid=?";
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, addressid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				dto.setAddressid(rs.getInt("addressid"));
				dto.setAddress(rs.getString("address"));
				dto.setAddressname(rs.getString("addressname"));
				dto.setAddressnumber(rs.getString("addressnumber"));
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
		return dto;

	}

}
