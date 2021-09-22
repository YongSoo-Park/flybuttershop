package com.flybutter.purchase.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.consumer.model.service.ConsumerService;
import com.flybutter.consumer.model.vo.Consumer;
import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.consumerMyPage.model.vo.OrderInfo;
import com.flybutter.coupon.model.vo.Coupon;
import com.flybutter.member.model.vo.Member;
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
		
		Purchase bankPur = new Purchase();
		Purchase cardPur = new Purchase();
	
		Member loginM = (Member)request.getSession().getAttribute("loginMember");
		int no = loginM.getUserNo();
		bankPur.setUser_No(no);
		cardPur.setUser_No(no);
		
		//결제한 상품 이름
		String pName = request.getParameter("pName");
		
		//결제한 상품 갯수
		int bAmo = Integer.parseInt(request.getParameter("bAmo"));
		
		//상품명 가공
		String purName = "";
		if(bAmo > 1) {
			purName = pName + " 외 " + (bAmo-1) + "종";	
		}else if (bAmo == 1){
			purName = pName;
		}
		request.setAttribute("purName", purName);
		
		//결제수단 번호
		int purType = Integer.parseInt(request.getParameter("purType"));
		bankPur.setPur_Type(purType);
		cardPur.setPur_Type(purType);
		
		//주문최종금액 (쿠폰,적립금 할인제외금액)
		int resultPrice = Integer.parseInt(request.getParameter("resultPrice"));
//		int sumResult = new MypageService().updateSumPrice(no, resultPrice);
		
		//주문정보
		String purInfo = request.getParameter("purInfo");
		if(purInfo == null) {//주문
			String pCode = request.getParameter("pCode");
			String pImg = request.getParameter("pImg");
			String option = request.getParameter("pOption");
			String sName = request.getParameter("sName");
			int pAmount = Integer.parseInt(request.getParameter("pAmount"));
			
			//상점번호 찾기
			SellerService ss = new SellerService();
			Seller s = ss.selectStore(sName);
			
			//주문정보 생성
			purInfo = pCode + ":" + s.getStore_No() + ":" + pAmount + ":" + option + ":" + 1;
			bankPur.setPur_Info(purInfo);
			cardPur.setPur_Info(purInfo);
			
		}else {//장바구니 주문
			bankPur.setPur_Info(purInfo);
			cardPur.setPur_Info(purInfo);
		}
		
		//새로운 주소 입력
		String newAddress = request.getParameter("newAdr");
		if(! newAddress.isEmpty()) {	
			int addResult = new ConsumerService().updateAdd(no, newAddress);
			bankPur.setPur_Address(newAddress);
			cardPur.setPur_Address(newAddress);
		}else {
			Member m = new PurchaseService().selectMember(no);
			bankPur.setPur_Address(m.getAddress());
			cardPur.setPur_Address(m.getAddress());
		}
		
		//적립금
		int plusMoney = (int) (resultPrice * 0.01);
		request.setAttribute("plusMoney", plusMoney);
		
		//사용한 쿠폰		
		String cUse = "Y";
		int couponNum = Integer.parseInt(request.getParameter("couponNum"));
		int use = 1;
		int j = 0;
		int couponDc = 0;
		String cName = "";
		if(couponNum >= 0) {
			//쿠폰 이름 찾아오기
			ArrayList<Coupon> list = new PurchaseService().selectCoupon(no, 0);
			for(Coupon c : list) {
				if(couponNum == j) {
					cName = c.getCp_name();
					couponDc = (int) c.getCp_discount();
				}
				j++;
			}
			System.out.println("주문 서블릿 couponDc : " + couponDc);
			//쿠폰 사용내역 (쿠폰 카운트) 1로 변경 
			int cuResult = new PurchaseService().updateCoupon(no, cName, use);
			bankPur.setCp_Use(cUse);
			cardPur.setCp_Use(cUse);
	
		}
		
		//사용한 적립금
		int originMoney = 0;
		int resultMoney = 0;
		String mUSe = "Y";
		int moneyDc = Integer.parseInt(request.getParameter("moneyVal"));
		if(moneyDc > 0) {
			//적립금 값 변경 (머니 테이블 -)
			request.setAttribute("moneyDc", moneyDc);
			//소비자 적립금 업데이트 (원래 소비자의 적립금 값 - 사용한 적립금 + 추가된 적립금)
			Consumer c = new PurchaseService().selectMoney(no);
			originMoney = c.getMoney();
			resultMoney =  originMoney - moneyDc + plusMoney;
			int cmResult =  new PurchaseService().updateCMoney(no, resultMoney);
			System.out.println("주문 서블릿 cmResult : " + cmResult);
			bankPur.setMoney_Use(mUSe);
			cardPur.setMoney_Use(mUSe);
		}else {
			moneyDc = 0;
			request.setAttribute("moneyDc", moneyDc);
		}
		
//		//최종결제금액
		int purPrice = 0;
		
		purPrice = resultPrice - couponDc - moneyDc;
		
		request.setAttribute("purPrice", purPrice);
		bankPur.setPur_Price(purPrice);
		cardPur.setPur_Price(purPrice);
		
		
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
	        
	        //입금마감시간
	        Date today = new Date ( );
	        Date tomorrow = new Date ( today.getTime ( ) + (long) ( 1000 * 60 * 60 * 24 ) );

	        SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy.MM.dd HH:mm", Locale.KOREA );
	        String dTime = formatter.format ( tomorrow );
	   
	        bankPur.setPur_Bank(bank);
	        bankPur.setPur_Account(accNo);
	        
	        request.setAttribute("dTime", dTime);
	        request.setAttribute("bank", bank);
	        request.setAttribute("accNo", accNo);
	        
	        int result = new PurchaseService().insertBankPur(bankPur, no);
	        System.out.println(bankPur);
	        request.getRequestDispatcher("views/purchase/confirmBankPur.jsp").forward(request, response);
			
		}else if(purType == 2) { //카드결제
			String card = request.getParameter("card");
			String cDate = request.getParameter("cDate");
			String cardNo = request.getParameter("cardNo");
			
			cardPur.setCard_Agency(card);
			cardPur.setCard_Date(cDate);
			cardPur.setCard_No(cardNo);
			
			request.setAttribute("card", card);
	        request.setAttribute("cDate", cDate);
	        request.setAttribute("cardNo", cardNo);
	        
			
	        int result = new PurchaseService().insertCardPur(cardPur, no);
			 System.out.println(cardPur);
			request.getRequestDispatcher("views/purchase/confirmCardPur.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
