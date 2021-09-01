package com.flybutter.wishlist.model.vo;

public class Wishlist {

	private int wish_No;
	private String pCode;
	private int user_No;
	
	public Wishlist() {
		
	}

	public Wishlist(int wish_No, String pCode, int user_No) {
		super();
		this.wish_No = wish_No;
		this.pCode = pCode;
		this.user_No = user_No;
	}

	public int getWish_No() {
		return wish_No;
	}

	public void setWish_No(int wish_No) {
		this.wish_No = wish_No;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public int getUser_No() {
		return user_No;
	}

	public void setUser_No(int user_No) {
		this.user_No = user_No;
	}

	@Override
	public String toString() {
		return "Wishlist [wish_No=" + wish_No + ", pCode=" + pCode + ", user_No=" + user_No + "]";
	}

}
