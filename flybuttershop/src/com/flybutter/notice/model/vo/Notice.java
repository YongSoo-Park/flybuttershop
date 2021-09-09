package com.flybutter.notice.model.vo;

import java.sql.Date;

public class Notice {
	
	private int notice_No;	//공지사항번호
	private int notice_Category;	//공지사항유형1공지/2이벤트
	private String notice_Title;	//공지사항제목
	private String notice_Content;	//공지사항내용
	private String notice_File_Origin;	//공지사항첨부원본파일
	private String notice_File_System;	//공지사항첨부시스템파일
	private Date notice_Date;	//작성날짜
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(int notice_No, int notice_Category, String notice_Title, String notice_Content,
			String notice_File_Origin, String notice_File_System, Date notice_Date) {
		super();
		this.notice_No = notice_No;
		this.notice_Category = notice_Category;
		this.notice_Title = notice_Title;
		this.notice_Content = notice_Content;
		this.notice_File_Origin = notice_File_Origin;
		this.notice_File_System = notice_File_System;
		this.notice_Date = notice_Date;
	}

	public Notice(int notice_No, int notice_Category, String notice_Title) {
		super();
		this.notice_No = notice_No;
		this.notice_Category = notice_Category;
		this.notice_Title = notice_Title;
	}

	public Notice(int notice_Category, String notice_Title) {
		super();
		this.notice_Category = notice_Category;
		this.notice_Title = notice_Title;
	}

	public Notice(int notice_Category, String notice_Title, String notice_Content, String notice_File_Origin,
			String notice_File_System, Date notice_Date) {
		super();
		this.notice_Category = notice_Category;
		this.notice_Title = notice_Title;
		this.notice_Content = notice_Content;
		this.notice_File_Origin = notice_File_Origin;
		this.notice_File_System = notice_File_System;
		this.notice_Date = notice_Date;
	}

	public int getNotice_No() {
		return notice_No;
	}

	public void setNotice_No(int notice_No) {
		this.notice_No = notice_No;
	}

	public int getNotice_Category() {
		return notice_Category;
	}

	public void setNotice_Category(int notice_Category) {
		this.notice_Category = notice_Category;
	}

	public String getNotice_Title() {
		return notice_Title;
	}

	public void setNotice_Title(String notice_Title) {
		this.notice_Title = notice_Title;
	}

	public String getNotice_Content() {
		return notice_Content;
	}

	public void setNotice_Content(String notice_Content) {
		this.notice_Content = notice_Content;
	}

	public String getNotice_File_Origin() {
		return notice_File_Origin;
	}

	public void setNotice_File_Origin(String notice_File_Origin) {
		this.notice_File_Origin = notice_File_Origin;
	}

	public String getNotice_File_System() {
		return notice_File_System;
	}

	public void setNotice_File_System(String notice_File_System) {
		this.notice_File_System = notice_File_System;
	}

	public Date getNotice_Date() {
		return notice_Date;
	}

	public void setNotice_Date(Date notice_Date) {
		this.notice_Date = notice_Date;
	}

	@Override
	public String toString() {
		return "Notice [notice_No=" + notice_No + ", notice_Category=" + notice_Category + ", notice_Title="
				+ notice_Title + ", notice_Content=" + notice_Content + ", notice_File_Origin=" + notice_File_Origin
				+ ", notice_File_System=" + notice_File_System + ", notice_Date=" + notice_Date + "]";
	}
	
	
	
	
	
	
	
}
