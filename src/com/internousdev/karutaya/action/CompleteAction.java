package com.internousdev.karutaya.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.CartAddDAO;
import com.internousdev.karutaya.dao.CompleteDAO;
import com.internousdev.karutaya.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CompleteAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private int addressid;
	private String howdeliver;
	private String howpay;
	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();
	private int total;
	CompleteDAO completedao=new CompleteDAO();




	public String execute(){
		String result=ERROR;
		if(session.containsKey("sessionid")){
			if(completedao.purchaseoutline((int) session.get("userId"), total, addressid, howdeliver, howpay)>0){
				CartAddDAO dao = new CartAddDAO();
				cartList=dao.cart((int) session.get("sessionid"));
				if(cartList.size()>0){
					int count=0;
					for(int i=0;i<cartList.size();i++){
						if(completedao.purchasedetail(cartList.get(i).getItemid(), cartList.get(i).getQuantity())>0){
							count++;
						}
					}
					if(count==cartList.size()){
						if(completedao.cartrefresh((int) session.get("sessionid"))>0){
							result=SUCCESS;
						}
					}
				}
			}

		}

	      return result;
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



	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}

	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
	}


	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}


	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}


}
