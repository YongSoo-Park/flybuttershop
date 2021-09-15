package com.flybutter.purchase.controller;
 
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flybutter.dummy.model.vo.Member;
import com.flybutter.purchase.model.service.PurchaseService;
import com.flybutter.purchase.model.vo.Purchase;

/**
 * Servlet implementation class InsertPurchasePageServlet
 */
@WebServlet("/insertPurInfo.hy")
public class InsertPurPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPurPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Member loginM = (Member)request.getSession().getAttribute("loginMember");

		Purchase p = new Purchase();
		
//		String pCode, String pur_Image, String pur_Pname, String pur_POption, int pur_Price, int pur_Amount
		
//		System.out.println("insurtPurPageServlet " + loginM);
		String pCode = request.getParameter("pCode");
		String pImg = request.getParameter("pImg");
		String pName = request.getParameter("pName");
		String option = request.getParameter("pOption");
		int price = Integer.parseInt(request.getParameter("price"));
		int pAmount = Integer.parseInt(request.getParameter("pAmount"));
		String sName = request.getParameter("sName");
		
		p.setUser_No(loginM.getMEM_USER_NO());
		p.setpCode(pCode);
		p.setPur_Image(pImg);
		p.setPur_Pname(pName);
		p.setPur_POption(option);
		p.setPur_Price(price);
		p.setPur_Amount(pAmount);
		p.setPur_SName(sName);
//		
//		int result = new PurchaseService().insertPurInfo(p);
		
//		HttpSession session = request.getSession();
//		session.setAttribute("pNo", p.getPur_No());
		
		request.setAttribute("purInfo", p);
		request.getRequestDispatcher("views/purchase/purchasePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
