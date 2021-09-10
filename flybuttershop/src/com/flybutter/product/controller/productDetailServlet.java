package com.flybutter.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.product.model.service.ProductService;
import com.flybutter.product.model.vo.Product;

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
		
		String pCode = request.getParameter("pCode");
		System.out.println("pCode" + pCode);
		
		Product p = new ProductService().selectProduct(pCode);
		
		System.out.println(p);
		
		RequestDispatcher view = null;
	
		if(p != null) {
			request.setAttribute("p", p);
			request.getRequestDispatcher("views/product/productDetailView.jsp").forward(request, response);;
		}else {
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
