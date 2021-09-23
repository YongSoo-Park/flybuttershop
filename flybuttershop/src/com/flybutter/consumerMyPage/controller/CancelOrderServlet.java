package com.flybutter.consumerMyPage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.consumerMyPage.model.vo.OrderInfo;
import com.flybutter.consumerMyPage.model.vo.OrderList;
import com.flybutter.member.model.vo.Member;
import com.flybutter.purchase.model.vo.Purchase;

/**
 * Servlet implementation class CancelOrderServlet
 */
@WebServlet("/cancelOrder.mp")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//주문 번호 받아오기
		int purNo = Integer.parseInt(request.getParameter("pno"));
		
		System.out.println(purNo);
		
		//주문 내역 디비에 저장된 상태로 불러오기
		OrderList list = new MypageService().selectOrderDetail(purNo);
		
		//주문 내역 분리해서 담을 어레이리스트
		ArrayList<OrderInfo> info = new ArrayList<OrderInfo>();
		
		//주문내역 문자열 선언 후 분리해서 어레이 리스트에 담기
		String str = list.getOrderInfo();
		
		 String[] temp1 =str.split("/");
	      String[] temp2;
	     
	      for(int j = 0 ; j <temp1.length; j++) {
	        if(temp1[j] != null) {
	        	
	          temp2=temp1[j].split(":");
	          
	          String pImage = new MypageService().getpImage(temp2[0]);
	          String pName = new MypageService().getpName(temp2[0]);
	     
	 
	          info.add(new OrderInfo(temp2[0],pName,Integer.parseInt(temp2[1]), Integer.parseInt(temp2[2]),temp2[3],Integer.parseInt(temp2[4]),list.getPurNo(),list.getPurDate(), pImage));
	          
	         
	        }
	          
	         }
	      
	      int amountResult = 0;
	      ArrayList<OrderInfo> amount = new ArrayList<OrderInfo>();
	      
	      for(int i = 0 ; i <info.size(); i++) {
	    	  
	    	  
	    	  amountResult = new MypageService().updateAmount(info.get(i).getpCode(), -(info.get(i).getAmount()));	  
	    	  
	   
	      }
	      
	      
	      
	      //sumPrice, cpCount, Money 내역 취소하기
	      
	      int userNo = ((Member) request.getSession().getAttribute("loginMember")).getUserNo();
	      
	      int sumResult = new MypageService().updateSumPrice(userNo, -(list.getPurPrice()));
	      int cpResult = new MypageService().updateCoupon(list.getPurNo());
	      int mResult = new MypageService().updateMoney(userNo,-(list.getPurPrice()*0.01), list.getPurNo());
	     

	     
	      //다시 주문내역 합쳐서 담을 문자열 배열 선언 정보 다시 담기
	      String [] strArr = new String [info.size()];
	      
	      for(int i = 0; i < info.size(); i++) {
	    	  String infoStr = "";
	    	  //이 부분에서 status 변
	    	  info.get(i).setState(5);
	    	  infoStr += info.get(i).getpCode() + ":";
	    	  infoStr += info.get(i).getSellerNo() + ":";
	    	  infoStr += info.get(i).getAmount()+ ":";
	    	  infoStr += info.get(i).getOption() + ":";
	    	  infoStr += info.get(i).getState();
	    	  
	    	
	    	  
	    	  strArr[i] = infoStr;
	    	  
	    	  
	      }
	      
	      //다시 합쳐진 최종 결과 문자열로 합치기
	      String result = String.join("/", strArr);	
	      

	      
	      //원래 주문내역 정보에 최종으로 합쳐진 문자열 set
	      list.setOrderInfo(result);
	      

	     int resultt = new MypageService().cancelOrder(list);
	     
	     if(resultt > 0) {
	    	 
	    	 
	    	 response.setContentType("text/html; charset=utf-8"); 
	    	 PrintWriter out = response.getWriter();
	    	 out.println("<script charset='utf-8'> alert('주문이 취소 되었습니다'); location.href='orderList.mp';</script>");
	    	 
	    	 
	     }else {
	    	 
	    	 request.setAttribute("msg", "주문 취소에 실패했습니다");
	    	 
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
