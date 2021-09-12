package com.flybutter.product.model.vo;

import java.sql.Date;

public class Product {
	
	private String pCode;
	private int store_No;
	private int pCategory;
	private int pCategory2;
	private String pName;
	private String pOption;
	private int pStock;
	private String pImage_Origin;
	private String pImage_System;
	private String pExp_Image_Origin;
	private String pExp_Image_System;
	private int price;
	private String pStatus;
	private Date pDate;
	private int sale_Flag;
	private String score_Avg;
	private int score_Count;
	

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Product(String pCode, int store_No, int pCategory, int pCategory2, String pName, String pOption, int pStock,
			String pImage_Origin, String pImage_System, String pExp_Image_Origin, String pExp_Image_System, int price,
			String pStatus, Date pDate, int sale_Flag, String score_Avg, int score_Count) {
		super();
		this.pCode = pCode;
		this.store_No = store_No;
		this.pCategory = pCategory;
		this.pCategory2 = pCategory2;
		this.pName = pName;
		this.pOption = pOption;
		this.pStock = pStock;
		this.pImage_Origin = pImage_Origin;
		this.pImage_System = pImage_System;
		this.pExp_Image_Origin = pExp_Image_Origin;
		this.pExp_Image_System = pExp_Image_System;
		this.price = price;
		this.pStatus = pStatus;
		this.pDate = pDate;
		this.sale_Flag = sale_Flag;
		this.score_Avg = score_Avg;
		this.score_Count = score_Count;
	}


	public Product(String pName, String pImage_Origin) {
		this.pName = pName;
		this.pImage_Origin = pImage_Origin;
	}
	
	public Product(String pCode, String pName, String pImage_Origin) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.pImage_Origin = pImage_Origin;
	}



	public Product(String pCode, String pName, String pOption, String pImage_Origin, int price, String pStatus, int sale_Flag) {
		this.pCode = pCode;
		this.pName = pName;
		this.pOption = pOption;
		this.pImage_Origin = pImage_Origin;
		this.price = price;
		this.pStatus = pStatus;
		this.sale_Flag = sale_Flag;
	}


	public Product(String pCode, int pCategory, int pCategory2, String pName, String pOption, int price, int pStock,
			String pImage_Origin, String pImage_System, String pExp_Image_Origin, String pExp_Image_System,
			String pStatus, Date pDate, int sale_Flag, String score_Avg) {
		this.pCode = pCode;
		this.pCategory = pCategory;
		this.pCategory2 = pCategory2;
		this.pName = pName;
		this.pOption = pOption;
		this.pStock = pStock;
		this.pImage_Origin = pImage_Origin;
		this.pImage_System = pImage_System;
		this.pExp_Image_Origin = pExp_Image_Origin;
		this.pExp_Image_System = pExp_Image_System;
		this.price = price;
		this.pStatus = pStatus;
		this.pDate = pDate;
		this.sale_Flag = sale_Flag;
		this.score_Avg = score_Avg;
	}


	public Product(String pCode, int pCategory, int pCategory2, String pName, String pOption, int price, int pStock, Date pDate,
			String pStatus, int sale_Flag) {
		this.pCode = pCode;
		this.pCategory = pCategory;
		this.pCategory2 = pCategory2;
		this.pName = pName;
		this.pOption = pOption;
		this.pStock = pStock;
		this.price = price;
		this.pStatus = pStatus;
		this.pDate = pDate;
		this.sale_Flag = sale_Flag;
	}


	public String getpCode() {
		return pCode;
	}


	public void setpCode(String pCode) {
		this.pCode = pCode;
	}


	public int getStore_No() {
		return store_No;
	}


	public void setStore_No(int store_No) {
		this.store_No = store_No;
	}


	public int getpCategory() {
		return pCategory;
	}


	public void setpCategory(int pCategory) {
		this.pCategory = pCategory;
	}


	public int getpCategory2() {
		return pCategory2;
	}


	public void setpCategory2(int pCategory2) {
		this.pCategory2 = pCategory2;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public String getpOption() {
		return pOption;
	}


	public void setpOption(String pOption) {
		this.pOption = pOption;
	}


	public int getpStock() {
		return pStock;
	}


	public void setpStock(int pStock) {
		this.pStock = pStock;
	}


	public String getpImage_Origin() {
		return pImage_Origin;
	}


	public void setpImage_Origin(String pImage_Origin) {
		this.pImage_Origin = pImage_Origin;
	}


	public String getpImage_System() {
		return pImage_System;
	}


	public void setpImage_System(String pImage_System) {
		this.pImage_System = pImage_System;
	}


	public String getpExp_Image_Origin() {
		return pExp_Image_Origin;
	}


	public void setpExp_Image_Origin(String pExp_Image_Origin) {
		this.pExp_Image_Origin = pExp_Image_Origin;
	}


	public String getpExp_Image_System() {
		return pExp_Image_System;
	}


	public void setpExp_Image_System(String pExp_Image_System) {
		this.pExp_Image_System = pExp_Image_System;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getpStatus() {
		return pStatus;
	}


	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}


	public Date getpDate() {
		return pDate;
	}


	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}


	public int getSale_Flag() {
		return sale_Flag;
	}


	public void setSale_Flag(int sale_Flag) {
		this.sale_Flag = sale_Flag;
	}


	public String getScore_Avg() {
		return score_Avg;
	}


	public void setScore_Avg(String score_Avg) {
		this.score_Avg = score_Avg;
	}


	public int getScore_Count() {
		return score_Count;
	}


	public void setScore_Count(int score_Count) {
		this.score_Count = score_Count;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "pCode : " + pCode + ", store_No : " + store_No + ", pCategory : " + pCategory + ", pName : " + pName 
				+ ", pStock : " + pStock + ", pImage_Origin : " + pImage_Origin +
				", pImage_System : " + pImage_System + ", pExp_Image_Origin : " + pExp_Image_Origin
				+ ", pExp_Image_System : " + pExp_Image_System + ", price : " + price 
				+ ", pStatus : " + pStatus + ", pDate : " + pDate + ", sale_Flag : " + sale_Flag;
	}
	
	

}
