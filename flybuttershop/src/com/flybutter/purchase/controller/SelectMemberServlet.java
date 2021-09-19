package com.flybutter.purchase.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.member.model.vo.Member;
import com.flybutter.purchase.model.service.PurchaseService;


/**
 * Servlet implementation class SelectMemberServlet
 */
@WebServlet("/SelectMemberServlet")
public class SelectMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Member loginM = (Member)request.getSession().getAttribute("loginMember");
//		
//		int no = loginM.getUserNo();
//		
//		System.out.println("멤버셀렉트서블릿 : " + loginM);
//		
//		Member m = new PurchaseService().selectMember(no);
//		
//		System.out.println("멤버셀렉트서블릿 : " + m);
//		request.setAttribute("m", m);
//        
//        request.getRequestDispatcher("views/purchase/purchasePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
