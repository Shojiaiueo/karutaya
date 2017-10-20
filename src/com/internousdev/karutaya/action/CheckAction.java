package com.internousdev.karutaya.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CheckAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private int wheredeliver;
	private String howdeliver;
	private String howpay;
	private boolean errorflag;


	public String execute(){
		if(wheredeliver==0){
			errorflag=true;
			return ERROR;
		}else{
			errorflag=false;
		}

	      return SUCCESS;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public String getHowdeliver() {
		return howdeliver;
	}

	public void setHowdeliver(String howdeliver) {
		this.howdeliver = howdeliver;
	}

	public String getHowpay() {
		return howpay;
	}

	public void setHowpay(String howpay) {
		this.howpay = howpay;
	}

	public int getWheredeliver() {
		return wheredeliver;
	}

	public void setWheredeliver(int wheredeliver) {
		this.wheredeliver = wheredeliver;
	}

	public boolean getErrorflag() {
		return errorflag;
	}

	public void setErrorflag(boolean errorflag) {
		this.errorflag = errorflag;
	}

}
