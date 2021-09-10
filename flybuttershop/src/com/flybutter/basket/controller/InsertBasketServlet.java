package com.flybutter.basket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.basket.model.service.BasketService;
import com.flybutter.basket.model.vo.Basket;
import com.flybutter.member.model.vo.Member;

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
		int price = request.getParameter("price");
		int bAmount = request.getParameter("bAmount");
		
		b.setpCode(pCode);
		b.setbOption(bOption);
		b.setPrice(price);
		b.setbAmount(bAmount);
		b.setUser_No(loginUser.getUserNo());
		
		//user_No는 따로 consumer(또는 로그인유저)에서 가져와서 넘겨주기
		
		int result = new BasketService().insertBasket(b);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
