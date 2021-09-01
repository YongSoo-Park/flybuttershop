package com.flybutter.review.model.vo;

import java.util.Date;

public class Review {

	private int re_no;
	private String pCode;
	private int user_no;
	private String re_title;
	private String re_content;
	private Date re_date;
	private String re_originFile;
	private String re_changeFile;
	private char re_status;
	private String rere_title;
	private String rere_content;
	private Date rere_date;
	private int store_no;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int re_no, String pCode, int user_no, String re_title, String re_content, Date re_date,
			String re_originFile, String re_changeFile, char re_status, String rere_title, String rere_content,
			Date rere_date, int store_no) {
		super();
		this.re_no = re_no;
		this.pCode = pCode;
		this.user_no = user_no;
		this.re_title = re_title;
		this.re_content = re_content;
		this.re_date = re_date;
		this.re_originFile = re_originFile;
		this.re_changeFile = re_changeFile;
		this.re_status = re_status;
		this.rere_title = rere_title;
		this.rere_content = rere_content;
		this.rere_date = rere_date;
		this.store_no = store_no;
	}

	public Review(int re_no, char re_status, String rere_title, String rere_content, Date rere_date, int store_no) {
		super();
		this.re_no = re_no;
		this.re_status = re_status;
		this.rere_title = rere_title;
		this.rere_content = rere_content;
		this.rere_date = rere_date;
		this.store_no = store_no;
	}

	public Review(int re_no, String pCode, int user_no, String re_title, String re_content, Date re_date,
			String re_originFile, String re_changeFile, char re_status) {
		super();
		this.re_no = re_no;
		this.pCode = pCode;
		this.user_no = user_no;
		this.re_title = re_title;
		this.re_content = re_content;
		this.re_date = re_date;
		this.re_originFile = re_originFile;
		this.re_changeFile = re_changeFile;
		this.re_status = re_status;
	}

	public int getRe_no() {
		return re_no;
	}

	public void setRe_no(int re_no) {
		this.re_no = re_no;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getRe_title() {
		return re_title;
	}

	public void setRe_title(String re_title) {
		this.re_title = re_title;
	}

	public String getRe_content() {
		return re_content;
	}

	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}

	public Date getRe_date() {
		return re_date;
	}

	public void setRe_date(Date re_date) {
		this.re_date = re_date;
	}

	public String getRe_originFile() {
		return re_originFile;
	}

	public void setRe_originFile(String re_originFile) {
		this.re_originFile = re_originFile;
	}

	public String getRe_changeFile() {
		return re_changeFile;
	}

	public void setRe_changeFile(String re_changeFile) {
		this.re_changeFile = re_changeFile;
	}

	public char getRe_status() {
		return re_status;
	}

	public void setRe_status(char re_status) {
		this.re_status = re_status;
	}

	public String getRere_title() {
		return rere_title;
	}

	public void setRere_title(String rere_title) {
		this.rere_title = rere_title;
	}

	public String getRere_content() {
		return rere_content;
	}

	public void setRere_content(String rere_content) {
		this.rere_content = rere_content;
	}

	public Date getRere_date() {
		return rere_date;
	}

	public void setRere_date(Date rere_date) {
		this.rere_date = rere_date;
	}

	public int getStore_no() {
		return store_no;
	}

	public void setStore_no(int store_no) {
		this.store_no = store_no;
	}

	@Override
	public String toString() {
		return "Review [re_no=" + re_no + ", pCode=" + pCode + ", user_no=" + user_no + ", re_title=" + re_title
				+ ", re_content=" + re_content + ", re_date=" + re_date + ", re_originFile=" + re_originFile
				+ ", re_changeFile=" + re_changeFile + ", re_status=" + re_status + ", rere_title=" + rere_title
				+ ", rere_content=" + rere_content + ", rere_date=" + rere_date + ", store_no=" + store_no + "]";
	}
	
	
	
	
	
	
	
}
