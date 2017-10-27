package com.internousdev.karutaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.karutaya.dto.HistoryDTO;
import com.internousdev.karutaya.dto.HistoryItemDTO;
import com.internousdev.karutaya.util.DBConnector;

public class AdminHistoryDAO {
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();



	public ArrayList<HistoryDTO> history(){
		ArrayList<HistoryDTO> historyList = new ArrayList<>();

		String sql1="SELECT * FROM purchaseoutlines";

		try {
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
				HistoryDTO historydto=new HistoryDTO();
				historydto.setPurchaseday(rs1.getString("purchasetime"));
				historydto.setTotal(rs1.getInt("total"));
				historydto.setHowpay(rs1.getString("howpay"));
				historydto.setUserId(rs1.getInt("userid"));
				int purchaseoutlineid=rs1.getInt("purchaseoutlineid");
				String sql2="SELECT * FROM purchasedetails WHERE purchaseoutlineid=?";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, purchaseoutlineid);
				ResultSet rs2=ps2.executeQuery();
				ArrayList<HistoryItemDTO> purchaseList = new ArrayList<>();
				while(rs2.next()){
					HistoryItemDTO itemdto=new HistoryItemDTO();
					itemdto.setQuantity(rs2.getInt("quantity"));
					int itemid=rs2.getInt("itemid");
					String sql3="SELECT itemname FROM items WHERE itemid=?";
					PreparedStatement ps3 = con.prepareStatement(sql3);
					ps3.setInt(1, itemid);
					ResultSet rs3=ps3.executeQuery();
					while(rs3.next()){
						itemdto.setItemname(rs3.getString("itemname"));
						purchaseList.add(itemdto);
					}
				}
				historydto.setPurchaseList(purchaseList);
				historyList.add(historydto);
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
		return historyList;
	}

	public String username(int userId){
		 String userName=null;
		 Connection connection = db.getConnection();
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
}
