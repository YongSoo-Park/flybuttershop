package com.flybutter.seller.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.product.model.dao.ProductDao;
import com.flybutter.product.model.service.ProductService;
import com.flybutter.product.model.vo.Product;

/**
 * Servlet implementation class productDetailManagerServlet
 */
@WebServlet("/productDetail.sl")
public class productDetailManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productDetailManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pcode = request.getParameter("pcode");
		System.out.println("pcode" + pcode);
		
		Product p = new ProductService().selectProductDetail(pcode);
		
		System.out.println("selectProductDetail : "+ p);
		
		if(p != null) {
			request.setAttribute("p", p);
			request.getRequestDispatcher("views/seller/productDetailManager.jsp").forward(request, response);
			
		}else {
			request.setAttribute("msg", "상품 상세조회 실패");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
		
		
		switch(p.getpCategory()) {
		case 1:
			
		case 2:
			if(p.getpCategory2() == 1) {
				
			}else if(p.getpCategory2() == 2) {
				
			}else if(p.getpCategory2() == 3) {
				
			}else if(p.getpCategory2() == 4) {
				
			}else if(p.getpCategory2() == 5) {
				
			}
		case 3:
			if(p.getpCategory2() == 1) {
				
			}else if(p.getpCategory2() == 2) {
				
			}else if(p.getpCategory2() == 3) {
				
			}else if(p.getpCategory2() == 4) {
				
			}else if(p.getpCategory2() == 5) {
				
			}
		case 4:
			if(p.getpCategory2() == 1) {
				
			}else if(p.getpCategory2() == 2) {
				
			}else if(p.getpCategory2() == 3) {
				
			}else if(p.getpCategory2() == 4) {
				
			}else if(p.getpCategory2() == 5) {
				
			}
		case 5:
			if(p.getpCategory2() == 1) {
				
			}else if(p.getpCategory2() == 2) {
				
			}else if(p.getpCategory2() == 3) {
				
			}else if(p.getpCategory2() == 4) {
				
			}else if(p.getpCategory2() == 5) {
				
			}
		case 6:
		case 7:
		case 8:
		default:
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
