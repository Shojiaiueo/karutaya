package com.internousdev.karutaya.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.CartAddDAO;
import com.internousdev.karutaya.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAddAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;

	private int itemid;
	ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();



	public String execute(){
		String result=ERROR;
		CartAddDAO dao=new CartAddDAO();
		int sessionid = 0;
		while(dao.checksessionid(sessionid)){
		     sessionid=(int)(Math.random()*1000000000);
		}
		session.put("sessionid",sessionid);
		if(session.containsKey("sessionid")){
			if(dao.insertsessionid(sessionid)>0){
			result=LOGIN;
			}
		}

		if(result==LOGIN){
			int quantity=dao.cartcheck(sessionid, itemid);
			if(quantity==0){
				if(dao.cartadd(sessionid, itemid)>0){
					result=SUCCESS;
				}
			}else if(quantity==100){
				result=SUCCESS;
			}else{
				quantity++;
				if(dao.cartupdate(sessionid, itemid, quantity)>0){
					result=SUCCESS;
				}
			}
		}

		if(result==SUCCESS){
			cartList=dao.cart(sessionid);
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

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

}
