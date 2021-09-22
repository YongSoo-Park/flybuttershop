package com.flybutter.purchase.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.basket.model.vo.Basket;
import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.consumerMyPage.model.vo.OrderInfo;
import com.flybutter.consumerMyPage.model.vo.OrderList;
import com.flybutter.member.model.vo.Member;
import com.flybutter.purchase.model.service.PurchaseService;
import com.flybutter.purchase.model.vo.Purchase;

/**
 * Servlet implementation class ChengePurStatusServlet
 */
@WebServlet("/changePurStatus.hy")
public class ChengePurStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChengePurStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Member loginM = (Member)request.getSession().getAttribute("loginMember");	
		int no = loginM.getUserNo();
		
		//유저넘버로 주문번호 찾아오기
		Purchase purNo  = new PurchaseService().selectPurNo(no);
		
		//적립된 적림금
		int plusMoney = Integer.parseInt(request.getParameter("plusMoney"));
		System.out.println("주문상태 변경 서블릿 : " + plusMoney);
//		int mResult = new MypageService().updateMoney(no, plusMoney, purNo.getPur_No());		
		
		//사용한 적립금
		int moneyDc = Integer.parseInt(request.getParameter("moneyDc"));
		System.out.println("주문상태 변경 서블릿 : " + -moneyDc);
//		int mResult = new MypageService().updateMoney(no, -moneyDc, purNo.getPur_No());	

		//상품수량 변경 
        //주문 내역 디비에 저장된 상태로 불러오기
//        OrderList list = new MypageService().selectOrderDetail(purNo.getPur_No());
//
//        //주문 내역 분리해서 담을 어레이리스트
//        ArrayList<OrderInfo> info = new ArrayList<OrderInfo>();
//
//        //주문내역 문자열 선언 후 분리해서 어레이 리스트에 담기
//        String str = list.getOrderInfo();
//
//         String[] temp1 =str.split("/");
//          String[] temp2;
//
//          for(int j = 0 ; j <temp1.length; j++) {
//            if(temp1[j] != null) {
//
//              temp2=temp1[j].split(":");
//
//              String pImage = new MypageService().getpImage(temp2[0]);
//              String pName = new MypageService().getpName(temp2[0]);
//
//              info.add(new OrderInfo(temp2[0],pName,Integer.parseInt(temp2[1]), Integer.parseInt(temp2[2]),temp2[3],Integer.parseInt(temp2[4]),list.getPurNo(),list.getPurDate(), pImage));
//
//            	}
//             }
//
//          int amountResult = 0;
//          ArrayList<OrderInfo> amount = new ArrayList<OrderInfo>();
//
//          for(int i = 0 ; i <info.size(); i++) {


//         amountResult = new MypageService().updateAmount(info.get(i).getpCode(), -(info.get(i).getAmount()));

        	  
//          }
	
          request.getRequestDispatcher("views/mainpage/mainPage.jsp").forward(request, response);
          
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
