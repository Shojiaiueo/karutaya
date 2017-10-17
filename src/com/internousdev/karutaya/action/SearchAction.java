package com.internousdev.karutaya.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.SearchDAO;
import com.internousdev.karutaya.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport implements SessionAware{
	private String searchWord;

	private Map<String,Object> session;

	private ArrayList<ItemDTO> searchList;

	public String execute(){
		SearchDAO dao=new SearchDAO();
		searchList=dao.search(searchWord);

		return SUCCESS;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
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

}
