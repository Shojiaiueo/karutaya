package com.internousdev.karutaya.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.AdminHistoryDAO;
import com.internousdev.karutaya.dto.HistoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminHistoryAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	AdminHistoryDAO historydao=new AdminHistoryDAO();
	private ArrayList<HistoryDTO> historyList;

	public String execute(){
			historyList=historydao.history();
			return SUCCESS;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public ArrayList<HistoryDTO> getHistoryList() {
		return historyList;
	}
	public void setHistoryList(ArrayList<HistoryDTO> historyList) {
		this.historyList = historyList;
	}
}
