package com.flybutter.seller.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.member.model.vo.Member;
import com.flybutter.purchase.model.vo.Purchase;
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
		
		ArrayList<Purchase> pList = new SellerService().soldList(storeNo);
		
		System.out.println("상점 판매내역 ~~~ pList" + pList);
		
		int pno = 0;
		Date pDate = null;
		String pInfo = null;
		
		for(Purchase p : pList) {
			pno = p.getPur_No();
			pDate = p.getPur_Date();
			pInfo = p.getPur_Info();
		}
		
		System.out.println(pno);
		System.out.println(pDate);
		System.out.println(pInfo);
		
		SoldList s = new SoldList();
		
		String[] temp1 = pInfo.split("/");
		String[] temp2;
		
		ArrayList<SoldList> soldList = new ArrayList<SoldList>();
		for(int i = 0 ; i <temp1.length; i++) {
	         
	         if(temp1[i].contains(String.valueOf(storeNo))) {
	            
	            temp2=temp1[i].split(":");
	            
	            soldList.add(new SoldList(pno, pDate, temp2[0],temp2[1],temp2[2],temp2[3], temp2[4]));
	            
	         }
		}    
		
		System.out.println("soldList~~~~~~~   " + soldList);
		
		
		request.setAttribute("soldList", soldList);
		
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
