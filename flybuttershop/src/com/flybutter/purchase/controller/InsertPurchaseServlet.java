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
		
		Member loginM = (Member)request.getSession().getAttribute("loginMember");
		Purchase p = new Purchase();
		
		int no = loginM.getMEM_USER_NO();
		String pCode = request.getParameter("pCode");
		String newAddress = request.getParameter("newAdr");
		String purType = request.getParameter("purType");
		String pImg = request.getParameter("pImg");
		String pName = request.getParameter("pName");
		String option = request.getParameter("pOption");
		int pAmount = Integer.parseInt(request.getParameter("pAmount"));
		int resultPrice = Integer.parseInt(request.getParameter("resultPrice"));
		
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
		if(purType.equals("무통장")) {
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
			
		}else if(purType.equals("신용카드")) {
			String card = request.getParameter("card");
			String cDate = request.getParameter("cDate");
			String cardNo = request.getParameter("cardNo");
		}
		
		//적립금
		int plusMoney = (int) (resultPrice * 0.01);
		
		System.out.println("적립금 : " + plusMoney);
		
		int result = new PurchaseService().insertPurInfo(p);
		
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
