package com.internousdev.karutaya.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.CartAddDAO;
import com.internousdev.karutaya.dao.CartItemDeleteDAO;
import com.internousdev.karutaya.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartItemDeleteAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();
	private boolean errorMessage=false;
	private int itemid;


	public String execute(){
		String result=ERROR;
		if(session.containsKey("sessionid")){
			      CartItemDeleteDAO delete = new CartItemDeleteDAO();
			      if(delete.cartitemdelete((int) session.get("sessionid"), itemid)>0){
			                   CartAddDAO add = new CartAddDAO();
			                   cartList=add.cart((int) session.get("sessionid"));
			                   result=SUCCESS;
			}
		}
		if(cartList.size()==0){
			errorMessage=true;
		}
		return result;
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



	public int getItemid() {
		return itemid;
	}



	public void setItemid(int itemid) {
		this.itemid = itemid;
	}




}
