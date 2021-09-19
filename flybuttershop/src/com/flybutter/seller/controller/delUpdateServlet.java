package com.flybutter.seller.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.seller.model.service.SellerService;
import com.flybutter.seller.model.vo.SoldList;

/**
 * Servlet implementation class delUpdateServlet
 */
@WebServlet("/updateDel.sl")
public class delUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pno = Integer.parseInt(request.getParameter("pNo"));
		int delNo = Integer.parseInt(request.getParameter("number"));
		
		ArrayList<SoldList> list = new SellerService().selectSold(pno);
		
		SoldList s = new SellerService().updateDel(pno, delNo);
		
		String pInfo = s.getPurInfo();
		System.out.println("판매디테일 서블릿"+ s.getDelNo());
		
		
		String[] temp1 = pInfo.split("/");
		String[] temp2;
		
		ArrayList<SoldList> sList = new ArrayList<SoldList>();
		
		for(int i = 0 ; i <temp1.length; i++) {
	         
	         if(temp1[i] != null) {
	            
	            temp2=temp1[i].split(":");
	            
	            sList.add(new SoldList(temp2[0],temp2[1],temp2[2],temp2[3], temp2[4]));
	            
	         }
		}
		
		
			request.setAttribute("s", s);
			request.setAttribute("sList", sList);
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
