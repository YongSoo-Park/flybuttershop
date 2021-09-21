package com.flybutter.basket.controller;
  
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
		int no = loginM.getUserNo();
		Basket b = new Basket();
		
		String pCode = request.getParameter("pCode");
		String bOption = request.getParameter("pOption");
		int price = Integer.parseInt(request.getParameter("price"));
		int bAmount = Integer.parseInt(request.getParameter("pAmount"));
		String basket_PImg = request.getParameter("pImg");
		String basket_Pname = request.getParameter("pName");
		String basket_Sname = request.getParameter("sName");
		
		//중복상품체크
		ArrayList<Basket> checkList = new BasketService().selectCheck(no, pCode);
		
		//중복이면 수량, 가격 업데이트
		if(checkList.size() > 0) {
			int newPrice = 0;
			int originAmount = 0;
			ArrayList<Basket> list = new BasketService().selectBasketList(no);
			for(Basket bb : list) {
				originAmount = bb.getbAmount();
			}
			
			originAmount += bAmount;
			newPrice = originAmount * price;
		
			int result = new BasketService().updateAmount(originAmount, pCode);
			int pResult = new BasketService().updatePrice(newPrice, pCode);
			response.sendRedirect("basket.do");
		}else {
			b.setpCode(pCode);
			b.setbOption(bOption);
			b.setPrice(price);
			b.setbAmount(bAmount);
			b.setUser_No(loginM.getUserNo());
			b.setBasket_PImg(basket_PImg);
			b.setBasket_Pname(basket_Pname);
			b.setBasket_Sname(basket_Sname);
		
		int result = new BasketService().insertBasket(b);
			
        if(result > 0) {
			request.getSession().setAttribute("msg", "장바구니 담기 성공");
			response.sendRedirect("basket.do");
			}else {
				request.setAttribute("msg", "상품등록실패");
				RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
				view.forward(request, response);	
			}
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
