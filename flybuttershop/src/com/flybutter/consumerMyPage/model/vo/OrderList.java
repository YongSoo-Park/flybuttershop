package com.flybutter.consumerMyPage.model.vo;

import java.util.Date;

public class OrderList {
	
	
	private int userNo;
	private int purNo;
	private String orderInfo;
	private Date purDate;
	private String pName;
	private int delNo;
	private int purType;
	private int purPrice;
	
	
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

	
	



	public OrderList(int userNo, int purNo, String orderInfo, Date purDate, String pName, int delNo, int purType,
			int purPrice) {
		super();
		this.userNo = userNo;
		this.purNo = purNo;
		this.orderInfo = orderInfo;
		this.purDate = purDate;
		this.pName = pName;
		this.delNo = delNo;
		this.purType = purType;
		this.purPrice = purPrice;
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




	public String getpName() {
		return pName;
	}




	public void setpName(String pName) {
		this.pName = pName;
	}




	public int getDelNo() {
		return delNo;
	}




	public void setDelNo(int delNo) {
		this.delNo = delNo;
	}




	public int getPurType() {
		return purType;
	}




	public void setPurType(int purType) {
		this.purType = purType;
	}




	public int getPurPrice() {
		return purPrice;
	}




	public void setPurPrice(int purPrice) {
		this.purPrice = purPrice;
	}




	@Override
	public String toString() {
		return "OrderList [userNo=" + userNo + ", purNo=" + purNo + ", orderInfo=" + orderInfo + ", purDate=" + purDate
				+ ", pName=" + pName + ", delNo=" + delNo + ", purType=" + purType + ", purPrice=" + purPrice + "]";
	}
	
	
	
	

}
