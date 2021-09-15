package com.flybutter.category.model.vo;

public class Category {

	private String pCode;
	private String pImage_Origin;
	private String pName;
	private int price;
	private String score_Avg;
	private int pStock;
	private int store_No;
	private String store_Name;
	private int store_Lev;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String pCode, String pImage_Origin, String pName, int price) {
		super();
		this.pCode = pCode;
		this.pImage_Origin = pImage_Origin;
		this.pName = pName;
		this.price = price;
	}
	public Category(String pCode, String pImage_Origin, String pName, int price, String score_Avg, int pStock,
			int store_No, String store_Name, int store_Lev) {
		super();
		this.pCode = pCode;
		this.pImage_Origin = pImage_Origin;
		this.pName = pName;
		this.price = price;
		this.score_Avg = score_Avg;
		this.pStock = pStock;
		this.store_No = store_No;
		this.store_Name = store_Name;
		this.store_Lev = store_Lev;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpImage_Origin() {
		return pImage_Origin;
	}
	public void setpImage_Origin(String pImage_Origin) {
		this.pImage_Origin = pImage_Origin;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getScore_Avg() {
		return score_Avg;
	}
	public void setScore_Avg(String score_Avg) {
		this.score_Avg = score_Avg;
	}
	public int getpStock() {
		return pStock;
	}
	public void setpStock(int pStock) {
		this.pStock = pStock;
	}
	public int getStore_No() {
		return store_No;
	}
	public void setStore_No(int store_No) {
		this.store_No = store_No;
	}
	public String getStore_Name() {
		return store_Name;
	}
	public void setStore_Name(String store_Name) {
		this.store_Name = store_Name;
	}
	public int getStore_Lev() {
		return store_Lev;
	}
	public void setStore_Lev(int store_Lev) {
		this.store_Lev = store_Lev;
	}
	@Override
	public String toString() {
		return "Category [pCode=" + pCode + ", pImage_Origin=" + pImage_Origin + ", pName=" + pName + ", price=" + price
				+ ", score_Avg=" + score_Avg + ", pStock=" + pStock + ", store_No=" + store_No + ", store_Name="
				+ store_Name + ", store_Lev=" + store_Lev + "]";
	}
	
	
}
