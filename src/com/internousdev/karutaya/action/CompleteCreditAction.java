package com.internousdev.karutaya.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.CartAddDAO;
import com.internousdev.karutaya.dao.CompleteCreditDAO;
import com.internousdev.karutaya.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CompleteCreditAction extends ActionSupport implements SessionAware{

	private String credittype;
	private String creditnumber;
	private int creditM;
	private int creditY;
	private String creditsecurity;
	private String errormessage;
	private Map<String,Object> session;
	private int addressid;
	private String howdeliver;
	private String howpay;
	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();
	private int total;
	CompleteCreditDAO completedao=new CompleteCreditDAO();
	CartAddDAO cartdao = new CartAddDAO();
	private boolean errorflag;
	private int itemtotal;
	private int postage;
	private int commission;
	private int year[]=new int[5];
	private String userName;
	private String addressname;
	private String addressnumber;
	private String address;



	public String execute(){
		String result=ERROR;
		if(session.containsKey("sessionid")){
			cartList=cartdao.cart((int) session.get("sessionid"));
			if(creditnumber.equals(null)||creditsecurity.equals(null)){
				errormessage="未入力の項目があります";
				result=LOGIN;
			}else{
				if(completedao.creditcheck(credittype, creditnumber, creditsecurity, creditM, creditY)){
						if(completedao.purchaseoutlinecredit((int) session.get("userId"), total, addressid, howdeliver, howpay,creditnumber)>0){
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
				}else{
					errormessage="カード情報を確認してください";
					result=LOGIN;
				}
			}
			if(result.equals(LOGIN)){
				errorflag=true;
				Date date=new Date();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy");
				int nowyear=Integer.parseInt(simpleDateFormat.format(date));
				for(int i=0;i<5;i++){
					    year[i]=nowyear+i;
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



	public String getCreditnumber() {
		return creditnumber;
	}

	public void setCreditnumber(String creditnumber) {
		this.creditnumber = creditnumber;
	}

	public String getCredittype() {
		return credittype;
	}

	public void setCredittype(String credittype) {
		this.credittype = credittype;
	}

	public String getCreditsecurity() {
		return creditsecurity;
	}

	public void setCreditsecurity(String creditsecurity) {
		this.creditsecurity = creditsecurity;
	}

	public int getCreditM() {
		return creditM;
	}

	public void setCreditM(int creditM) {
		this.creditM = creditM;
	}

	public int getCreditY() {
		return creditY;
	}

	public void setCreditY(int creditY) {
		this.creditY = creditY;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
