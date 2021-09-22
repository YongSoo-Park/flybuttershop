package com.flybutter.consumerMyPage.model.vo;

import java.util.Date;

public class OrderInfo {
	
	private String pCode;
	private String pName;
	private int sellerNo;
	private int amount;
	private String option;
	private int state;
	private int purNo;
	private Date purDate;
	private String pImage;
	private int delNo;
	private int purType;
	private int purPrice;
	
	
	
	public OrderInfo() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	



	public OrderInfo(String pCode, String pName, int sellerNo, int amount, String option, int state, int purNo,
			Date purDate, String pImage, int delNo, int purType, int purPrice) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.sellerNo = sellerNo;
		this.amount = amount;
		this.option = option;
		this.state = state;
		this.purNo = purNo;
		this.purDate = purDate;
		this.pImage = pImage;
		this.delNo = delNo;
		this.purType = purType;
		this.purPrice = purPrice;
	}



	



	public OrderInfo(String pCode, int sellerNo, int amount, String option, int state) {
		super();
		this.pCode = pCode;
		this.sellerNo = sellerNo;
		this.amount = amount;
		this.option = option;
		this.state = state;
	}







	public OrderInfo(String pCode, String pName, int sellerNo, int amount, String option, int state, int purNo,
			Date purDate, String pImage) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.sellerNo = sellerNo;
		this.amount = amount;
		this.option = option;
		this.state = state;
		this.purNo = purNo;
		this.purDate = purDate;
		this.pImage = pImage;
	}







	public OrderInfo(String pName, int sellerNo, int amount, String option, int state, int purNo, Date purDate,
			String pImage) {
		super();
		this.pName = pName;
		this.sellerNo = sellerNo;
		this.amount = amount;
		this.option = option;
		this.state = state;
		this.purNo = purNo;
		this.purDate = purDate;
		this.pImage = pImage;
	}



	



	public String getpCode() {
		return pCode;
	}







	public void setpName(String pName) {
		this.pName = pName;
	}







	public String getpName() {
		return pName;
	}

	public void setpCode(String pName) {
		this.pName = pName;
	}

	public int getSellerNo() {
		return sellerNo;
	}

	public void setSellerNo(int sellerNo) {
		this.sellerNo = sellerNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getPurNo() {
		return purNo;
	}

	public void setPurNo(int purNo) {
		this.purNo = purNo;
	}

	public Date getPurDate() {
		return purDate;
	}

	public void setPurDate(Date purDate) {
		this.purDate = purDate;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
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
		return "OrderInfo [pCode=" + pCode + ", pName=" + pName + ", sellerNo=" + sellerNo + ", amount=" + amount
				+ ", option=" + option + ", state=" + state + ", purNo=" + purNo + ", purDate=" + purDate + ", pImage="
				+ pImage + ", delNo=" + delNo + ", purType=" + purType + ", purPrice=" + purPrice + "]";
	}











	
	
	
	
	
	
	
	
	
	
	
	

}
