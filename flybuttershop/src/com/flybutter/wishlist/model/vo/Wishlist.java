package com.flybutter.wishlist.model.vo;

public class Wishlist {

	private String pCode;
	private int user_no;
	private int wish_no;
	
	
	public Wishlist() {
		// TODO Auto-generated constructor stub
	}


	public Wishlist(String pCode, int user_no, int wish_no) {
		super();
		this.pCode = pCode;
		this.user_no = user_no;
		this.wish_no = wish_no;
	}


	public String getpCode() {
		return pCode;
	}


	public void setpCode(String pCode) {
		this.pCode = pCode;
	}


	public int getUser_no() {
		return user_no;
	}


	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}


	public int getWish_no() {
		return wish_no;
	}


	public void setWish_no(int wish_no) {
		this.wish_no = wish_no;
	}


	@Override
	public String toString() {
		return "Wishlist [pCode=" + pCode + ", user_no=" + user_no + ", wish_no=" + wish_no + "]";
	}
	
	
	
	
}
