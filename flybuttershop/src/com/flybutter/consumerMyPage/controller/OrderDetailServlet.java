package com.flybutter.consumerMyPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.consumerMyPage.model.vo.OrderInfo;
import com.flybutter.consumerMyPage.model.vo.OrderList;

/**
 * Servlet implementation class OrderDetailView
 */
@WebServlet("/detailOrder.mp")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int purNo = Integer.parseInt(request.getParameter("pno"));
		
		OrderList list = new MypageService().selectOrderDetail(purNo);
		
		ArrayList<OrderInfo> info = new ArrayList<OrderInfo>();
		
		System.out.println(list);
		
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
	        
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/consumerMypage/OrderDetailView.jsp").forward(request, response);

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
