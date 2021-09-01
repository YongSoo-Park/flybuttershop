package com.flybutter.purchase.model.vo;

import java.sql.Date;

public class Purchase {

	private int user_No;
	private String pCode;
	private int pur_No;
	private Date pur_Date;
	private int pur_Price;
	private String pur_Address;
	private int pur_Type;
	private String pur_Bank;
	private String pur_Account;
	private int card_No;
	private String card_Agency;
	private String card_Date;
	private int card_Pw;
	private String phone_Agency;
	private int user_Rno;
	private int del_No;
	private char cp_Use;
	private char money_Use;
	
	public Purchase() {
		
	}

	//무통장입금
	public Purchase(int user_No, String pCode, int pur_No, Date pur_Date, int pur_Price, String pur_Address,
			int pur_Type, String pur_Bank, String pur_Account, int del_No, char cp_Use, char money_Use) {
		super();
		this.user_No = user_No;
		this.pCode = pCode;
		this.pur_No = pur_No;
		this.pur_Date = pur_Date;
		this.pur_Price = pur_Price;
		this.pur_Address = pur_Address;
		this.pur_Type = pur_Type;
		this.pur_Bank = pur_Bank;
		this.pur_Account = pur_Account;
		this.del_No = del_No;
		this.cp_Use = cp_Use;
		this.money_Use = money_Use;
	}

	//카드결제
	public Purchase(int user_No, String pCode, int pur_No, Date pur_Date, int pur_Price, String pur_Address,
			int pur_Type, int card_No, String card_Agency, String card_Date, int card_Pw, int del_No, char cp_Use,
			char money_Use) {
		super();
		this.user_No = user_No;
		this.pCode = pCode;
		this.pur_No = pur_No;
		this.pur_Date = pur_Date;
		this.pur_Price = pur_Price;
		this.pur_Address = pur_Address;
		this.pur_Type = pur_Type;
		this.card_No = card_No;
		this.card_Agency = card_Agency;
		this.card_Date = card_Date;
		this.card_Pw = card_Pw;
		this.del_No = del_No;
		this.cp_Use = cp_Use;
		this.money_Use = money_Use;
	}

	//휴대폰결제
	public Purchase(int user_No, String pCode, int pur_No, Date pur_Date, int pur_Price, String pur_Address,
			int pur_Type, String phone_Agency, int user_Rno, int del_No, char cp_Use, char money_Use) {
		super();
		this.user_No = user_No;
		this.pCode = pCode;
		this.pur_No = pur_No;
		this.pur_Date = pur_Date;
		this.pur_Price = pur_Price;
		this.pur_Address = pur_Address;
		this.pur_Type = pur_Type;
		this.phone_Agency = phone_Agency;
		this.user_Rno = user_Rno;
		this.del_No = del_No;
		this.cp_Use = cp_Use;
		this.money_Use = money_Use;
	}

	public int getUser_No() {
		return user_No;
	}

	public void setUser_No(int user_No) {
		this.user_No = user_No;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public int getPur_No() {
		return pur_No;
	}

	public void setPur_No(int pur_No) {
		this.pur_No = pur_No;
	}

	public Date getPur_Date() {
		return pur_Date;
	}

	public void setPur_Date(Date pur_Date) {
		this.pur_Date = pur_Date;
	}

	public int getPur_Price() {
		return pur_Price;
	}

	public void setPur_Price(int pur_Price) {
		this.pur_Price = pur_Price;
	}

	public String getPur_Address() {
		return pur_Address;
	}

	public void setPur_Address(String pur_Address) {
		this.pur_Address = pur_Address;
	}

	public int getPur_Type() {
		return pur_Type;
	}

	public void setPur_Type(int pur_Type) {
		this.pur_Type = pur_Type;
	}

	public String getPur_Bank() {
		return pur_Bank;
	}

	public void setPur_Bank(String pur_Bank) {
		this.pur_Bank = pur_Bank;
	}

	public String getPur_Account() {
		return pur_Account;
	}

	public void setPur_Account(String pur_Account) {
		this.pur_Account = pur_Account;
	}

	public int getCard_No() {
		return card_No;
	}

	public void setCard_No(int card_No) {
		this.card_No = card_No;
	}

	public String getCard_Agency() {
		return card_Agency;
	}

	public void setCard_Agency(String card_Agency) {
		this.card_Agency = card_Agency;
	}

	public String getCard_Date() {
		return card_Date;
	}

	public void setCard_Date(String card_Date) {
		this.card_Date = card_Date;
	}

	public int getCard_Pw() {
		return card_Pw;
	}

	public void setCard_Pw(int card_Pw) {
		this.card_Pw = card_Pw;
	}

	public String getPhone_Agency() {
		return phone_Agency;
	}

	public void setPhone_Agency(String phone_Agency) {
		this.phone_Agency = phone_Agency;
	}

	public int getUser_Rno() {
		return user_Rno;
	}

	public void setUser_Rno(int user_Rno) {
		this.user_Rno = user_Rno;
	}

	public int getDel_No() {
		return del_No;
	}

	public void setDel_No(int del_No) {
		this.del_No = del_No;
	}

	public char getCp_Use() {
		return cp_Use;
	}

	public void setCp_Use(char cp_Use) {
		this.cp_Use = cp_Use;
	}

	public char getMoney_Use() {
		return money_Use;
	}

	public void setMoney_Use(char money_Use) {
		this.money_Use = money_Use;
	}

	@Override
	public String toString() {
		return "Purchase [user_No=" + user_No + ", pCode=" + pCode + ", pur_No=" + pur_No + ", pur_Date=" + pur_Date
				+ ", pur_Price=" + pur_Price + ", pur_Address=" + pur_Address + ", pur_Type=" + pur_Type + ", pur_Bank="
				+ pur_Bank + ", pur_Account=" + pur_Account + ", card_No=" + card_No + ", card_Agency=" + card_Agency
				+ ", card_Date=" + card_Date + ", card_Pw=" + card_Pw + ", phone_Agency=" + phone_Agency + ", user_Rno="
				+ user_Rno + ", del_No=" + del_No + ", cp_Use=" + cp_Use + ", money_Use=" + money_Use + "]";
	}
		
}
