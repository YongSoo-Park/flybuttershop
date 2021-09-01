package com.flybutter.seller.model.vo;

public class Seller {
	
	private int store_No;
	private int user_No;
	private String store_Name;
	private String store_Address;
	private String seller_No;
	private String store_Account;
	private String store_Exp;
	
	
	public Seller(int store_No, int user_No, String store_Name, String store_Address, String seller_No,
			String store_Account, String store_Exp) {
		super();
		this.store_No = store_No;
		this.user_No = user_No;
		this.store_Name = store_Name;
		this.store_Address = store_Address;
		this.seller_No = seller_No;
		this.store_Account = store_Account;
		this.store_Exp = store_Exp;
	}


	public int getStore_No() {
		return store_No;
	}


	public void setStore_No(int store_No) {
		this.store_No = store_No;
	}


	public int getUser_No() {
		return user_No;
	}


	public void setUser_No(int user_No) {
		this.user_No = user_No;
	}


	public String getStore_Name() {
		return store_Name;
	}


	public void setStore_Name(String store_Name) {
		this.store_Name = store_Name;
	}


	public String getStore_Address() {
		return store_Address;
	}


	public void setStore_Address(String store_Address) {
		this.store_Address = store_Address;
	}


	public String getSeller_No() {
		return seller_No;
	}


	public void setSeller_No(String seller_No) {
		this.seller_No = seller_No;
	}


	public String getStore_Account() {
		return store_Account;
	}


	public void setStore_Account(String store_Account) {
		this.store_Account = store_Account;
	}


	public String getStore_Exp() {
		return store_Exp;
	}


	public void setStore_Exp(String store_Exp) {
		this.store_Exp = store_Exp;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "store_No : " + store_No + ", user_No : " + user_No + ", store_Name : " + store_Name + ", store_Address : " + store_Address + ", seller_No : " + seller_No 
				+ ", store_Account : " + store_Account + ", store_Exp : " + store_Exp;
	}
	
}
