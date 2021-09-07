package com.flybutter.help.model.vo;

import java.sql.Date;

public class Help {
	private int help_No;	//문의글번호
	private int user_No;	//회원번호
	private int help_Category;	//문의유형_1배송/2반품교환환불/3주문결제/4회원서비스/5판매자문의
	private String help_Title;	//문의제목
	private String help_Content;	//문의내용
	private String help_File_Origin;	//문의첨부원본파일
	private String help_File_System;	//문의첨부시스템파일
	private Date help_Date;	//문의작성날짜
	private String help_status;	//답변완료여부
	private String help_Answer_Content;	//답변내용
	private Date help_Answer_Date;	//답변작성날짜
	
	
	
	public Help() {
		// TODO Auto-generated constructor stub
	}

	public Help(int help_No, int user_No, int help_Category, String help_Title, String help_Content,
			String help_File_Origin, String help_File_System, Date help_Date, String help_status,
			String help_Answer_Content, Date help_Answer_Date) {
		super();
		this.help_No = help_No;
		this.user_No = user_No;
		this.help_Category = help_Category;
		this.help_Title = help_Title;
		this.help_Content = help_Content;
		this.help_File_Origin = help_File_Origin;
		this.help_File_System = help_File_System;
		this.help_Date = help_Date;
		this.help_status = help_status;
		this.help_Answer_Content = help_Answer_Content;
		this.help_Answer_Date = help_Answer_Date;
	}

	public Help(int help_No, String help_Title, Date help_Date, String help_status) {
		super();
		this.help_No = help_No;
		this.help_Title = help_Title;
		this.help_Date = help_Date;
		this.help_status = help_status;
	}

	public Help(int help_Category, String help_Title, String help_Content, String help_File_Origin,
			String help_File_System, Date help_Date) {
		super();
		this.help_Category = help_Category;
		this.help_Title = help_Title;
		this.help_Content = help_Content;
		this.help_File_Origin = help_File_Origin;
		this.help_File_System = help_File_System;
		this.help_Date = help_Date;
	}

	public Help(int help_Category, String help_Title, String help_Content, String help_File_Origin,
			String help_File_System, Date help_Date, String help_status, String help_Answer_Content,
			Date help_Answer_Date) {
		super();
		this.help_Category = help_Category;
		this.help_Title = help_Title;
		this.help_Content = help_Content;
		this.help_File_Origin = help_File_Origin;
		this.help_File_System = help_File_System;
		this.help_Date = help_Date;
		this.help_status = help_status;
		this.help_Answer_Content = help_Answer_Content;
		this.help_Answer_Date = help_Answer_Date;
	}

	public int getHelp_No() {
		return help_No;
	}

	public void setHelp_No(int help_No) {
		this.help_No = help_No;
	}

	public int getUser_No() {
		return user_No;
	}

	public void setUser_No(int user_No) {
		this.user_No = user_No;
	}

	public int getHelp_Category() {
		return help_Category;
	}

	public void setHelp_Category(int help_Category) {
		this.help_Category = help_Category;
	}

	public String getHelp_Title() {
		return help_Title;
	}

	public void setHelp_Title(String help_Title) {
		this.help_Title = help_Title;
	}

	public String getHelp_Content() {
		return help_Content;
	}

	public void setHelp_Content(String help_Content) {
		this.help_Content = help_Content;
	}

	public String getHelp_File_Origin() {
		return help_File_Origin;
	}

	public void setHelp_File_Origin(String help_File_Origin) {
		this.help_File_Origin = help_File_Origin;
	}

	public String getHelp_File_System() {
		return help_File_System;
	}

	public void setHelp_File_System(String help_File_System) {
		this.help_File_System = help_File_System;
	}

	public Date getHelp_Date() {
		return help_Date;
	}

	public void setHelp_Date(Date help_Date) {
		this.help_Date = help_Date;
	}

	public String getHelp_status() {
		return help_status;
	}

	public void setHelp_status(String help_status) {
		this.help_status = help_status;
	}

	public String getHelp_Answer_Content() {
		return help_Answer_Content;
	}

	public void setHelp_Answer_Content(String help_Answer_Content) {
		this.help_Answer_Content = help_Answer_Content;
	}

	public Date getHelp_Answer_Date() {
		return help_Answer_Date;
	}

	public void setHelp_Answer_Date(Date help_Answer_Date) {
		this.help_Answer_Date = help_Answer_Date;
	}

	@Override
	public String toString() {
		return "Help [help_No=" + help_No + ", user_No=" + user_No + ", help_Category=" + help_Category
				+ ", help_Title=" + help_Title + ", help_Content=" + help_Content + ", help_File_Origin="
				+ help_File_Origin + ", help_File_System=" + help_File_System + ", help_Date=" + help_Date
				+ ", help_status=" + help_status + ", help_Answer_Content=" + help_Answer_Content
				+ ", help_Answer_Date=" + help_Answer_Date + "]";
	}
	
	
	

	
}
