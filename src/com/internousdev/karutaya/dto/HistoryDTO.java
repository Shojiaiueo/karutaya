package com.internousdev.karutaya.dto;

import java.util.ArrayList;

public class HistoryDTO {
	private String purchaseday;
	private ArrayList<ItemDTO> purchaseList;
	private int total;
	private String howpay;

	public String getPurchaseday() {
		return purchaseday;
	}
	public void setPurchaseday(String purchaseday) {
		this.purchaseday = purchaseday;
	}
	public ArrayList<ItemDTO> getPurchaseList() {
		return purchaseList;
	}
	public void setPurchaseList(ArrayList<ItemDTO> purchaseList) {
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

}
