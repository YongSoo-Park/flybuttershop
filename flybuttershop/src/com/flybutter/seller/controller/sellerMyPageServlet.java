package com.flybutter.seller.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.dummy.model.vo.Member;
import com.flybutter.seller.model.service.SellerService;
import com.flybutter.seller.model.vo.Seller;

/**
 * Servlet implementation class sellerMyPageServlet
 */
@WebServlet("/sellerMyPage.sl")
public class sellerMyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sellerMyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//int userNo = ((Member)request.getSession().getAttribute("loginUser")).getMEM_USER_NO();
			
	      Seller seller = new SellerService().selectStore();
	      
	      RequestDispatcher view = null;
	      
	      if(seller != null) {
	         request.setAttribute("seller", seller);
	         view = request.getRequestDispatcher("views/seller/sellerMyPage.jsp");
	         
	      
	      }else {
	    	  request.setAttribute("msg", "판매자 정보를 불러올 수 없습니다");
	         view = request.getRequestDispatcher("views/error/errorPage.jsp");
	      }
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
