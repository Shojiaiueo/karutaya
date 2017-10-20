package com.internousdev.karutaya.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.LoginExecuteDAO;
import com.internousdev.karutaya.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginExecuteAction extends ActionSupport implements SessionAware {
	private String email;
	private String password;
	private String userName;
	private Map<String, Object> session;

	public String execute(){
		String result=ERROR;
		if(!(email.equals(null))&&!(password.equals(null))){
		  LoginExecuteDAO dao=new LoginExecuteDAO();
		  LoginDTO dto=dao.login(email, password);

		  if(dto.getUserId()>0){
			  if(dto.getDeleteflag()==0){
				    result=SUCCESS;
				    session.put("userId", dto.getUserId());
					userName=dto.getUserName();
			  }

		  }
		}

		return result;
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
