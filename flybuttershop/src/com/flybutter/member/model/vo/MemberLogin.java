package com.flybutter.member.model.vo;

import java.sql.Date;

public class MemberLogin {

	private int MEM_USER_NO;
	private String MEM_USER_NAME;
	private int MEM_LEV;
	private int MEM_CATEGORY;
	private String REC_PNO;
	private int MONEY;


	

	public MemberLogin() {}
	


	public MemberLogin(int MEM_USER_NO, String MEM_USER_NAME,  int MEM_LEV, int MEM_CATEGORY,String REC_PNO, int MONEY) {
								
				this.MEM_USER_NO = MEM_USER_NO;
				this.MEM_USER_NAME = MEM_USER_NAME;
				this.MEM_LEV = MEM_LEV;
				this.MEM_CATEGORY = MEM_CATEGORY;	
				this.REC_PNO = REC_PNO;
				this.MONEY = MONEY;
			}



	public int getMEM_USER_NO() {
		return MEM_USER_NO;
	}



	public void setMEM_USER_NO(int MEM_USER_NO) {
		this.MEM_USER_NO = MEM_USER_NO;
	}



	public String getMEM_USER_NAME() {
		return MEM_USER_NAME;
	}



	public void setMEM_USER_NAME(String MEM_USER_NAME) {
		this.MEM_USER_NAME = MEM_USER_NAME;
	}



	public int getMEM_LEV() {
		return MEM_LEV;
	}



	public void setMEM_LEV(int MEM_LEV) {
		this.MEM_LEV = MEM_LEV;
	}



	public int getMEM_CATEGORY() {
		return MEM_CATEGORY;
	}



	public void setMEM_CATEGORY(int MEM_CATEGORY) {
		this.MEM_CATEGORY = MEM_CATEGORY;
	}



	public String getREC_PNO() {
		return REC_PNO;
	}



	public void setREC_PNO(String REC_PNO) {
		this.REC_PNO = REC_PNO;
	}



	public int getMONEY() {
		return MONEY;
	}


	public void setMONEY(int MONEY) {
		this.MONEY = MONEY;
	}



	@Override
	public String toString() {
		return "MemberLogin [MEM_USER_NO=" + MEM_USER_NO + ", MEM_USER_NAME=" + MEM_USER_NAME + ", MEM_LEV=" + MEM_LEV
				+ ", MEM_CATEGORY=" + MEM_CATEGORY + ", REC_PNO=" + REC_PNO + ", MONEY=" + MONEY + "]";
	}


}
