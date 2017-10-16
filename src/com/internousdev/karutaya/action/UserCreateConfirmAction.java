package com.internousdev.karutaya.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.UserCreateConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{
	private String email;
	private String password;
	private String userName;
	private String errorMessage;
	private Map<String,Object> session;

	public String execute(){
		String result=ERROR;
		if(email==null){
			errorMessage="E-mailアドレスを入力してください";
			return result;
		}else if(password==null){
			errorMessage="Passwordを入力してください";
			return result;
		}else if(userName==null){
			errorMessage="userNameを入力してください";
			return result;
		}else{
			UserCreateConfirmDAO dao=new UserCreateConfirmDAO();
			if(dao.check(email)>0){
				errorMessage="そのメールアドレスは既に使用されています。他のメールアドレスを入力してください。";
			}else{
			userName=userName.replaceAll("<", "＜");
			userName=userName.replaceAll(">", "＞");
			result=SUCCESS;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}





	public String getErrorMessage() {
		return errorMessage;
	}





	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}





	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;

	}

	public Map<String, Object> getSession(){
		return session;
	}


}
