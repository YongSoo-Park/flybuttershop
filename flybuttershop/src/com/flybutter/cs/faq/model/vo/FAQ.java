package com.flybutter.cs.faq.model.vo;

public class FAQ {
	
	private int faq_No;	//FAQ번호
	private int faq_Category;	//FAQ유형_1배송/2반품교환환불/3주문결제/4회원서비스/5판매자문의
	private String faq_Title;	//	FAQ제목
	private String faq_Content;	//	FAQ내용
	
	public FAQ() {
		// TODO Auto-generated constructor stub
	}

	public FAQ(int faq_No, int faq_Category, String faq_Title, String faq_Content) {
		super();
		this.faq_No = faq_No;
		this.faq_Category = faq_Category;
		this.faq_Title = faq_Title;
		this.faq_Content = faq_Content;
	}

	public FAQ(int faq_Category, String faq_Title, String faq_Content) {
		super();
		this.faq_Category = faq_Category;
		this.faq_Title = faq_Title;
		this.faq_Content = faq_Content;
	}

	public int getFaq_No() {
		return faq_No;
	}

	public void setFaq_No(int faq_No) {
		this.faq_No = faq_No;
	}

	public int getFaq_Category() {
		return faq_Category;
	}

	public void setFaq_Category(int faq_Category) {
		this.faq_Category = faq_Category;
	}

	public String getFaq_Title() {
		return faq_Title;
	}

	public void setFaq_Title(String faq_Title) {
		this.faq_Title = faq_Title;
	}

	public String getFaq_Content() {
		return faq_Content;
	}

	public void setFaq_Content(String faq_Content) {
		this.faq_Content = faq_Content;
	}

	@Override
	public String toString() {
		return "FAQ [faq_No=" + faq_No + ", faq_Category=" + faq_Category + ", faq_Title=" + faq_Title
				+ ", faq_Content=" + faq_Content + "]";
	}
	
	

}
