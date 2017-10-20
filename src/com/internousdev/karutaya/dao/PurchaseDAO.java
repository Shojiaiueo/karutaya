package com.internousdev.karutaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.karutaya.dto.AddressDTO;
import com.internousdev.karutaya.util.DBConnector;

public class PurchaseDAO {
	private DBConnector dbConnector = new DBConnector();
	public String username(int userId){
		 String userName=null;
		 Connection connection = dbConnector.getConnection();
		 String sql="SELECT username FROM users WHERE userid=?";
		 try {
				PreparedStatement ps=connection.prepareStatement(sql);
				ps.setInt(1, userId);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					userName=rs.getString("username");
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
			return userName;
	}



	public ArrayList<AddressDTO> address(int userId){
		Connection connection = dbConnector.getConnection();
		String sql="SELECT * FROM address WHERE userid=?";
		ArrayList<AddressDTO> addressList=new ArrayList<AddressDTO>();
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				AddressDTO dto=new AddressDTO();
				dto.setAddressid(rs.getInt("addressid"));
				dto.setAddress(rs.getString("address"));
				dto.setAddressname(rs.getString("addressname"));
				dto.setAddressnumber(rs.getString("addressnumber"));
				addressList.add(dto);
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
		return addressList;

	}

}
