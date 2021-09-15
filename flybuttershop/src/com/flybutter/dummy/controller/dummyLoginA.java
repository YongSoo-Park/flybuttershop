package com.flybutter.dummy.controller;

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
import com.flybutter.mainpage.model.vo.Mainpage;
import com.flybutter.mainpage.model.service.MainPageService;
import com.flybutter.product.model.vo.Product;

/**
 * Servlet implementation class dummyLoginA
 */
@WebServlet("/dummyLoginA.ma")
public class dummyLoginA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dummyLoginA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		Member loginMember=null;
		HashMap<String,Product> RVItemsList = null;;
		ArrayList<Mainpage> saleList = null;
		ArrayList<ArrayList<Mainpage>> saleTotalList = null;
		if(no==0) {
			loginMember = new MemberService().loginAdmin(no);
			loginMember.setREC_PNO("0");
			loginMember.setMONEY(999999);
		}else {
			loginMember = new MemberService().loginMember(no);
		}
		if(!loginMember.getREC_PNO().equals("0")) {
			RVItemsList  = new MainPageService().RVItemsList(loginMember.getREC_PNO());			
		}
		saleTotalList = new MainPageService().saleTotalList();
		saleList = new MainPageService().saleList();
		System.out.println(saleTotalList);
		HttpSession session = request.getSession();
		session.setAttribute("loginMember", loginMember);
		session.setAttribute("RVItemsList", RVItemsList);
		session.setAttribute("saleList", saleList);
		session.setAttribute("saleTotalList", saleTotalList);
		response.setContentType("text/html;charset=UTF-8");
		response.sendRedirect(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
