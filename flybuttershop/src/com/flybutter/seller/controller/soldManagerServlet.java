package com.flybutter.seller.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.member.model.vo.Member;
import com.flybutter.purchase.model.vo.Purchase;
import com.flybutter.product.model.vo.PageInfo;
import com.flybutter.seller.model.service.SellerService;
import com.flybutter.seller.model.vo.Seller;
import com.flybutter.seller.model.vo.SoldList;

/**
 * Servlet implementation class soldManagerServlet
 */
@WebServlet("/purchaseManager.sl")
public class soldManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public soldManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = ((Member)request.getSession().getAttribute("loginMember")).getUserNo();
	    Seller seller = new SellerService().selectStore(userNo);
	    System.out.println("sel" + seller);
		System.out.println("storeNo : "+seller.getStore_No());
		int storeNo = seller.getStore_No();
		
		
	    int soldListCount;			
		int currentPage;		
		int startPage;			
		int endPage;			
		int maxPage;		
		
		int pageLimit;			
		int boardLimit;			
		
		soldListCount = new SellerService().soldListCount(storeNo);
	    
		currentPage = 1;
		
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
	
		pageLimit = 10;
		
		boardLimit = 10;
		
		
		maxPage = (int)Math.ceil((double)soldListCount/boardLimit);

		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
	
		endPage = startPage + pageLimit - 1;
	
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(soldListCount, currentPage, startPage, endPage, maxPage, pageLimit, boardLimit);
		
	   
		ArrayList<SoldList> pList = new SellerService().soldList(pi, storeNo);
		
		System.out.println("판매목록서블릿 ~~~" + pList);
		
		ArrayList<ArrayList<SoldList>> purList = new ArrayList<ArrayList<SoldList>>();
		
		for(int i = 0; i < pList.size(); i++) {
			
			String pInfo = pList.get(i).getPurInfo();
			
			String[] temp1 = pInfo.split("/");
			String[] temp2;
			
			ArrayList<SoldList> sInfo = new ArrayList<SoldList>();
			
			for(int j = 0 ; j <temp1.length; j++) {
		         
		         if(temp1[j] != null) {
		            
		            temp2=temp1[j].split(":");
		            
		            sInfo.add(new SoldList(pList.get(i).getPno(), pList.get(i).getpDate(), Integer.parseInt(temp2[4])));
		            
		         }
			}    
			purList.add(sInfo);
		}
		
		
		System.out.println("상점 판매내역 ~~~ pList" + pList);
		System.out.println("purList~~~~~~~   " + purList);
		
		
		request.setAttribute("purList", purList);
		request.setAttribute("pi", pi);
		request.getRequestDispatcher("views/seller/soldManager.jsp").forward(request, response);
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
