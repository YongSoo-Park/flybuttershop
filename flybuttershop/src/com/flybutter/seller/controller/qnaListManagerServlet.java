package com.flybutter.seller.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.dummy.model.vo.Member;
import com.flybutter.qna.model.vo.Qna;
import com.flybutter.seller.model.service.SellerService;
import com.flybutter.seller.model.vo.Seller;

/**
 * Servlet implementation class qnaListManagerServlet
 */
@WebServlet("/qnaManager.sl")
public class qnaListManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qnaListManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = ((Member)request.getSession().getAttribute("loginMember")).getMEM_USER_NO();
	    Seller seller = new SellerService().selectStore(userNo);
		System.out.println("sel" + seller);
		System.out.println("storeNo : "+seller.getStore_No());
		int storeNo = seller.getStore_No();
		
		ArrayList<Qna> list = new SellerService().qnaList(storeNo);
		
		
		request.setAttribute("list", list);
		
		RequestDispatcher view = request.getRequestDispatcher("views/seller/qnaListManager.jsp");
		view.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
