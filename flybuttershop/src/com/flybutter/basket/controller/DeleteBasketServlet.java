package com.flybutter.basket.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flybutter.basket.model.service.BasketService;


/**
 * Servlet implementation class DeleteBasketServlet
 */
@WebServlet("/deleteBasket.hy")
public class DeleteBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBasketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ck = request.getParameter("checkArr");
		String [] checkArr = ck.split(",");
		String a = "";
		BasketService bs = new BasketService();
		
		if(checkArr != null) {
			for(int i = 0; i <= checkArr.length; i++) {
			
			if(i == checkArr.length-1) {
				a += "'" + checkArr[i] + "'"; 
			}else {
				a += "'" + checkArr[i] + "', "; 
			}
//			System.out.println("doGet a값 : " + a);
			}
			bs.deleteBasket(a);
		}
		
		
		
//		if(result > 0) {  
//			response.sendRedirect("basket.do");
//			
//		}else {
//			request.setAttribute("msg", "장바구니 삭제에 실패하였습니다.");
//			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
//		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
