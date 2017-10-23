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
	private boolean errorflag;
	private int year[]=new int[5];
	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();
	private int itemtotal;
	private int postage;
	private int commission;
	private int total;
    private String userName;
	private String addressname;
	private String addressnumber;
	private String address;
	CompleteDAO completedao=new CompleteDAO();




	public String execute(){
		String result=ERROR;
		if(session.containsKey("sessionid")){
			if(completedao.purchaseoutline((int) session.get("userId"), total, addressid, howdeliver, howpay)>0){
				CartAddDAO dao = new CartAddDAO();
				cartList=dao.cart((int) session.get("sessionid"));
				for(int i=0;i<cartList.size();i++){
					if(completedao.purchasedetail(cartList.get(i).getItemid(), cartList.get(i).getQuantity())>0){
						result=SUCCESS;
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



	public boolean getErrorflag() {
		return errorflag;
	}

	public void setErrorflag(boolean errorflag) {
		this.errorflag = errorflag;
	}

	public int[] getYear() {
		return year;
	}

	public void setYear(int year[]) {
		this.year = year;
	}

	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}

	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
	}

	public int getItemtotal() {
		return itemtotal;
	}

	public void setItemtotal(int itemtotal) {
		this.itemtotal = itemtotal;
	}

	public int getPostage() {
		return postage;
	}

	public void setPostage(int postage) {
		this.postage = postage;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getAddressname() {
		return addressname;
	}

	public void setAddressname(String addressname) {
		this.addressname = addressname;
	}

	public String getAddressnumber() {
		return addressnumber;
	}

	public void setAddressnumber(String addressnumber) {
		this.addressnumber = addressnumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
