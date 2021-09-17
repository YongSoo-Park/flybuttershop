package com.flybutter.qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.product.model.service.ProductService;
import com.flybutter.product.model.vo.Product;
import com.flybutter.seller.model.service.SellerService;
import com.flybutter.seller.model.vo.Seller;

/**
 * Servlet implementation class qnaEnrollFormServlet
 */
@WebServlet("/qnaForm.sl")
public class qnaEnrollFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public qnaEnrollFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		String pcode = request.getParameter("pCode");
		String store_Name = request.getParameter("sName");
		int storeNo = Integer.parseInt(request.getParameter("storeNo"));
		String pImg = request.getParameter("pImg");
		int price = Integer.parseInt(request.getParameter("price"));
		String pimg = request.getParameter("pImg");
		
		System.out.println("qna ------" + pcode + store_Name + pimg);

		Product p = new ProductService().selectProductDetail(pcode);
		Seller s = new SellerService().selectStore(store_Name);

		RequestDispatcher view = null;

		if (p != null || s != null) {
			request.setAttribute("p", p);
			request.setAttribute("s", s);
			view = request.getRequestDispatcher("views/qna/qnaEnrollForm.jsp");

		} else {
			request.setAttribute("msg", "문의를 작성할 상품을 불러오는데  실패했습니다.");
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
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
