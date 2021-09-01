package com.flybutter.consumer.model.vo;

public class Consumer {

	private int user_No;
	private String new_Address;
	private int rec_Pno;
	private char user_Cel;
	private int money;
	
	public Consumer() {
		
	}
	
	public Consumer(int user_No, String new_Address, int rec_Pno, char user_Cel, int money) {
		super();
		this.user_No = user_No;
		this.new_Address = new_Address;
		this.rec_Pno = rec_Pno;
		this.user_Cel = user_Cel;
		this.money = money;
	}

	public int getUser_No() {
		return user_No;
	}

	public void setUser_No(int user_No) {
		this.user_No = user_No;
	}

	public String getNew_Address() {
		return new_Address;
	}

	public void setNew_Address(String new_Address) {
		this.new_Address = new_Address;
	}

	public int getRec_Pno() {
		return rec_Pno;
	}

	public void setRec_Pno(int rec_Pno) {
		this.rec_Pno = rec_Pno;
	}

	public char getUser_Cel() {
		return user_Cel;
	}

	public void setUser_Cel(char user_Cel) {
		this.user_Cel = user_Cel;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Consumer [user_No=" + user_No + ", new_Address=" + new_Address + ", rec_Pno=" + rec_Pno + ", user_Cel="
				+ user_Cel + ", money=" + money + "]";
	}
	
	
}
