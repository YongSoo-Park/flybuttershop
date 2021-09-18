package com.flybutter.purchase.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.consumer.model.service.ConsumerService;
import com.flybutter.dummy.model.vo.Member;
import com.flybutter.purchase.model.service.PurchaseService;
import com.flybutter.purchase.model.vo.Purchase;
import com.flybutter.seller.model.service.SellerService;
import com.flybutter.seller.model.vo.Seller;

/**
 * Servlet implementation class InsertPurchaseServlet
 */
@WebServlet("/insertPur.hy")
public class InsertPurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPurchaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
//		USER_NO	NUMBER o
//		PUR_NO	NUMBER <시퀀스 o 
//		PUR_DATE	DATE <디폴트 o
//		PUR_PRICE	NUMBER < 결제금액 o
//		PUR_ADDRESS	VARCHAR2(100 BYTE) <바뀐주소면 바뀐주소로 o
//		PUR_TYPE	NUMBER <라디오 버튼에 따라 들어가게 o
//		PUR_BANK	VARCHAR2(50 BYTE) <은행 o
//		PUR_ACCOUNT	VARCHAR2(50 BYTE) <계좌번호 o
//		CARD_NO	VARCHAR2(20 BYTE) <카드번호 o
//		CARD_AGENCY	VARCHAR2(50 BYTE) <카드사 o
//		CARD_DATE	VARCHAR2(10 BYTE) <할부개월 o
//		DEL_NO	NUMBER <운송장번호 널값으로 
//		CP_USE	CHAR(1 BYTE) <쿠폰사용하면 Y
//		MONEY_USE	CHAR(1 BYTE) <적립금사용하면 Y
//		PUR_INFO	VARCHAR2(1000 BYTE) <상품코드:상점번호:상품수량:옵션:1 o
		
		Member loginM = (Member)request.getSession().getAttribute("loginMember");
		Purchase p = new Purchase();
		
		int no = loginM.getMEM_USER_NO();
		String pCode = request.getParameter("pCode");
		String newAddress = request.getParameter("newAdr");
		int purType = Integer.parseInt(request.getParameter("purType"));
		String pImg = request.getParameter("pImg");
		String pName = request.getParameter("pName");
		String option = request.getParameter("pOption");
		String sName = request.getParameter("sName");
		int pAmount = Integer.parseInt(request.getParameter("pAmount"));
		int resultPrice = Integer.parseInt(request.getParameter("resultPrice"));
		
		
		//상점번호 찾기
		SellerService ss = new SellerService();
		Seller s = ss.selectStore(sName);
		
		//주문정보 생성
		String purInfo = pCode + ":" + s.getStore_No() + ":" + pAmount + ":" + option + ":" + 1;
		
//		p.setUser_No(loginM.getMEM_USER_NO());
//		p.setpCode(pCode);
//		p.setPur_Image(pImg);
//		p.setPur_Pname(pName);
//		p.setPur_POption(option);
//		p.setPur_Price(price);
//		p.setPur_Amount(pAmount);
//		p.setPur_SName(sName);
		
		//새로운 주소 입력
		if(newAddress != null) {	
			int addResult = new ConsumerService().updateAdd(no, newAddress);
		}
		
		//결제수단
		if(purType == 1) { //무통장결제
			String bank = request.getParameter("bank");
			String accNo = ""; 
	        
	        for(int i=0;i<13;i++) {
	        	Random rand = new Random();
	            String ran = Integer.toString(rand.nextInt(10));
	            
	            if(i == 3 || i == 6) {
	            	ran += "-";
	            }
	            accNo += ran;
	        }
			
		}else if(purType == 2) { //카드결제
			String card = request.getParameter("card");
			String cDate = request.getParameter("cDate");
			String cardNo = request.getParameter("cardNo");
		}
		
		//적립금
		int plusMoney = (int) (resultPrice * 0.01);
		
		
		
		
		//사용한 쿠폰
		
		
		//사용한 적립금
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
