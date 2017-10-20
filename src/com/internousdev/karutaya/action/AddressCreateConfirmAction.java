package com.internousdev.karutaya.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AddressCreateConfirmAction extends ActionSupport implements SessionAware{
	private String addressnumber;
	private String address;
	private String addressname;
	private String errorMessage;
	private int purchaseflag;
	private Map<String,Object> session;

	public String execute(){
		String result=ERROR;
		System.out.println("confirmやで"+purchaseflag);
		if(session.containsKey("userId")){
			if(addressnumber==null){
				errorMessage="郵便番号を全角で入力してください";
				return result;
			}else if(address==null){
				errorMessage="住所を全角で入力してください";
				return result;
			}else if(addressname==null){
				errorMessage="宛名を入力してください";
				return result;
			}else{
				addressname=addressname.replaceAll("<", "＜");
				addressname=addressname.replaceAll(">", "＞");
				result=SUCCESS;
				}
		}


		return result;
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





	public String getAddressname() {
		return addressname;
	}





	public void setAddressname(String addressname) {
		this.addressname = addressname;
	}






	public int getPurchaseflag() {
		return purchaseflag;
	}






	public void setPurchaseflag(int purchaseflag) {
		this.purchaseflag = purchaseflag;
	}


}
