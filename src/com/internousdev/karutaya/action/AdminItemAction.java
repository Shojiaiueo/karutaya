package com.internousdev.karutaya.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.SearchDAO;
import com.internousdev.karutaya.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminItemAction extends ActionSupport implements SessionAware {
	private ArrayList<ItemDTO> searchList;
	private Map<String,Object> session;
	SearchDAO dao=new SearchDAO();

	public String execute(){
		searchList=dao.search("");
		return SUCCESS;
	}

	public ArrayList<ItemDTO> getSearchList() {
		return searchList;
	}
	public void setSearchList(ArrayList<ItemDTO> searchList) {
		this.searchList = searchList;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
