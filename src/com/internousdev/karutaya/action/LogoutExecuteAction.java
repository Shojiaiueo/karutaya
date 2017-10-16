package com.internousdev.karutaya.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutExecuteAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;


	public String execute(){
		session.clear();
		return SUCCESS;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public Map<String,Object> getSession(){
		return session;
	}




}
