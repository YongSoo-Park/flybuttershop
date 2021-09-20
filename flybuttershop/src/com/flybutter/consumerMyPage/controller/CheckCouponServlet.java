package com.flybutter.consumerMyPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.coupon.model.vo.Coupon;
import com.flybutter.member.model.vo.Member;

/**
 * Servlet implementation class CheckCouponServlet
 */
@WebServlet("/checkCoupon.mp")
public class CheckCouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCouponServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int cpNum = Integer.parseInt(request.getParameter("number"));
		
		//int userNo = ((Member) request.getSession().getAttribute("loginMember")).getUserNo();
		
		Coupon c = new MypageService().checkCoupon(cpNum);
		
		//c.setCp_no(cpNum);

		System.out.println(c);
		if(c.getCp_name() != null) {
			
			request.setAttribute("coupon", c);
			
			
		}else {
		
			request.setAttribute("msg", "조회되는 쿠폰이 없습니다.");
			request.getRequestDispatcher("views/consumerMypage/CouponAddView.jsp").forward(request, response);
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
