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
 * Servlet implementation class productUpdateFormServlet
 */
@WebServlet("/updateForm.pr")
public class productUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("상품 수정 서블릿 입장");
		request.setCharacterEncoding("UTF-8");
		
		String pCode = request.getParameter("pCode");
		
		System.out.println("상품수정          " + pCode);
		
		Product p = new ProductService().selectUpdateProduct(pCode);
		
		System.out.println("상품수정          " + p);
		
		RequestDispatcher view = null;
		
		if(p != null) {
			request.setAttribute("p", p);
		    view = request.getRequestDispatcher("views/product/productUpdateForm.jsp");
		}else {
			request.setAttribute("msg", "수정할 상품을 불러오는데  실패했습니다.");
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
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
