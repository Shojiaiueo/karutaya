package com.internousdev.karutaya.action;

import java.util.ArrayList;
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



	public String execute(){
		String result=ERROR;
		if(creditnumber.equals(null)||creditsecurity.equals(null)){
			errormessage="未入力の項目があります";
			result=LOGIN;
		}else{
			if(completedao.creditcheck(credittype, creditnumber, creditsecurity, creditM, creditY)){
				if(session.containsKey("sessionid")){
					if(completedao.purchaseoutlinecredit((int) session.get("userId"), total, addressid, howdeliver, howpay,creditnumber)>0){
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
			}else{
				errormessage="カード情報を確認してください";
				result=LOGIN;
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

}
