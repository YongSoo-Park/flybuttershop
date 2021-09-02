package com.flybutter.exchange.model.vo;

import java.util.Date;

public class Exchange {

	private int exc_Num;
	private int user_No;
	private int store_No;
	private int order_No;
	private Date exc_Date;
	private int exc_Quantity;
	private String exc_Reason;
	private String exc_Result;

	public Exchange() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exchange(int exc_Num, int user_No, int store_No, int order_No, Date exc_Date, int exc_Quantity,
			String exc_Reason, String exc_Result) {
		super();
		this.exc_Num = exc_Num;
		this.user_No = user_No;
		this.store_No = store_No;
		this.order_No = order_No;
		this.exc_Date = exc_Date;
		this.exc_Quantity = exc_Quantity;
		this.exc_Reason = exc_Reason;
		this.exc_Result = exc_Result;
	}

	public int getExc_Num() {
		return exc_Num;
	}

	public void setExc_Num(int exc_Num) {
		this.exc_Num = exc_Num;
	}

	public int getUser_No() {
		return user_No;
	}

	public void setUser_No(int user_No) {
		this.user_No = user_No;
	}

	public int getStore_No() {
		return store_No;
	}

	public void setStore_No(int store_No) {
		this.store_No = store_No;
	}

	public int getOrder_No() {
		return order_No;
	}

	public void setOrder_No(int order_No) {
		this.order_No = order_No;
	}

	public Date getExc_Date() {
		return exc_Date;
	}

	public void setExc_Date(Date exc_Date) {
		this.exc_Date = exc_Date;
	}

	public int getExc_Quantity() {
		return exc_Quantity;
	}

	public void setExc_Quantity(int exc_Quantity) {
		this.exc_Quantity = exc_Quantity;
	}

	public String getExc_Reason() {
		return exc_Reason;
	}

	public void setExc_Reason(String exc_Reason) {
		this.exc_Reason = exc_Reason;
	}

	public String getExc_Result() {
		return exc_Result;
	}

	public void setExc_Result(String exc_Result) {
		this.exc_Result = exc_Result;
	}

	@Override
	public String toString() {
		return "Exchange [exc_Num=" + exc_Num + ", user_No=" + user_No + ", store_No=" + store_No + ", order_No="
				+ order_No + ", exc_Date=" + exc_Date + ", exc_Quantity=" + exc_Quantity + ", exc_Reason=" + exc_Reason
				+ ", exc_Result=" + exc_Result + "]";
	}

}
