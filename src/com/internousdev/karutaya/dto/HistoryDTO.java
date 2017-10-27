package com.internousdev.karutaya.dto;

import java.util.ArrayList;

public class HistoryDTO {
	private String purchaseday;
	private ArrayList<HistoryItemDTO> purchaseList;
	private int total;
	private String howpay;
	private int userId;

	public String getPurchaseday() {
		return purchaseday;
	}
	public void setPurchaseday(String purchaseday) {
		this.purchaseday = purchaseday;
	}
	public ArrayList<HistoryItemDTO> getPurchaseList() {
		return purchaseList;
	}
	public void setPurchaseList(ArrayList<HistoryItemDTO> purchaseList) {
		this.purchaseList = purchaseList;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getHowpay() {
		return howpay;
	}
	public void setHowpay(String howpay) {
		this.howpay = howpay;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
