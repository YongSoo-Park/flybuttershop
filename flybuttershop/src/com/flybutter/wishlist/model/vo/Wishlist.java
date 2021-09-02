package com.flybutter.wishlist.model.vo;

public class Wishlist {

	private int wish_no;
	private String pCode;
	private int user_No;

	public Wishlist() {
		
	}

	public Wishlist(int wish_no, String pCode, int user_No) {
		super();
		this.wish_no = wish_no;
		this.pCode = pCode;
		this.user_No = user_No;
	}

	public int getWish_no() {
		return wish_no;
	}

	public void setWish_no(int wish_no) {
		this.wish_no = wish_no;
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
		return "Wishlist [wish_no=" + wish_no + ", pCode=" + pCode + ", user_No=" + user_No + "]";
	}
	
}
