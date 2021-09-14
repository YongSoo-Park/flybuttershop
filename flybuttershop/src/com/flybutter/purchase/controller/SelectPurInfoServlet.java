package com.flybutter.purchase.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.dummy.model.vo.Member;
import com.flybutter.purchase.model.service.PurchaseService;
import com.flybutter.purchase.model.vo.Purchase;




/**
 * Servlet implementation class SelectPurInfoServlet
 */
@WebServlet("/selectPurInfo.hy")
public class SelectPurInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectPurInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member loginM = (Member)request.getSession().getAttribute("loginMember");
		int no = loginM.getMEM_USER_NO();
		int pNo = ((Integer)(request.getSession().getAttribute("pNo"))).intValue();
		
		ArrayList<Purchase> list = new PurchaseService().selectPurInfo(no, pNo);
        request.setAttribute("list", list);
        
//        request.getRequestDispatcher("views/basket/basketList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
