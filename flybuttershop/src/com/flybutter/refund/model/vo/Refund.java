package com.flybutter.refund.model.vo;

import java.util.Date;

public class Refund {

	private int re_Num;
	private int user_No;
	private int store_No;
	private int order_No;
	private Date re_Date;
	private int re_Quantity;
	private String re_Reason;
	private String re_Result;

	public Refund() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Refund(int re_Num, int user_No, int store_No, int order_No, Date re_Date, int re_Quantity, String re_Reason,
			String re_Result) {
		super();
		this.re_Num = re_Num;
		this.user_No = user_No;
		this.store_No = store_No;
		this.order_No = order_No;
		this.re_Date = re_Date;
		this.re_Quantity = re_Quantity;
		this.re_Reason = re_Reason;
		this.re_Result = re_Result;
	}

	public int getRe_Num() {
		return re_Num;
	}

	public void setRe_Num(int re_Num) {
		this.re_Num = re_Num;
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

	public Date getRe_Date() {
		return re_Date;
	}

	public void setRe_Date(Date re_Date) {
		this.re_Date = re_Date;
	}

	public int getRe_Quantity() {
		return re_Quantity;
	}

	public void setRe_Quantity(int re_Quantity) {
		this.re_Quantity = re_Quantity;
	}

	public String getRe_Reason() {
		return re_Reason;
	}

	public void setRe_Reason(String re_Reason) {
		this.re_Reason = re_Reason;
	}

	public String getRe_Result() {
		return re_Result;
	}

	public void setRe_Result(String re_Result) {
		this.re_Result = re_Result;
	}

	@Override
	public String toString() {
		return "Refund [re_Num=" + re_Num + ", user_No=" + user_No + ", store_No=" + store_No + ", order_No=" + order_No
				+ ", re_Date=" + re_Date + ", re_Quantity=" + re_Quantity + ", re_Reason=" + re_Reason + ", re_Result="
				+ re_Result + "]";
	}

}
