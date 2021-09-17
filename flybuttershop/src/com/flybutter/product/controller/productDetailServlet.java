package com.flybutter.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.product.model.service.ProductService;
import com.flybutter.product.model.vo.Product;
import com.flybutter.qna.model.vo.Qna;
import com.flybutter.review.model.vo.Review;
import com.flybutter.seller.model.vo.Seller;

/**
 * Servlet implementation class productDetailServlet
 */
@WebServlet("/detail.pr")
public class productDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pcode = request.getParameter("pCode");
		System.out.println("pCode" + pcode);
		
		Product p = new ProductService().selectProductDetail(pcode);
		
		Seller s = new ProductService().selectProductStore(pcode);
		
		ArrayList<Qna> qList = new ProductService().productQnaList(pcode);
		
		ArrayList<Review> rList = new ProductService().productReviewList(pcode);
		
		System.out.println("상품상세페이지서블릿  : " + qList);
		
		System.out.println("프로덕트 디테일"+p);
		System.out.println("프로덕트 디테일"+s);
		System.out.println("프로덕트 디테일"+qList);
		System.out.println("프로덕트 디테일"+rList);
		
		RequestDispatcher view = null;
	
		if(p != null || s != null || qList != null || rList != null) {
			request.setAttribute("p", p);
			request.setAttribute("s", s);
			request.setAttribute("qList", qList);
			request.setAttribute("rList", rList);
			request.getRequestDispatcher("views/product/productDetailView.jsp").forward(request, response);;
		}else if(p == null) {
			request.setAttribute("msg", "상품정보를 불러올 수 없습니다.");
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
