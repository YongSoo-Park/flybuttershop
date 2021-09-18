package com.flybutter.consumerMyPage.model.vo;

import java.util.Date;

public class OrderList {
	
	
	private int userNo;
	private int purNo;
	private String orderInfo;
	private Date purDate;
	private String pName;
	//private 
	
	
	public OrderList() {
		super();
	}
	
	
	

	public OrderList(int userNo, int purNo, String orderInfo,  Date purDate) {
		super();
		this.userNo = userNo;
		this.purNo = purNo;
		this.orderInfo = orderInfo;
		this.purDate = purDate;
	}






	public OrderList(int userNo, int purNo, String orderInfo) {
		super();
		this.userNo = userNo;
		this.purNo = purNo;
		this.orderInfo = orderInfo;
	}

	
	public OrderList(int purNo, String orderInfo,  Date purDate) {
		super();
		this.purNo = purNo;
		this.orderInfo = orderInfo;
		this.purDate = purDate;
	}

	
	
	
	




	public int getUserNo() {
		return userNo;
	}





	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public int getPurNo() {
		return purNo;
	}


	public void setPurNo(int purNo) {
		this.purNo = purNo;
	}


	public String getOrderInfo() {
		return orderInfo;
	}


	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}






	public Date getPurDate() {
		return purDate;
	}






	public void setPurDate(Date purDate) {
		this.purDate = purDate;
	}
	
	
	
	

}
