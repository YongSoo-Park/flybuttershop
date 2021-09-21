package com.flybutter.seller.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.seller.model.service.SellerService;
import com.flybutter.seller.model.vo.SoldList;

/**
 * Servlet implementation class deletePurchaseServlet
 */
@WebServlet("/cancelPur.sl")
public class deletePurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletePurchaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pno = Integer.parseInt(request.getParameter("pNo"));
		
		ArrayList<SoldList> list = new SellerService().selectSold(pno);
		
		ArrayList<ArrayList<SoldList>> purList = new ArrayList<ArrayList<SoldList>>();
		
		for(int i = 0; i < list.size(); i++) {
			
			String pInfo = list.get(i).getPurInfo();
			
			String[] temp1 = pInfo.split("/");
			String[] temp2;
			
			ArrayList<SoldList> sInfo = new ArrayList<SoldList>();
			
			for(int j = 0 ; j <temp1.length; j++) {
		         
		         if(temp1[j] != null) {
		            
		            temp2=temp1[j].split(":");
		            
		            sInfo.add(new SoldList(temp2[0], temp2[1], temp2[2], temp2[3], 6));
		         } 
			}purList.add(sInfo);
		}
		
			String pcode = null;
			String storeNo = null;
			String amount = null;
			String option = null;
			String status = null;;
		
		for(SoldList s : list) {
			pcode = s.getpCode();
			storeNo = s.getStoreNo();
			amount = s.getpAmount();
			option = s.getpOption();
			status = String.valueOf(s.getpStatus());
		}
		
		//for문으로 상태만 set어케하지
		
//		if(int i = 0; i < ) {
//			
//		}
		
		
		//SoldList updateSold = new SellerService().cancelPurchase(new )
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
