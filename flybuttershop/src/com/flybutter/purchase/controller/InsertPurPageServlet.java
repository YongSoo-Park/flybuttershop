package com.flybutter.purchase.controller;
 
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flybutter.consumer.model.vo.Consumer;
import com.flybutter.coupon.model.vo.Coupon;
import com.flybutter.dummy.model.vo.Member;
import com.flybutter.money.model.vo.Money;
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
		int no = loginM.getMEM_USER_NO();
		
		//제품상세페이지에서 전달받는 값들
		Purchase p = new Purchase();

		String pCode = request.getParameter("pCode");
		String pImg = request.getParameter("pImg");
		String pName = request.getParameter("pName");
		String option = request.getParameter("pOption");
		int price = Integer.parseInt(request.getParameter("price"));
		int pAmount = Integer.parseInt(request.getParameter("pAmount"));
		String sName = request.getParameter("sName");
		
		p.setUser_No(no);
		p.setpCode(pCode);
		p.setPur_Image(pImg);
		p.setPur_Pname(pName);
		p.setPur_POption(option);
		p.setPur_Price(price);
		p.setPur_Amount(pAmount);
		p.setPur_SName(sName);		
		
		System.out.println("주문서블릿 유저넘버 : " + no);
		
		//쿠폰에서 가져와 넘겨주기
		ArrayList<Coupon> list = new PurchaseService().selectCoupon(no);
		
		//적립금 가져와 넘겨주기
		Consumer c = new PurchaseService().selectMoney(no);
		
		System.out.println("주문서블릿 : " + list);
		System.out.println("주문서블릿 : " + c);
		
		request.setAttribute("purInfo", p);
		request.setAttribute("list", list);
		request.setAttribute("consumer", c);
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
