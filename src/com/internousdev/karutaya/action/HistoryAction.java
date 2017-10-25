package com.internousdev.karutaya.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.HistoryDAO;
import com.internousdev.karutaya.dto.HistoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HistoryAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	HistoryDAO historydao=new HistoryDAO();
	private ArrayList<HistoryDTO> historyList;
	private boolean errorflag;
	private String userName;

	public String execute(){
		errorflag=false;
		if(session.containsKey("userId")){
			userName=historydao.username((int) session.get("userId"));
			historyList=historydao.history((int) session.get("userId"));
			if(historyList.size()==0){
				errorflag=true;
			}
			return SUCCESS;
		}else{
			return ERROR;
		}
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
	public boolean getErrorflag() {
		return errorflag;
	}
	public void setErrorflag(boolean errorflag) {
		this.errorflag = errorflag;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
