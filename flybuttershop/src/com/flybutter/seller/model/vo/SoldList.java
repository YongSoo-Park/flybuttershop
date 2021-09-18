package com.flybutter.seller.model.vo;

public class SoldList {
	
	private String pCode;
	private String storeNo;
	private String pAmount;
	private String pOption;
	private String pStatus;
	private String totalPur;
	
	
	public SoldList() {
		// TODO Auto-generated constructor stub
	}

	


	public SoldList(String pCode, String storeNo, String pAmount, String pOption, String pStatus, String totalPur) {
		super();
		this.pCode = pCode;
		this.storeNo = storeNo;
		this.pAmount = pAmount;
		this.pOption = pOption;
		this.pStatus = pStatus;
		this.totalPur = totalPur;
	}

	
	



	public SoldList(String pCode, String storeNo, String pAmount, String pOption, String pStatus) {
		this.pCode = pCode;
		this.storeNo = storeNo;
		this.pAmount = pAmount;
		this.pOption = pOption;
		this.pStatus = pStatus;
	}




	public String getpCode() {
		return pCode;
	}




	public void setpCode(String pCode) {
		this.pCode = pCode;
	}




	public String getStoreNo() {
		return storeNo;
	}




	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}




	public String getpAmount() {
		return pAmount;
	}




	public void setpAmount(String pAmount) {
		this.pAmount = pAmount;
	}




	public String getpOption() {
		return pOption;
	}




	public void setpOption(String pOption) {
		this.pOption = pOption;
	}




	public String getpStatus() {
		return pStatus;
	}




	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}




	public String getTotalPur() {
		return totalPur;
	}




	public void setTotalPur(String totalPur) {
		this.totalPur = totalPur;
	}




	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "pCode : " + pCode + ", storeNo : " + storeNo
				+ ", pAmount : " + pAmount + ", pOption : " + pOption
				+ ", pStatus : " + pStatus +", totalPur : " + totalPur;
	}
	
	

}
