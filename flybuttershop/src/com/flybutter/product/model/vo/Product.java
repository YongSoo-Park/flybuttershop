package com.flybutter.product.model.vo;

import java.sql.Date;

public class Product {
	
	private String pCode;
	private int store_No;
	private int pCategory;
	private String pName;
	private int pStock;
	private String pImage_Origin;
	private String pImage_System;
	private String pExp_Image_Origin;
	private String pExp_Image_System;
	private int price;
	private String pStatus;
	private Date pDate;
	private String sale_Flag;
	
	
	public Product(String pCode, int store_No, int pCategory, String pName, int pStock, String pImage_Origin,
			String pImage_System, String pExp_Image_Origin, String pExp_Image_System, int price, String pStatus,
			Date pDate, String sale_Flag) {
		super();
		this.pCode = pCode;
		this.store_No = store_No;
		this.pCategory = pCategory;
		this.pName = pName;
		this.pStock = pStock;
		this.pImage_Origin = pImage_Origin;
		this.pImage_System = pImage_System;
		this.pExp_Image_Origin = pExp_Image_Origin;
		this.pExp_Image_System = pExp_Image_System;
		this.price = price;
		this.pStatus = pStatus;
		this.pDate = pDate;
		this.sale_Flag = sale_Flag;
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



	public Product() {
		super();
		// TODO Auto-generated constructor stub
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


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
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


	public String getSale_Flag() {
		return sale_Flag;
	}


	public void setSale_Flag(String sale_Flag) {
		this.sale_Flag = sale_Flag;
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
