package com.flybutter.main_search_category_page.model.vo;

import java.util.Date;

public class Mainpage {

	private int kind_View;
	private String event_Img_Ori;
	private String event_Img_Sys;
	private int discount_Rate;
	private String sale_P_Word;
	private String new_P_Word;
	private String pcode;

	public Mainpage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mainpage(int kind_View, String event_Img_Ori, String event_Img_Sys, int discount_Rate, String sale_P_Word,
			String new_P_Word, String pcode) {
		super();
		this.kind_View = kind_View;
		this.event_Img_Ori = event_Img_Ori;
		this.event_Img_Sys = event_Img_Sys;
		this.discount_Rate = discount_Rate;
		this.sale_P_Word = sale_P_Word;
		this.new_P_Word = new_P_Word;
		this.pcode = pcode;
	}

	public Mainpage(int kind_View, String event_Img_Ori, String event_Img_Sys) {
		super();
		this.kind_View = kind_View;
		this.event_Img_Ori = event_Img_Ori;
		this.event_Img_Sys = event_Img_Sys;
	}

	public Mainpage(int kind_View, int discount_Rate, String sale_P_Word, String pcode) {
		super();
		this.kind_View = kind_View;
		this.discount_Rate = discount_Rate;
		this.sale_P_Word = sale_P_Word;
		this.pcode = pcode;
	}

	public Mainpage(String new_P_Word, String pcode, int kind_View) {
		super();
		this.kind_View = kind_View;
		this.new_P_Word = new_P_Word;
		this.pcode = pcode;
	}

	public int getKind_View() {
		return kind_View;
	}

	public void setKind_View(int kind_View) {
		this.kind_View = kind_View;
	}

	public String getEvent_Img_Ori() {
		return event_Img_Ori;
	}

	public void setEvent_Img_Ori(String event_Img_Ori) {
		this.event_Img_Ori = event_Img_Ori;
	}

	public String getEvent_Img_Sys() {
		return event_Img_Sys;
	}

	public void setEvent_Img_Sys(String event_Img_Sys) {
		this.event_Img_Sys = event_Img_Sys;
	}

	public int getDiscount_Rate() {
		return discount_Rate;
	}

	public void setDiscount_Rate(int discount_Rate) {
		this.discount_Rate = discount_Rate;
	}

	public String getSale_P_Word() {
		return sale_P_Word;
	}

	public void setSale_P_Word(String sale_P_Word) {
		this.sale_P_Word = sale_P_Word;
	}

	public String getNew_P_Word() {
		return new_P_Word;
	}

	public void setNew_P_Word(String new_P_Word) {
		this.new_P_Word = new_P_Word;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	@Override
	public String toString() {
		return "Mainpage [kind_View=" + kind_View + ", event_Img_Ori=" + event_Img_Ori + ", event_Img_Sys="
				+ event_Img_Sys + ", discount_Rate=" + discount_Rate + ", sale_P_Word=" + sale_P_Word + ", new_P_Word="
				+ new_P_Word + ", pcode=" + pcode + "]";
	}

}
