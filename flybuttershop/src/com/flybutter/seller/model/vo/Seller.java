package com.flybutter.seller.model.vo;

import com.flybutter.member.model.vo.Member;

public class Seller extends Member{
	
	private int store_No; //상점번호
	private int user_No; //유저번호
	private String store_Name; //상점이름
	private String store_Address; //상점주소
	private String seller_No; //사업자번호
	private String store_Account; //상점계좌
	private String store_Exp; //상점 소개
	private int store_Lev; //default
	private int totalSales; //총판매액
	private String storeCall; //상점전화번호
	private String ceo; //대표자
	private String email; //상점이메일
	 
	public Seller() {
		// TODO Auto-generated constructor stub
	}
	

	public Seller(int store_No, int user_No, String store_Name, String store_Address, String seller_No,
			String store_Account, String store_Exp, int store_Lev, int totalSales, String storeCall, String ceo,
			String email) {
		super();
		this.store_No = store_No;
		this.user_No = user_No;
		this.store_Name = store_Name;
		this.store_Address = store_Address;
		this.seller_No = seller_No;
		this.store_Account = store_Account;
		this.store_Exp = store_Exp;
		this.store_Lev = store_Lev;
		this.totalSales = totalSales;
		this.storeCall = storeCall;
		this.ceo = ceo;
		this.email = email;
	}
	

	public Seller(int store_No, String store_Name, String store_Address, String seller_No, String store_Account, String store_Exp,
			 int store_Lev, int totalSales) {
		this.store_No = store_No;
		this.store_Name = store_Name;
		this.store_Address = store_Address;
		this.seller_No = seller_No;
		this.store_Account = store_Account;
		this.store_Exp = store_Exp;
		this.store_Lev = store_Lev;
		this.totalSales = totalSales;
	}

	public Seller(String store_Name, String store_Address, String seller_No, String store_Account, String store_Exp) {
		this.store_Name = store_Name;
		this.store_Address = store_Address;
		this.seller_No = seller_No;
		this.store_Account = store_Account;
		this.store_Exp = store_Exp;
	}



	public Seller(String store_Name, String store_Address, String seller_No, String store_Account,
			String store_Exp, String storeCall, String ceo, String email) {
		
		this.store_Name = store_Name;
		this.store_Address = store_Address;
		this.seller_No = seller_No;
		this.store_Account = store_Account;
		this.store_Exp = store_Exp;
		this.storeCall = storeCall;
		this.ceo = ceo;
		this.email = email;
	}


	public Seller(int store_No, String store_Name, String store_Address, String seller_No, String store_Account, String store_Exp, int store_Lev,
			String storeCall, String ceo, String email) {
		this.store_No = store_No;
		this.store_Name = store_Name;
		this.store_Address = store_Address;
		this.seller_No = seller_No;
		this.store_Account = store_Account;
		this.store_Exp = store_Exp;
		this.store_Lev = store_Lev;
		this.storeCall = storeCall;
		this.ceo = ceo;
		this.email = email;
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


	public int getStore_Lev() {
		return store_Lev;
	}


	public void setStore_Lev(int store_Lev) {
		this.store_Lev = store_Lev;
	}


	public int getTotalSales() {
		return totalSales;
	}


	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}


	public String getStoreCall() {
		return storeCall;
	}


	public void setStoreCall(String storeCall) {
		this.storeCall = storeCall;
	}


	public String getCeo() {
		return ceo;
	}


	public void setCeo(String ceo) {
		this.ceo = ceo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "store_No : " + store_No + ", user_No : " + user_No + ", store_Name : " + store_Name + ", store_Address : " + store_Address + ", seller_No : " + seller_No 
				+ ", store_Account : " + store_Account + ", store_Exp : " + store_Exp + "storeCall : " + storeCall + "ceo : " + ceo + "email : " + email;
	}
	
}
