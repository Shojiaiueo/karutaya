package com.internousdev.karutaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.karutaya.dto.HistoryDTO;
import com.internousdev.karutaya.dto.ItemDTO;
import com.internousdev.karutaya.util.DBConnector;

public class HistoryDAO {
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();
	HistoryDTO historydto=new HistoryDTO();
	ItemDTO itemdto=new ItemDTO();

	public ArrayList<HistoryDTO> history(int userId){
		ArrayList<HistoryDTO> historyList = new ArrayList<>();
		ArrayList<ItemDTO> purchaseList = new ArrayList<>();
		String sql1="SELECT * FROM purchaseoutlines WHERE userid=?";

		try {
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setInt(1, userId);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
				historydto.setPurchaseday(rs1.getString("purchasetime"));
				historydto.setTotal(rs1.getInt("total"));
				historydto.setHowpay(rs1.getString("howpay"));
				int purchaseoutlineid=rs1.getInt("purchaseoutlineid");
				String sql2="SELECT itemid FROM purchasedetails WHERE purchaseoutlineid=?";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, purchaseoutlineid);
				ResultSet rs2=ps2.executeQuery();
				while(rs2.next()){
					int itemid=rs2.getInt("itemid");
					String sql3="SELECT itemname FROM items WHERE itemid=?";
					PreparedStatement ps3 = con.prepareStatement(sql3);
					ps3.setInt(1, itemid);
					ResultSet rs3=ps3.executeQuery();
					itemdto.setItemname(rs3.getString("itemname"));
					purchaseList.add(itemdto);
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
}
