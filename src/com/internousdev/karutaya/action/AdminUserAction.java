package com.internousdev.karutaya.action;


import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.AdminUserDAO;
import com.internousdev.karutaya.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private ArrayList<LoginDTO> userList;
	AdminUserDAO dao=new AdminUserDAO();

	public String execute(){
		setUserList(dao.users());
		return SUCCESS;
	}


	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}


	public ArrayList<LoginDTO> getUserList() {
		return userList;
	}


	public void setUserList(ArrayList<LoginDTO> userList) {
		this.userList = userList;
	}


}
