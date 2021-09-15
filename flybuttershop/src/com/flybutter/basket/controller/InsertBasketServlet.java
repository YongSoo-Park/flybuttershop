package com.flybutter.basket.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.basket.model.service.BasketService;
import com.flybutter.basket.model.vo.Basket;
import com.flybutter.dummy.model.vo.Member;
import com.flybutter.product.model.vo.Product;

/**
 * Servlet implementation class InsertBasketServlet
 */
@WebServlet("/insertBasket.hy")
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
		
		Member loginM = (Member)request.getSession().getAttribute("loginMember");
		
		Basket b = new Basket();
		
		String pCode = request.getParameter("pCode");
		String bOption = request.getParameter("pOption");
		int price = Integer.parseInt(request.getParameter("price"));
		int bAmount = Integer.parseInt(request.getParameter("pAmount"));
		String basket_PImg = request.getParameter("pImg");
		String basket_Pname = request.getParameter("pName");
		
//		private String pCode;
//		private int basket_No;
//		private String bOption;
//		private int bAmount;
//		private int price;
//		private Date basket_Date;
//		private int user_No;
//		private String basket_PImg;
//		private String basket_Pname;
		
		b.setpCode(pCode);
		b.setbOption(bOption);
		b.setPrice(price);
		b.setbAmount(bAmount);
		b.setUser_No(loginM.getMEM_USER_NO());
		b.setBasket_PImg(basket_PImg);
		b.setBasket_Pname(basket_Pname);
		
		int result = new BasketService().insertBasket(b);
		
        request.getRequestDispatcher("/basket.do").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
