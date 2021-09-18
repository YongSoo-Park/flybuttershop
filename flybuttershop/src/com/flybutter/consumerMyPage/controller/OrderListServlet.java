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
import com.flybutter.dummy.model.vo.Member;
import com.flybutter.purchase.model.vo.Purchase;
import com.flybutter.review.model.service.ReviewService;
import com.flybutter.review.model.vo.PageInfo;
import com.flybutter.review.model.vo.Review;

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet("/orderList.mp")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member m = (Member) request.getSession().getAttribute("loginMember");
		int userNo = m.getMEM_USER_NO();
		
	
				int listCount;			
				int currentPage;		
				int startPage;			
				int endPage;			
				int maxPage;		
				
				int pageLimit;			
				int boardLimit;			
				
				
				listCount = new MypageService().getMyOrderListCount(userNo);
				
				
				currentPage = 1;
				
				
				if(request.getParameter("currentPage") != null) {
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}
				
			
				pageLimit = 10;
				
				boardLimit = 10;
				
				
				maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
				startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
				
			
				endPage = startPage + pageLimit - 1;
			
				if(maxPage < endPage) {
					endPage = maxPage;
				}
				
				PageInfo pi = new PageInfo(listCount, currentPage, startPage, endPage, maxPage, pageLimit, boardLimit);
				
				ArrayList<OrderList> list = new MypageService().selectOrderList(pi,userNo);
				
				ArrayList<ArrayList<OrderInfo>> listIn = new ArrayList<ArrayList<OrderInfo>>(); //= new MypageService().selectOrderListIn(pi,userNo);
				
				
				for(int i = 0; i < list.size(); i++) {
					
					String str = list.get(i).getOrderInfo();
				      
				      String[] temp1 =str.split("/");
				      String[] temp2;
				      ArrayList<OrderInfo> info=new ArrayList<OrderInfo>();
				      for(int j = 0 ; j <temp1.length; j++) {
				        if(temp1[j] != null) {
				        	
				          temp2=temp1[j].split(":");
				          
				          String pImage = new MypageService().getpImage(temp2[0]);
				          String pName = new MypageService().getpName(temp2[0]);
				     
				 
				          info.add(new OrderInfo(temp2[0],pName,Integer.parseInt(temp2[1]), Integer.parseInt(temp2[2]),temp2[3],Integer.parseInt(temp2[4]),list.get(i).getPurNo(),list.get(i).getPurDate(), pImage));
				          
				         
				          
				          
				         }
				        
				         
				      }
				      
				      
				      listIn.add(info);
				      
					
				}
				

				
				request.setAttribute("list", listIn);
				request.setAttribute("pi", pi);
				request.getRequestDispatcher("views/consumerMypage/OrderListView.jsp").forward(request, response);;

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
