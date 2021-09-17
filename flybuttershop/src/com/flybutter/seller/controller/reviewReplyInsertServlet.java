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
 * Servlet implementation class reviewReplyInsertServlet
 */
@WebServlet("/reInsert.sl")
public class reviewReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reviewReplyInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String re_comment = request.getParameter("comment");
		int rNo = Integer.parseInt(request.getParameter("rNo"));
		
		Review reReview = new SellerService().replyReview(new Review(rNo, re_comment));
		
		if(reReview != null) {
			response.setContentType("text/html; charset=utf-8"); 
			request.getSession().setAttribute("msg", "후기 답변 등록 성공");
			request.getSession().setAttribute("r", reReview);
			response.sendRedirect("reviewDetail.sl?rNo=" + reReview.getRe_no());
		}else {
			request.setAttribute("msg", "후기 답변 등록 실패");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			
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
