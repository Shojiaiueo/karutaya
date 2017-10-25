package com.internousdev.karutaya.action;


import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{

	private String email;

	private String password;

	private String userName;

	private Map<String,Object> session;

	public UserCreateCompleteDAO dao = new UserCreateCompleteDAO();

	public String execute() throws SQLException {
		String result = ERROR;
		if(dao.createUser(email, password, userName)>0){
		result = SUCCESS;
		}

		return result ;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
