package com.flybutter.consumerMyPage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.consumerMyPage.model.vo.OrderInfo;
import com.flybutter.consumerMyPage.model.vo.OrderList;
import com.flybutter.member.model.vo.Member;

/**
 * Servlet implementation class DelCompleteServlet
 */
@WebServlet("/delComplete.mp")
public class DelCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int purNo = Integer.parseInt(request.getParameter("pno"));
		
		System.out.println(purNo);
		

		OrderList list = new MypageService().selectOrderDetail(purNo);
		
		ArrayList<OrderInfo> info = new ArrayList<OrderInfo>();
		
		System.out.println(list.getOrderInfo());
		
		String str = list.getOrderInfo();
		
		System.out.println(str);
		
		 String[] temp1 =str.split("/");
	      String[] temp2;
	     
	      for(int j = 0 ; j <temp1.length; j++) {
	        if(temp1[j] != null) {
	        	
	          temp2=temp1[j].split(":");
	          
	 
	          info.add(new OrderInfo(temp2[0],Integer.parseInt(temp2[1]), Integer.parseInt(temp2[2]),temp2[3],Integer.parseInt(temp2[4])));
	          
	         
	        }
	          
	         }
	      
	      String [] strArr = new String [info.size()];
	      
	      for(int i = 0; i < info.size(); i++) {
	    	  String infoStr = "";
	    	  //이 부분에서 status 변
	    	  info.get(i).setState(4);
	    	  infoStr += info.get(i).getpCode() + ":";
	    	  infoStr += info.get(i).getSellerNo() + ":";
	    	  infoStr += info.get(i).getAmount()+ ":";
	    	  infoStr += info.get(i).getOption() + ":";
	    	  infoStr += info.get(i).getState();
	    	  
	    	
	    	  
	    	  strArr[i] = infoStr;
	    	  
	    	  
	      }
	      
	      //다시 합쳐진 최종 결과 문자열로 합치기
	      String resultStr = String.join("/", strArr);	
	      
	      //원래 주문내역 정보에 최종으로 합쳐진 문자열 set
	      list.setOrderInfo(resultStr);
	      
	      System.out.println(list.getPurNo());

	     int result = new MypageService().cancelOrder(list);
	     
	     if(result > 0) {
	    	 
	    	 
	    	 response.setContentType("text/html; charset=utf-8"); 
	    	 PrintWriter out = response.getWriter();
	    	 out.println("<script charset='utf-8'> alert('배송 완료가 확정되었습니다'); location.href='orderList.mp';</script>");
	    	 
	    	 
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
