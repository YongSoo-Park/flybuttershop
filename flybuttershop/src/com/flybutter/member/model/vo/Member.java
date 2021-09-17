package com.flybutter.member.model.vo;

import java.sql.Date;

public class Member {

	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String phone;
	private String email;
	private String address;
	private int lev;
	private String status;
	private int category;
	
	private String newAddress;
	private String userCel;
	private int sumPrice;
	private String recPno;
	private int money;
	
	private int storeNo;
	private String storeName;
	private String storeAddress;
	private String sellerNo;
	private String storeAccount;
	private String storeExp;
	private int storeStatus;
	private String storeCall;
	private String ceo;
	private String storeEmail;

	

	public Member() {}
	

	public Member(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}
	
	public Member(String userName, String phone,String email) {
		this.userName = userName;
		this.phone = phone;
		this.email = email;
	}
	
	public Member(String userId, String userName, String phone, String email, String address) {
		this.userId = userId;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
	public Member(String userId, String phone, String email, String address) {
		this.userId = userId;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
	public Member(String userId, String userPwd, String userName, String phone, 
			String email, String address) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		
	}
	
	public Member(int userNo, String userId, String userPwd, String userName, String phone, 
			String email,String address, int lev, String status, int category) {
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.lev = lev;
		this.status = status;
		this.category = category;
	}
	

	public Member(int userNo,  String recPno, int money) {
  //public Member(int userNo, String newAddress, String recPno, String userCel,int money, int sumPrice 
						
		this.userNo = userNo;
	//	this.newAddress = newAddress;
		this.recPno = recPno;
	//	this.userCel = userCel;	
		this.money = money;
	//	this.sumPrice = sumPrice;
	}
	
	public Member(int userNo, String userName,  int lev, int category,String recPno, int money) {
								
				this.userNo = userNo;
				this.userName = userName;
				this.lev = lev;
				this.category = category;	
				this.recPno = recPno;
				this.money = money;
			}

	
	public Member(int userNo, int storeNo,  String storeName , String storeAddress, String sellerNo, String storeAccount
			,String storeExp, int storeStatus) {
		 		
				this.userNo = userNo;
				this.storeNo = storeNo;
				this.storeName = storeName;
				this.storeAddress = storeAddress;
				this.sellerNo = sellerNo;	
				this.storeAccount = storeAccount;
				this.storeExp = storeExp;
				this.storeStatus = storeStatus;
			}
	


	public Member(String userId, String userPwd, String userName, String phone, String email, String address,
				String storeName, String storeAddress, String sellerNo, String storeAccount, String storeExp, String storeCall, String ceo,
				String storeEmail) {
		
				this.userId = userId;
				this.userPwd = userPwd;
				this.userName = userName;
				this.phone = phone;
				this.email = email;
				this.address = address;
				this.storeName = storeName;
				this.storeAddress = storeAddress;
				this.sellerNo = sellerNo;
				this.storeAccount = storeAccount;
				this.storeExp =storeExp;
				this.storeCall = storeCall;
				this.ceo = ceo;
				this.storeEmail = storeEmail;
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


	public String getUserPwd() {
		return userPwd;
	}


	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getLev() {
		return lev;
	}


	public void setLev(int lev) {
		this.lev = lev;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getCategory() {
		return category;
	}


	public void setCategory(int category) {
		this.category = category;
	}


	public String getNewAddress() {
		return newAddress;
	}


	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}


	public String getUserCel() {
		return userCel;
	}


	public void setUserCel(String userCel) {
		this.userCel = userCel;
	}


	public int getSumPrice() {
		return sumPrice;
	}


	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}


	public String getRecPno() {
		return recPno;
	}


	public void setRecPno(String recPno) {
		this.recPno = recPno;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public int getStoreNo() {
		return storeNo;
	}


	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}


	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public String getStoreAddress() {
		return storeAddress;
	}


	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}


	public String getSellerNo() {
		return sellerNo;
	}


	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}


	public String getStoreAccount() {
		return storeAccount;
	}


	public void setStoreAccount(String storeAccount) {
		this.storeAccount = storeAccount;
	}


	public String getStoreExp() {
		return storeExp;
	}


	public void setStoreExp(String storeExp) {
		this.storeExp = storeExp;
	}


	public int getStoreStatus() {
		return storeStatus;
	}


	public void setStoreStatus(int storeStatus) {
		this.storeStatus = storeStatus;
	}


	public String getStoreCall() {
		return storeCall;
	}


	public void setStoreCall(String storeCall) {
		this.storeCall = storeCall;
	}


	public String getCeo() {
		return ceo;
	}


	public void setCeo(String ceo) {
		this.ceo = ceo;
	}


	public String getStoreEmail() {
		return storeEmail;
	}


	public void setStoreEmail(String storeEmail) {
		this.storeEmail = storeEmail;
	}


	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", phone=" + phone + ", email=" + email + ", address=" + address + ", lev=" + lev + ", status="
				+ status + ", category=" + category + ", newAddress=" + newAddress + ", userCel=" + userCel
				+ ", sumPrice=" + sumPrice + ", recPno=" + recPno + ", money=" + money + ", storeNo=" + storeNo
				+ ", storeName=" + storeName + ", storeAddress=" + storeAddress + ", sellerNo=" + sellerNo
				+ ", storeAccount=" + storeAccount + ", storeExp=" + storeExp + ", storeStatus=" + storeStatus
				+ ", storeCall=" + storeCall + ", ceo=" + ceo + ", storeEmail=" + storeEmail + "]";
	}



}
