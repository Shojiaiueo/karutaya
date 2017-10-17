package com.internousdev.karutaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.karutaya.dto.ItemDTO;
import com.internousdev.karutaya.util.DBConnector;

public class ItemIdDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private String sql="SELECT * FROM items WHERE itemid BETWEEN ? AND ?";

	public ArrayList<ItemDTO> search(int searchId){
		ArrayList<ItemDTO> searchList =new ArrayList<ItemDTO>();


		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, searchId);
			ps.setInt(2, searchId+9);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ItemDTO dto = new ItemDTO();
			    dto.setItemid(rs.getInt("itemid"));
			    dto.setItemname(rs.getString("itemname"));
			    dto.setAuthor(rs.getString("author"));
			    dto.setPrice(rs.getInt("price"));
			    dto.setStocks(rs.getInt("stocks"));
			    dto.setSales(rs.getInt("sales"));
			    dto.setItemimg(rs.getString("itemimg"));
			    dto.setDeleted(rs.getInt("deleted"));
			    dto.setSpecial1(rs.getString("special1"));
			    dto.setSpecial2(rs.getString("special2"));
			    dto.setSpecial3(rs.getString("special3"));
			    dto.setSpecial4(rs.getString("special4"));
			    searchList.add(dto);
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
		return searchList;

	}
}

