package com.flybutter.seller.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.review.model.vo.Review;
import com.flybutter.seller.model.service.SellerService;

/**
 * Servlet implementation class reviewDetailManagerServlet
 */
@WebServlet("/reviewDetail.sl")
public class reviewDetailManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reviewDetailManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int rNo = Integer.parseInt(request.getParameter("rNo"));
		System.out.println("상점review 보는데다        " + rNo);
		
		Review r = new SellerService().selectReview(rNo);
		System.out.println("상점review 보는데다        " + r);
		
		RequestDispatcher view = null;
		
		if(r != null) {
			request.setAttribute("r", r);
			request.getRequestDispatcher("views/seller/reviewDetailManager.jsp").forward(request, response);;
		}else {
			request.setAttribute("msg", "후기를 불러올 수 없습니다.");
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
