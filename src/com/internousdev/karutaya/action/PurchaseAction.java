package com.internousdev.karutaya.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.PurchaseDAO;
import com.internousdev.karutaya.dto.AddressDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private ArrayList<AddressDTO> addressList;
	private String userName;
	PurchaseDAO dao=new PurchaseDAO();

	public String execute(){
		if(session.containsKey("sessionid")){
			if(session.containsKey("userId")){
				addressList=dao.address((int) session.get("userId"));
				userName=dao.username((int) session.get("userId"));
				return SUCCESS;
			}else{
				return LOGIN;
			}
		}else{
			return ERROR;
		}

	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	public Map<String, Object> getSession(){
		return session;
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
