package com.internousdev.kaeruya.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.kaeruya.dao.LoginExecuteDAO;
import com.internousdev.kaeruya.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginExecuteAction extends ActionSupport implements SessionAware {
	private String email;
	private String password;
	private Map<String, Object> session;

	public String execute(){
		String result=ERROR;
		if(!(email.equals(null))&&!(password.equals(null))){
		  LoginExecuteDAO dao=new LoginExecuteDAO();
		  LoginDTO dto=dao.login(email, password);

		  if(dto.getUserId()>0){
			result=SUCCESS;
			session.put("userId", dto.getUserId());
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

}
