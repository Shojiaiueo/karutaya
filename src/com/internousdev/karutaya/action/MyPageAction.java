package com.internousdev.karutaya.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.PurchaseDAO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private String userName;

	public String execute(){
		if(session.containsKey("userId")){
			PurchaseDAO dao=new PurchaseDAO();
			userName=dao.username((int) session.get("userId"));
			return SUCCESS;
		}else{
			return ERROR;
		}

	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
