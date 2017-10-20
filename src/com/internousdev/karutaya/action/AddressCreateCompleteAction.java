package com.internousdev.karutaya.action;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.AddressCreateCompleteDAO;
import com.internousdev.karutaya.dao.PurchaseDAO;
import com.internousdev.karutaya.dto.AddressDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddressCreateCompleteAction extends ActionSupport implements SessionAware{

	private String addressnumber;
	private String address;
	private String addressname;
	private int purchaseflag;
	private ArrayList<AddressDTO> addressList;
	private String userName;


	private Map<String,Object> session;

	public AddressCreateCompleteDAO dao = new AddressCreateCompleteDAO();

	public String execute() throws SQLException {
		System.out.println("completeなう"+purchaseflag);
		String result = ERROR;
		if(session.containsKey("userId")){
			if(dao.createAddress((int) session.get("userId"),addressname,addressnumber,address)>0){
				result = SUCCESS;
				if(purchaseflag==1){
					result=ERROR;
					if(session.containsKey("sessionid")){
						    PurchaseDAO purchasedao=new PurchaseDAO();
							addressList=purchasedao.address((int) session.get("userId"));
							userName=purchasedao.username((int) session.get("userId"));
							result=LOGIN;
					}
				}
			}
		}


		return result ;
	}




	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}




	public String getAddressnumber() {
		return addressnumber;
	}




	public void setAddressnumber(String addressnumber) {
		this.addressnumber = addressnumber;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getAddressname() {
		return addressname;
	}




	public void setAddressname(String addressname) {
		this.addressname = addressname;
	}




	public int getPurchaseflag() {
		return purchaseflag;
	}




	public void setPurchaseflag(int purchaseflag) {
		this.purchaseflag = purchaseflag;
	}




	public ArrayList<AddressDTO> getAddressList() {
		return addressList;
	}




	public void setAddressList(ArrayList<AddressDTO> addressList) {
		this.addressList = addressList;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}

}
