package com.flybutter.seller.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.product.model.service.ProductService;
import com.flybutter.seller.model.service.SellerService;
import com.flybutter.seller.model.vo.SoldList;

/**
 * Servlet implementation class soldDetailManager
 */
@WebServlet("/soldDetail.sl")
public class soldDetailManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public soldDetailManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pno = Integer.parseInt(request.getParameter("pNo"));
		
		ArrayList<SoldList> list = new SellerService().selectSold(pno);
		SoldList s = new SellerService().selectSoldInfo(pno);
		//M001:2:1:BLACK:9/M002:2:1:BLACK:9
		String pInfo = s.getPurInfo();
		
		String[] temp1 = pInfo.split("/");
		String[] temp2;
		
		ArrayList<SoldList> sList = new ArrayList<SoldList>();
		
		for(int i = 0 ; i <temp1.length; i++) {
	         
	         if(temp1[i] != null) {
	            
	            temp2=temp1[i].split(":");
	            
	            String pImage = new SellerService().getpImage(temp2[0]);
	            String pName = new SellerService().getpName(temp2[0]);
	            
	            sList.add(new SoldList(pImage, pName, temp2[0],temp2[1],temp2[2],temp2[3], Integer.parseInt(temp2[4])));
	            
	         }
		}    
		System.out.println("sList======   " + sList);
		
		request.setAttribute("sList", sList);
		request.setAttribute("s", s);
		request.getRequestDispatcher("views/seller/soldDetailManager.jsp").forward(request, response);
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
