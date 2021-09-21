package com.flybutter.money.model.vo;

import java.util.Date;

public class Money {
	
	private int order_no;
	private int user_no;
	private int money;
	private Date date;
	private int mNo;
	
	public Money() {
		// TODO Auto-generated constructor stub
	}

	public Money(int order_no, int user_no, int money) {
		super();
		this.order_no = order_no;
		this.user_no = user_no;
		this.money = money;
	}
	
	
	

	public Money(int user_no, int money, Date date, int mNo) {
		super();
		this.user_no = user_no;
		this.money = money;
		this.date = date;
		this.mNo = mNo;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
		
		
	}
	
	
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	@Override
	public String toString() {
		return "Money [order_no=" + order_no + ", user_no=" + user_no + ", money=" + money + ", date=" + date + ", mNo="
				+ mNo + "]";
	}

	
	
	
	
	
	
	
	

}
