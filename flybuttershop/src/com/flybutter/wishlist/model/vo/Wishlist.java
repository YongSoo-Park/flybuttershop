package com.flybutter.wishlist.model.vo;

public class Wishlist {

	private int wish_no;
	private String pCode;
	private int user_No;
	private String pImage;
	private String pName;
	private int price;
	private String score;
	

	public Wishlist() {
		
	}

	public Wishlist(int wish_no, String pCode, int user_No) {
		super();
		this.wish_no = wish_no;
		this.pCode = pCode;
		this.user_No = user_No;
	}

	public Wishlist(int wish_no, String pCode, String pImage, String pName, String score, int price ) {
		super();
		this.wish_no = wish_no;
		this.pCode = pCode;
		this.pImage = pImage;
		this.pName = pName;
		this.score = score;
		this.price = price;
		
		
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
	
	
	

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Wishlist [wish_no=" + wish_no + ", pCode=" + pCode + ", user_No=" + user_No + ", pImage=" + pImage
				+ ", pName=" + pName + ", price=" + price + ", score=" + score + "]";
	}

	
}
