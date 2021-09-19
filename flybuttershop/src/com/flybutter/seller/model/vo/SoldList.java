package com.flybutter.seller.model.vo;

import java.util.Date;

public class SoldList {
	
	private int pno;
	private Date pDate;
	private String pCode;
	private String storeNo;
	private String pAmount;
	private String pOption;
	private String pStatus;
	private String totalPur;
	
	private int userNo;
	private String userId;
	private int purPrice;
	private String purAddress;
	private int purType;
	private int delNo;
	private String purInfo;
	private String userName;
	private String phone;
	
	
	
	public SoldList() {
		// TODO Auto-generated constructor stub
	}

	

	public SoldList(int pno, Date pDate, String pCode, String storeNo, String pAmount, String pOption, String pStatus,
			String totalPur, int userNo, String userId, int purPrice, String purAddress, int purType, int delNo,
			String purInfo, String userName, String phone) {
		super();
		this.pno = pno;
		this.pDate = pDate;
		this.pCode = pCode;
		this.storeNo = storeNo;
		this.pAmount = pAmount;
		this.pOption = pOption;
		this.pStatus = pStatus;
		this.totalPur = totalPur;
		this.userNo = userNo;
		this.userId = userId;
		this.purPrice = purPrice;
		this.purAddress = purAddress;
		this.purType = purType;
		this.delNo = delNo;
		this.purInfo = purInfo;
		this.userName = userName;
		this.phone = phone;
	}









	public SoldList(int pno, Date pDate, String pCode, String storeNo, String pAmount, String pOption, String pStatus,
			String totalPur) {
		super();
		this.pno = pno;
		this.pDate = pDate;
		this.pCode = pCode;
		this.storeNo = storeNo;
		this.pAmount = pAmount;
		this.pOption = pOption;
		this.pStatus = pStatus;
		this.totalPur = totalPur;
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



	public SoldList(int pno, Date pDate, String pCode, String storeNo, String pAmount, String pOption,
			String pStatus) {
		this.pno = pno;
		this.pDate = pDate;
		this.pCode = pCode;
		this.storeNo = storeNo;
		this.pAmount = pAmount;
		this.pOption = pOption;
		this.pStatus = pStatus;
	}


	public SoldList(int userNo, int pno, Date pDate, int purPrice, 
			String purAddress, int purType, int delNo,
			String purInfo, String userId, String userName, String phone) {
		this.userNo = userNo;
		this.pno = pno;
		this.pDate = pDate;
		this.purPrice = purPrice;
		this.purAddress = purAddress;
		this.delNo = delNo;
		this.purType = purType;
		this.purInfo = purInfo;
		this.userId = userId;
		this.userName = userName;
		this.phone = phone;
		
	}




	public SoldList(int userNo, String userId, String userName, String phone, int pno, Date pDate, int purPrice, String purAddress, int delNo, int purType,
			String pCode, String storeNo, String pAmount, String pOption, String pStatus) {
		this.pno = pno;
		this.pDate = pDate;
		this.pCode = pCode;
		this.storeNo = storeNo;
		this.pAmount = pAmount;
		this.pOption = pOption;
		this.pStatus = pStatus;
		this.userNo = userNo;
		this.purPrice = purPrice;
		this.purAddress = purAddress;
		this.purType = purType;
		this.delNo = delNo;
		this.userId = userId;
		this.userName = userName;
		this.phone = phone;
		
	}




	public int getPno() {
		return pno;
	}




	public void setPno(int pno) {
		this.pno = pno;
	}




	public Date getpDate() {
		return pDate;
	}




	public void setpDate(Date pDate) {
		this.pDate = pDate;
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


	

	public int getUserNo() {
		return userNo;
	}




	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}




	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}




	public int getPurPrice() {
		return purPrice;
	}




	public void setPurPrice(int purPrice) {
		this.purPrice = purPrice;
	}




	public String getPurAddress() {
		return purAddress;
	}




	public void setPurAddress(String purAddress) {
		this.purAddress = purAddress;
	}




	public int getPurType() {
		return purType;
	}




	public void setPurType(int purType) {
		this.purType = purType;
	}




	public int getDelNo() {
		return delNo;
	}




	public void setDelNo(int delNo) {
		this.delNo = delNo;
	}




	public String getPurInfo() {
		return purInfo;
	}




	public void setPurInfo(String purInfo) {
		this.purInfo = purInfo;
	}

	

	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "pno : " + pno + ", pdate : " + pDate + ", delNo :" + delNo
				+ ", pCode : " + pCode + ", storeNo : " + storeNo
				+ ", pAmount : " + pAmount + ", pOption : " + pOption
				+ ", pStatus : " + pStatus +", totalPur : " + totalPur;
	}
	
	

}
