package com.internousdev.karutaya.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AddressCreateAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private int purchaseflag=0;

	public String execute(){
		System.out.println(purchaseflag);
	      return SUCCESS;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public int getPurchaseflag() {
		return purchaseflag;
	}
	public void setPurchaseflag(int purchaseflag) {
		this.purchaseflag = purchaseflag;
	}

}
