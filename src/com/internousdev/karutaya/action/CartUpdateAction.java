package com.internousdev.karutaya.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.CartAddDAO;
import com.internousdev.karutaya.dao.CartUpdateDAO;
import com.internousdev.karutaya.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartUpdateAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private ArrayList<CartDTO> cartList;
	private int quantity;
	private int itemid; //CartItemDeleteActionのためにおいてある<s:hidden>の内の１つがitemidが初期値として入ってしまう。
	CartUpdateDAO update=new CartUpdateDAO();
	CartAddDAO add=new CartAddDAO();


	public String execute(){
		String result=ERROR;
		if(session.containsKey("sessionid")){
			int sessionid=(int) session.get("sessionid");
		    if(update.cartupdate(quantity,sessionid,itemid)>0){
						cartList=add.cart(sessionid);
						result=SUCCESS;
			}
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



	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}

	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
	}



}
