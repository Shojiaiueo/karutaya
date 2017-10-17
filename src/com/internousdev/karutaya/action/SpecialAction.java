package com.internousdev.karutaya.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.SpecialDAO;
import com.internousdev.karutaya.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SpecialAction extends ActionSupport implements SessionAware{
	private String special;

	private Map<String,Object> session;

	private ArrayList<ItemDTO> searchList;

	public String execute(){
		SpecialDAO dao=new SpecialDAO();
		searchList=dao.search(special);

		return SUCCESS;
	}



	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public ArrayList<ItemDTO> getSearchList() {
		return searchList;
	}

	public void setSearchList(ArrayList<ItemDTO> searchList) {
		this.searchList = searchList;
	}





	public String getSpecial() {
		return special;
	}



	public void setSpecial(String special) {
		this.special = special;
	}

}
