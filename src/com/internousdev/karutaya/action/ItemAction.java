package com.internousdev.karutaya.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.karutaya.dao.ItemDAO;
import com.internousdev.karutaya.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemAction extends ActionSupport implements SessionAware{
	private int itemid;

	private Map<String,Object> session;

	public String execute(){
		ItemDAO dao=new ItemDAO();
		ItemDTO dto=new ItemDTO();
		dto=dao.search(itemid);
		return SUCCESS;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	public Map<String,Object> getSession(){
		return session;
	}

}
