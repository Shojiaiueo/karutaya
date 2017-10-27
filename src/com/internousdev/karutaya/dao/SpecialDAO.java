package com.internousdev.karutaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.karutaya.dto.ItemDTO;
import com.internousdev.karutaya.util.DBConnector;

public class SpecialDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private String sql="SELECT * FROM items WHERE special?= 1";

	public ArrayList<ItemDTO> search(int special){
		ArrayList<ItemDTO> searchList =new ArrayList<ItemDTO>();


		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, special);
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
			    dto.setSpecial1(rs.getInt("special1"));
			    dto.setSpecial2(rs.getInt("special2"));
			    dto.setSpecial3(rs.getInt("special3"));
			    dto.setSpecial4(rs.getInt("special4"));
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

