package com.flybutter.consumerMyPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.coupon.model.vo.Coupon;
import com.flybutter.member.model.vo.Member;
import com.flybutter.money.model.vo.Money;

/**
 * Servlet implementation class MoneyDetailServlet
 */
@WebServlet("/moneyDetail.mp")
public class MoneyDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoneyDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int userNo = ((Member) request.getSession().getAttribute("loginMember")).getUserNo();
		
		ArrayList<Money> list = new MypageService().moneyDetail(userNo);
		
		ArrayList<Money> plus = new ArrayList<Money>();
		ArrayList<Money> minus = new ArrayList<Money>();
		

		for(Money m : list) {
			
			System.out.println("확인");
			
			if (m.getMoney() > 0) {
				plus.add(m);
			}else {
				
				minus.add(m);
				
			}
			
			
		}

		
		request.setAttribute("plus", plus);
		request.setAttribute("minus", minus);
		
		request.getRequestDispatcher("views/consumerMypage/MoneyDetailView.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
