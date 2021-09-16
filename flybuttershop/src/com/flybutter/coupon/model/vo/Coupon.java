package com.flybutter.coupon.model.vo;

import java.util.Date;

public class Coupon {
	
	private int user_no;
	private int order_no;
	private String pCode;
	private int cp_no;
	private int cp_count;
	private double cp_discount;
	private Date cp_date;
	private String cp_name;
	private int minPrice;
	
	
	public Coupon() {
		// TODO Auto-generated constructor stub
	}


	public Coupon(int user_no, int order_no, String pCode, int cp_no, int cp_count, double cp_discount, Date cp_date) {
		super();
		this.user_no = user_no;
		this.order_no = order_no;
		this.pCode = pCode;
		this.cp_no = cp_no;
		this.cp_count = cp_count;
		this.cp_discount = cp_discount;
		this.cp_date = cp_date;
	}


	public int getUser_no() {
		return user_no;
	}


	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}


	public int getOrder_no() {
		return order_no;
	}


	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}


	public String getpCode() {
		return pCode;
	}


	public void setpCode(String pCode) {
		this.pCode = pCode;
	}


	public int getCp_no() {
		return cp_no;
	}


	public void setCp_no(int cp_no) {
		this.cp_no = cp_no;
	}


	public int getCp_count() {
		return cp_count;
	}


	public void setCp_count(int cp_count) {
		this.cp_count = cp_count;
	}


	public double getCp_discount() {
		return cp_discount;
	}


	public void setCp_discount(double cp_discount) {
		this.cp_discount = cp_discount;
	}


	public Date getCp_date() {
		return cp_date;
	}


	public void setCp_date(Date cp_date) {
		this.cp_date = cp_date;
	}
	
	


	public String getCp_name() {
		return cp_name;
	}


	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}


	public int getMinPrice() {
		return minPrice;
	}


	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}


	public Coupon(int user_no, int order_no, String pCode, int cp_no, int cp_count, double cp_discount, Date cp_date,
			String cp_name, int minPrice) {
		super();
		this.user_no = user_no;
		this.order_no = order_no;
		this.pCode = pCode;
		this.cp_no = cp_no;
		this.cp_count = cp_count;
		this.cp_discount = cp_discount;
		this.cp_date = cp_date;
		this.cp_name = cp_name;
		this.minPrice = minPrice;
	}


	
	

	

	
	
	
	
	
	
	
	
	

}
