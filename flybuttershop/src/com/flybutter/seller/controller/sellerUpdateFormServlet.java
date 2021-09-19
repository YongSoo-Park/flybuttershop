package com.flybutter.seller.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.member.model.vo.Member;
import com.flybutter.seller.model.service.SellerService;
import com.flybutter.seller.model.vo.Seller;

/**
 * Servlet implementation class sellerUpdateServlet
 */
@WebServlet("/updateForm.sl")
public class sellerUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public sellerUpdateFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int userNo = ((Member) request.getSession().getAttribute("loginMember")).getUserNo();
		Seller seller = new SellerService().selectStore(userNo);
		
		System.out.println("셀러 정보 수정     " + seller);
		
		RequestDispatcher view = null;

		if (seller != null) {
			request.setAttribute("seller", seller);
			view = request.getRequestDispatcher("views/seller/sellerUpdateForm.jsp");

		} else {
			request.setAttribute("msg", "판매자 정보를 수정할 수 없습니다");
			view = request.getRequestDispatcher("views/error/errorPage.jsp");
		}
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
