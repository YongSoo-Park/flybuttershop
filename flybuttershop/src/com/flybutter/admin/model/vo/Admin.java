package com.flybutter.admin.model.vo;

public class Admin {

	private int userNo;
	private String userId;
	private String userName;
	private String email;
	private int lev;
	private int category;
	private String userCel;
	
	private int storeLev;
	private int storeNo;
	private String storeName;
	private String sellerNo;
	private String ceo;
	private String storeEmail;
	private int totalSales;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Admin(int lev, String userId, String userName, String email, String userCel, int userNo, int category ) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.lev = lev;
		this.category = category;
		this.userCel = userCel;
	}

	
	

	public Admin(int storeLev, String sellerNo, String storeName, String ceo, String storeEmail, int totalSales, int userNo, int storeNo) {
		super();
		this.userNo = userNo;
		this.storeLev = storeLev;
		this.storeNo = storeNo;
		this.storeName = storeName;
		this.sellerNo = sellerNo;
		this.ceo = ceo;
		this.storeEmail = storeEmail;
		this.totalSales = totalSales;
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



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getLev() {
		return lev;
	}



	public void setLev(int lev) {
		this.lev = lev;
	}



	public int getCategory() {
		return category;
	}



	public void setCategory(int category) {
		this.category = category;
	}



	public String getUserCel() {
		return userCel;
	}



	public void setUserCel(String userCel) {
		this.userCel = userCel;
	}



	public int getStoreLev() {
		return storeLev;
	}



	public void setStoreLev(int storeLev) {
		this.storeLev = storeLev;
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



	public String getSellerNo() {
		return sellerNo;
	}



	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
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



	public int getTotalSales() {
		return totalSales;
	}



	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}



	@Override
	public String toString() {
		return "Admin [userNo=" + userNo + ", userId=" + userId + ", userName=" + userName + ", email=" + email
				+ ", lev=" + lev + ", category=" + category + ", userCel=" + userCel + ", storeLev=" + storeLev
				+ ", storeNo=" + storeNo + ", storeName=" + storeName + ", sellerNo=" + sellerNo + ", ceo=" + ceo
				+ ", storeEmail=" + storeEmail + ", totalSales=" + totalSales + "]";
	}


	
	
}
