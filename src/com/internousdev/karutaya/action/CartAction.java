package com.internousdev.karutaya.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.CartAddDAO;
import com.internousdev.karutaya.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();
	private boolean errorMessage=false;

	public String execute(){
		if(session.containsKey("sessionid")){
			CartAddDAO dao = new CartAddDAO();
			cartList=dao.cart((int) session.get("sessionid"));
		}
		if(cartList.size()==0){
			errorMessage=true;
		}
		return SUCCESS;
	}



	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	public Map<String, Object> getSession(){
		return session;
	}



	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}

	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
	}



	public boolean getErrorMessage() {
		return errorMessage;
	}



	public void setErrorMessage(boolean errorMessage) {
		this.errorMessage = errorMessage;
	}






}
