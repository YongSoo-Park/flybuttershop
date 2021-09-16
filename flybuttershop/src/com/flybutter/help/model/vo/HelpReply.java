package com.flybutter.help.model.vo;

import java.sql.Date;

public class HelpReply {
	
	private int reply_No;
	private String reply_Content;
	private Date reply_Date;
	private int help_No;
	
	public HelpReply() {
		// TODO Auto-generated constructor stub
	}

	public HelpReply(int reply_No, String reply_Content, Date reply_Date, int help_No) {
		super();
		this.reply_No = reply_No;
		this.reply_Content = reply_Content;
		this.reply_Date = reply_Date;
		this.help_No = help_No;
	}

	public int getReply_No() {
		return reply_No;
	}

	public void setReply_No(int reply_No) {
		this.reply_No = reply_No;
	}

	public String getReply_Content() {
		return reply_Content;
	}

	public void setReply_Content(String reply_Content) {
		this.reply_Content = reply_Content;
	}

	public Date getReply_Date() {
		return reply_Date;
	}

	public void setReply_Date(Date reply_Date) {
		this.reply_Date = reply_Date;
	}

	public int getHelp_No() {
		return help_No;
	}

	public void setHelp_No(int help_No) {
		this.help_No = help_No;
	}

	@Override
	public String toString() {
		return "HelpReply [reply_No=" + reply_No + ", reply_Content=" + reply_Content + ", reply_Date=" + reply_Date
				+ ", help_No=" + help_No + "]";
	}
	
	
}
