package com.internousdev.karutaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.karutaya.dto.CartDTO;
import com.internousdev.karutaya.util.DBConnector;

public class CartAddDAO {
	DBConnector dbConnector = new DBConnector();



    public boolean checksessionid(int sessionid){
    	 boolean result=false;
    	 Connection connection = dbConnector.getConnection();
	     String sql="SELECT * FROM sessionid WHERE sessionid = ?";

		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, sessionid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				result=true;
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

    public int insertsessionid(int sessionid){
    	int result=0;
    	Connection connection = dbConnector.getConnection();
    	String sql="INSERT INTO sessionid VALUES(?)";

    	try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, sessionid);
			result=ps.executeUpdate();
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

    public int cartcheck(int sessionid,int itemid){
    	int quantity=0;
    	Connection connection = dbConnector.getConnection();
    	String sql="SELECT * FROM cart WHERE sessionid=? AND itemid=?";
    	try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, sessionid);
			ps.setInt(2, itemid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
			quantity=rs.getInt("quantity");
			}else{
				quantity=0;
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
		return quantity;
    }

    public int cartadd(int sessionid,int itemid){
    	int result=0;
    	Connection connection = dbConnector.getConnection();
    	String sql="INSERT INTO cart(sessionid,itemid,quantity) VALUES(?,?,1)";

     	try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, sessionid);
			ps.setInt(2, itemid);
			result=ps.executeUpdate();
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

    public int cartupdate(int sessionid,int itemid,int quantity){
    	int result=0;
    	Connection connection = dbConnector.getConnection();
    	String sql="UPDATE cart SET quantity=? WHERE sessionid=? AND itemid=?";
    	try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, quantity);
			ps.setInt(2, sessionid);
			ps.setInt(3, itemid);
			result=ps.executeUpdate();
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

    public ArrayList<CartDTO> cart(int sessionid){
    	ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();
    	Connection connection = dbConnector.getConnection();
    	String sql="SELECT * FROM cart WHERE sessionid=?";
    	String sql2="SELECT * FROM items WHERE itemid=?";
    	try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, sessionid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			  CartDTO dto=new CartDTO();
			  dto.setItemid(rs.getInt("itemid"));
			  dto.setQuantity(rs.getInt("quantity"));
			  try{
				PreparedStatement ps2=connection.prepareStatement(sql2);
				ps2.setInt(1, rs.getInt("itemid"));
				ResultSet rs2=ps2.executeQuery();

				if(rs2.next()){
			             dto.setItemname(rs2.getString("itemname"));
			             dto.setAuthor(rs2.getString("author"));
			             dto.setPrice(rs2.getInt("price"));
			             dto.setStocks(rs2.getInt("stocks"));
			             dto.setSales(rs2.getInt("sales"));
			             dto.setItemimg(rs2.getString("itemimg"));
			             dto.setDeleted(rs2.getInt("deleted"));
			             dto.setSpecial1(rs2.getString("special1"));
			             dto.setSpecial2(rs2.getString("special2"));
			             dto.setSpecial3(rs2.getString("special3"));
			             dto.setSpecial4(rs2.getString("special4"));
				}
			  }catch(SQLException e){
				  e.printStackTrace();
			  }

			    cartList.add(dto);
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

    	return cartList;
    }

}
