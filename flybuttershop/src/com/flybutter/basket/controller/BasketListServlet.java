package com.flybutter.basket.controller;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.basket.model.service.BasketService;
import com.flybutter.basket.model.vo.Basket;
import com.flybutter.member.model.vo.Member;


/**
 * Servlet implementation class basketListServlet
 */
@WebServlet("/basket.do")
public class BasketListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketListServlet() {
        super(); 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); 
		try {
			Member loginM = (Member)request.getSession().getAttribute("loginMember");
			int no = loginM.getUserNo();
			System.out.println("장바구니 유저 no : " + no);
			ArrayList<Basket> list = new BasketService().selectBasketList(no);
	        request.setAttribute("list", list);
	        
	        if(list!= null) {
	        	request.getRequestDispatcher("views/basket/basketList.jsp").forward(request, response);
	        }else {
				request.setAttribute("msg", "장바구니 로드에 실패하였습니다.");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
		}catch(NullPointerException e) {
			
			PrintWriter out = response.getWriter();
			out.println("<script charset='utf-8'> alert('로그인 후 이용해주세요.'); location.href='mainpage.ma';</script>");
			
			out.flush();
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
