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
    Connection connection = dbConnector.getConnection();


    public boolean checksessionid(int sessionid){
    	 boolean result=false;
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
    	String sql="SELECT * FROM cart WHERE sessionid=?";
    	try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, sessionid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				CartDTO dto=new CartDTO();
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
			    dto.setQuantity(rs.getInt("quantity"));
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
