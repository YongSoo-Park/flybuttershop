package com.flybutter.basket.model.vo;

import java.sql.Date;

public class Basket {

	private String pCode;
	private int basket_No;
	private String bOption;
	private int bAmount;
	private int price;
	private Date basket_Date;
	private int user_No;
	
	public Basket() {
		
	}

	public Basket(String pCode, int basket_No, String bOption, int bAmount, int price, Date basket_Date, int user_No) {
		super();
		this.pCode = pCode;
		this.basket_No = basket_No;
		this.bOption = bOption;
		this.bAmount = bAmount;
		this.price = price;
		this.basket_Date = basket_Date;
		this.user_No = user_No;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public int getBasket_No() {
		return basket_No;
	}

	public void setBasket_No(int basket_No) {
		this.basket_No = basket_No;
	}

	public String getbOption() {
		return bOption;
	}

	public void setbOption(String bOption) {
		this.bOption = bOption;
	}

	public int getbAmount() {
		return bAmount;
	}

	public void setbAmount(int bAmount) {
		this.bAmount = bAmount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getBasket_Date() {
		return basket_Date;
	}

	public void setBasket_Date(Date basket_Date) {
		this.basket_Date = basket_Date;
	}

	public int getUser_No() {
		return user_No;
	}

	public void setUser_No(int user_No) {
		this.user_No = user_No;
	}

	@Override
	public String toString() {
		return "Basket [pCode=" + pCode + ", basket_No=" + basket_No + ", bOption=" + bOption + ", bAmount=" + bAmount
				+ ", price=" + price + ", basket_Date=" + basket_Date + ", user_No=" + user_No + "]";
	}

}
