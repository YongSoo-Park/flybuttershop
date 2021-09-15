package com.flybutter.mainpage.model.vo;

public class Mainpage {

	private String event_Img_Ori;
	private String event_Img_Sys;
	private int dISCOUNT_RATE;
	private String pCODE;
	private String pImage_Origin;
	private String pName;
	private int price;
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Mainpage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mainpage(String event_Img_Ori, String event_Img_Sys) {
		super();
		this.event_Img_Ori = event_Img_Ori;
		this.event_Img_Sys = event_Img_Sys;
	}

	public Mainpage(int dISCOUNT_RATE, String pCODE, String pName, String pImage_Origin) {
		super();
		this.dISCOUNT_RATE = dISCOUNT_RATE;
		this.pCODE = pCODE;
		this.pName = pName;
		this.pImage_Origin = pImage_Origin;
	}

	public Mainpage(String pCODE, String pName, String pImage_Origin) {
		super();
		this.pCODE = pCODE;
		this.pName = pName;
		this.pImage_Origin = pImage_Origin;
	}
	
	

	public Mainpage(String pCODE, String pImage_Origin, String pName, int price) {
		super();
		this.pCODE = pCODE;
		this.pImage_Origin = pImage_Origin;
		this.pName = pName;
		this.price = price;
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

	public int getdISCOUNT_RATE() {
		return dISCOUNT_RATE;
	}

	public void setdISCOUNT_RATE(int dISCOUNT_RATE) {
		this.dISCOUNT_RATE = dISCOUNT_RATE;
	}

	public String getpCODE() {
		return pCODE;
	}

	public void setpCODE(String pCODE) {
		this.pCODE = pCODE;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpImage_Origin() {
		return pImage_Origin;
	}

	public void setpImage_Origin(String pImage_Origin) {
		this.pImage_Origin = pImage_Origin;
	}

	@Override
	public String toString() {
		return "Mainpage [event_Img_Ori=" + event_Img_Ori + ", event_Img_Sys=" + event_Img_Sys + ", dISCOUNT_RATE="
				+ dISCOUNT_RATE + ", pCODE=" + pCODE + ", pName=" + pName + ", pImage_Origin=" + pImage_Origin + "]";
	}

	

	
	

}