package com.flybutter.qna.model.vo;

import java.sql.Date;

public class Qna {
	
	private int qna_No;
	private int user_No;
	private String pCode;
	private int store_no;
	private int qna_Pwd;
	private int qna_Category;
	private String qna_Title;
	private String qna_Content;
	private Date qna_Date;
	private String qna_Status;
	private int lock_Flag;
	private String qna_Comment;
	private Date qna_Comment_Date;
	
	public Qna() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Qna(int qna_No, int user_No, String pCode, int store_no, int qna_Pwd, int qna_Category, String qna_Title,
			String qna_Content, Date qna_Date, String qna_Status, int lock_Flag, String qna_Comment,
			Date qna_Comment_Date) {
		super();
		this.qna_No = qna_No;
		this.user_No = user_No;
		this.pCode = pCode;
		this.store_no = store_no;
		this.qna_Pwd = qna_Pwd;
		this.qna_Category = qna_Category;
		this.qna_Title = qna_Title;
		this.qna_Content = qna_Content;
		this.qna_Date = qna_Date;
		this.qna_Status = qna_Status;
		this.lock_Flag = lock_Flag;
		this.qna_Comment = qna_Comment;
		this.qna_Comment_Date = qna_Comment_Date;
	}





	public int getQna_No() {
		return qna_No;
	}


	public void setQna_No(int qna_No) {
		this.qna_No = qna_No;
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


	public int getStore_no() {
		return store_no;
	}


	public void setStore_no(int store_no) {
		this.store_no = store_no;
	}


	public int getQna_Pwd() {
		return qna_Pwd;
	}


	public void setQna_Pwd(int qna_Pwd) {
		this.qna_Pwd = qna_Pwd;
	}


	public int getQna_Category() {
		return qna_Category;
	}


	public void setQna_Category(int qna_Category) {
		this.qna_Category = qna_Category;
	}


	public String getQna_Title() {
		return qna_Title;
	}


	public void setQna_Title(String qna_Title) {
		this.qna_Title = qna_Title;
	}


	public String getQna_Content() {
		return qna_Content;
	}


	public void setQna_Content(String qna_Content) {
		this.qna_Content = qna_Content;
	}


	public Date getQna_Date() {
		return qna_Date;
	}


	public void setQna_Date(Date qna_Date) {
		this.qna_Date = qna_Date;
	}


	public String getQna_Status() {
		return qna_Status;
	}


	public void setQna_Status(String qna_Status) {
		this.qna_Status = qna_Status;
	}


	public int getLock_Flag() {
		return lock_Flag;
	}


	public void setLock_Flag(int lock_Flag) {
		this.lock_Flag = lock_Flag;
	}


	public String getQna_Comment() {
		return qna_Comment;
	}


	public void setQna_Comment(String qna_Comment) {
		this.qna_Comment = qna_Comment;
	}


	public Date getQna_Comment_Date() {
		return qna_Comment_Date;
	}


	public void setQna_Comment_Date(Date qna_Comment_Date) {
		this.qna_Comment_Date = qna_Comment_Date;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "qna_No : " + qna_No + ", user_No : " + user_No + ", pCode : " + pCode + ", store_no : " + store_no 
				+ ", qna_Pwd : " + qna_Pwd + ", qna_Category : " + qna_Category + ", qna_Title : " + qna_Title
				+ ", qna_Content : " + qna_Content + ", qna_Date : " + qna_Date + ", qna_Status : " + qna_Status
				+ ", lock_Flag : " + lock_Flag + ", qna_Comment :  " + qna_Comment + ", qna_Comment_Date : " + qna_Comment_Date;
	}
	
	
	
	

}
