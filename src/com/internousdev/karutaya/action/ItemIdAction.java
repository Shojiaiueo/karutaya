package com.internousdev.karutaya.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.ItemIdDAO;
import com.internousdev.karutaya.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemIdAction extends ActionSupport implements SessionAware{
	private int searchId;

	private Map<String,Object> session;

	private ArrayList<ItemDTO> searchList;

	public String execute(){
		ItemIdDAO dao=new ItemIdDAO();
		searchList=dao.search(searchId);

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



	public int getSearchId() {
		return searchId;
	}



	public void setSearchId(int searchId) {
		this.searchId = searchId;
	}

}
