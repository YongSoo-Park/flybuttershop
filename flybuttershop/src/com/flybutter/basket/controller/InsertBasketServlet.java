package com.flybutter.basket.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.basket.model.service.BasketService;
import com.flybutter.basket.model.vo.Basket;
import com.flybutter.member.model.vo.Member;
import com.flybutter.product.model.vo.Product;

/**
 * Servlet implementation class InsertBasketServlet
 */
@WebServlet("/insertbasket.do")
public class InsertBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBasketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		
		Basket b = new Basket();
		
		String pCode = request.getParameter("pCode");
		String bOption = request.getParameter("pOption");
		int price = Integer.parseInt(request.getParameter("price"));
		int bAmount = Integer.parseInt(request.getParameter("bAmount"));
		
		System.out.println(pCode);
		
		b.setpCode(pCode);
		b.setbOption(bOption);
		b.setPrice(price);
		b.setbAmount(bAmount);
		b.setUser_No(loginUser.getUserNo());
		
		//user_No는 따로 consumer(또는 로그인유저)에서 가져와서 넘겨주기
		
		int result = new BasketService().insertBasket(b);
		
        ArrayList<Product> pList = new BasketService().selectBProduct(pCode);
        request.setAttribute("pList", pList);
        request.getRequestDispatcher("views/basket/basketList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
