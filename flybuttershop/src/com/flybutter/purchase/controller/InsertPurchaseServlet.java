package com.flybutter.purchase.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
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
		
		Purchase p = new Purchase();
	
		Member loginM = (Member)request.getSession().getAttribute("loginMember");
		int no = loginM.getUserNo();
		p.setUser_No(no);
		
		//결제수단 번호
		int purType = Integer.parseInt(request.getParameter("purType"));
		p.setPur_Type(purType);
		
		//주문최종금액 (주문창)
		int resultPrice = Integer.parseInt(request.getParameter("resultPrice"));
		
		//주문최종금액 (장바구니주문창)
		
		//주문정보
		String purInfo = request.getParameter("purInfo");
		
		//새로운 주소 입력
		String newAddress = request.getParameter("newAdr");
		if(newAddress != null) {	
			int addResult = new ConsumerService().updateAdd(no, newAddress);
			p.setPur_Address(newAddress);
		}else {
			p.setPur_Address(loginM.getAddress());
		}
		
		//적립금
		int plusMoney = (int) (resultPrice * 0.01);
		//(머니 테이블 +)
		
		
		//사용한 쿠폰		
		String cUse = "Y";
		int couponNum = Integer.parseInt(request.getParameter("couponNum"));
		int use = 1;
		int j = 0;
		String cName = "";
		if(couponNum >= 0) {
			//쿠폰 이름 찾아오기
			ArrayList<Coupon> list = new PurchaseService().selectCoupon(no);
			for(Coupon c : list) {
				if(couponNum == j) {
					cName = c.getCp_name();
				}
				j++;
			}
			
			//쿠폰 사용내역 (쿠폰 카운트) 1로 변경 
			int cuResult = new PurchaseService().updateCoupon(no, cName, use);
			p.setCp_Use(cUse);
		}
		
		//사용한 적립금
		int originMoney = 0;
		int resultMoney = 0;
		String mUSe = "Y";
		int useMoney = Integer.parseInt(request.getParameter("moneyVal"));
		if(useMoney > 0) {
			//적립금 값 변경 (머니 테이블 -)
			
			//소비자 적립금 업데이트 (원래 소비자의 적립금 값 - 사용한 적립금 + 추가된 적립금)
			Consumer c = new PurchaseService().selectMoney(no);
			originMoney = c.getMoney();
			resultMoney =  originMoney - useMoney + plusMoney;
			p.setMoney_Use(mUSe);
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
	        Date today = new Date ( );
	        Date tomorrow = new Date ( today.getTime ( ) + (long) ( 1000 * 60 * 60 * 24 ) );
		
	        SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy.MM.dd HH:mm", Locale.KOREA );
	        String dTime = formatter.format ( tomorrow );
	   
	        request.setAttribute("dTime", dTime);
	        request.setAttribute("bank", bank);
	        request.setAttribute("accNo", accNo);
	        request.getRequestDispatcher("views/purchase/confirmBankPur.jsp").forward(request, response);
			
		}else if(purType == 2) { //카드결제
			String card = request.getParameter("card");
			String cDate = request.getParameter("cDate");
			String cardNo = request.getParameter("cardNo");
			
			
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
