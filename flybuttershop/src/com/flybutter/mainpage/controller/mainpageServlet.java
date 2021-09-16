package com.flybutter.mainpage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flybutter.dummy.model.service.MemberService;
import com.flybutter.dummy.model.vo.Member;
import com.flybutter.mainpage.model.service.MainPageService;
import com.flybutter.mainpage.model.vo.Mainpage;
import com.flybutter.product.model.vo.Product;

/**
 * Servlet implementation class mainpageServlet
 */
@WebServlet("/mainpage.ma")
public class mainpageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public mainpageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member loginMember = null;
		HashMap<String, Product> RVItemsList = null;
		int no;
		ArrayList<Mainpage> saleList = null;
		ArrayList<Mainpage> newList = null;
		ArrayList<Mainpage> bestList = null;
		ArrayList<ArrayList<Mainpage>> saleTotalList = null;
		HttpSession session = request.getSession();
		loginMember = (Member) session.getAttribute("loginMember");
		if (loginMember != null) {
			no = loginMember.getMEM_USER_NO();
			if (no == 0) {
				loginMember = new MemberService().loginAdmin(no);
				loginMember.setREC_PNO("0");
				loginMember.setMONEY(999999);
			} else {
				loginMember = new MemberService().loginMember(no);
			}
			if (!loginMember.getREC_PNO().equals("0")) {
				RVItemsList = new MainPageService().RVItemsList(loginMember.getREC_PNO());
			}
		}
		saleTotalList = new MainPageService().saleTotalList();
		saleList = new MainPageService().saleList();
		newList = new MainPageService().newList();
		bestList = new MainPageService().bestList();
		session.setAttribute("loginMember", loginMember);
		session.setAttribute("RVItemsList", RVItemsList);
		request.setAttribute("saleList", saleList);
		request.setAttribute("saleTotalList", saleTotalList);
		request.setAttribute("newList", newList);
		request.setAttribute("bestList", bestList);
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("views/mainpage/mainPage.jsp").forward(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
