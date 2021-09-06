package com.flybutter.dummy.model.vo;

public class Member {

	private int MEM_USER_NO;
	private String MEM_USER_ID;
	private String MEM_USER_PWD;
	private String MEM_USER_NAME;
	private String MEM_PHONE;
	private String MEM_EMAIL;
	private String MEM_ADDRESS;
	private int MEM_LEV;
	private String MEM_STATUS;
	private int MEM_CATEGORY;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(int mEM_USER_NO, String mEM_USER_ID, String mEM_USER_PWD, String mEM_USER_NAME, String mEM_PHONE,
			String mEM_EMAIL, String mEM_ADDRESS, int mEM_LEV, String mEM_STATUS, int mEM_CATEGORY) {
		super();
		MEM_USER_NO = mEM_USER_NO;
		MEM_USER_ID = mEM_USER_ID;
		MEM_USER_PWD = mEM_USER_PWD;
		MEM_USER_NAME = mEM_USER_NAME;
		MEM_PHONE = mEM_PHONE;
		MEM_EMAIL = mEM_EMAIL;
		MEM_ADDRESS = mEM_ADDRESS;
		MEM_LEV = mEM_LEV;
		MEM_STATUS = mEM_STATUS;
		MEM_CATEGORY = mEM_CATEGORY;
	}

	
	public Member(int mEM_USER_NO, String mEM_USER_NAME, int mEM_LEV, int mEM_CATEGORY) {
		super();
		MEM_USER_NO = mEM_USER_NO;
		MEM_USER_NAME = mEM_USER_NAME;
		MEM_LEV = mEM_LEV;
		MEM_CATEGORY = mEM_CATEGORY;
	}

	public int getMEM_USER_NO() {
		return MEM_USER_NO;
	}

	public void setMEM_USER_NO(int mEM_USER_NO) {
		MEM_USER_NO = mEM_USER_NO;
	}

	public String getMEM_USER_ID() {
		return MEM_USER_ID;
	}

	public void setMEM_USER_ID(String mEM_USER_ID) {
		MEM_USER_ID = mEM_USER_ID;
	}

	public String getMEM_USER_PWD() {
		return MEM_USER_PWD;
	}

	public void setMEM_USER_PWD(String mEM_USER_PWD) {
		MEM_USER_PWD = mEM_USER_PWD;
	}

	public String getMEM_USER_NAME() {
		return MEM_USER_NAME;
	}

	public void setMEM_USER_NAME(String mEM_USER_NAME) {
		MEM_USER_NAME = mEM_USER_NAME;
	}

	public String getMEM_PHONE() {
		return MEM_PHONE;
	}

	public void setMEM_PHONE(String mEM_PHONE) {
		MEM_PHONE = mEM_PHONE;
	}

	public String getMEM_EMAIL() {
		return MEM_EMAIL;
	}

	public void setMEM_EMAIL(String mEM_EMAIL) {
		MEM_EMAIL = mEM_EMAIL;
	}

	public String getMEM_ADDRESS() {
		return MEM_ADDRESS;
	}

	public void setMEM_ADDRESS(String mEM_ADDRESS) {
		MEM_ADDRESS = mEM_ADDRESS;
	}

	public int getMEM_LEV() {
		return MEM_LEV;
	}

	public void setMEM_LEV(int mEM_LEV) {
		MEM_LEV = mEM_LEV;
	}

	public String getMEM_STATUS() {
		return MEM_STATUS;
	}

	public void setMEM_STATUS(String mEM_STATUS) {
		MEM_STATUS = mEM_STATUS;
	}

	public int getMEM_CATEGORY() {
		return MEM_CATEGORY;
	}

	public void setMEM_CATEGORY(int mEM_CATEGORY) {
		MEM_CATEGORY = mEM_CATEGORY;
	}

	@Override
	public String toString() {
		return "Member [MEM_USER_NO=" + MEM_USER_NO + ", MEM_USER_ID=" + MEM_USER_ID + ", MEM_USER_PWD=" + MEM_USER_PWD
				+ ", MEM_USER_NAME=" + MEM_USER_NAME + ", MEM_PHONE=" + MEM_PHONE + ", MEM_EMAIL=" + MEM_EMAIL
				+ ", MEM_ADDRESS=" + MEM_ADDRESS + ", MEM_LEV=" + MEM_LEV + ", MEM_STATUS=" + MEM_STATUS
				+ ", MEM_CATEGORY=" + MEM_CATEGORY + "]";
	}

}
