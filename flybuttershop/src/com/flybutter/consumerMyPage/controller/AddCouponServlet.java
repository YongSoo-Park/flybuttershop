package com.flybutter.consumerMyPage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.member.model.vo.Member;

/**
 * Servlet implementation class AddCouponServlet
 */
@WebServlet("/addCoupon.mp")
public class AddCouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCouponServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int cpNum = Integer.parseInt(request.getParameter("cpNum"));
		
		int userNo = ((Member)request.getSession().getAttribute("loginMember")).getUserNo();
		
		int result = new MypageService().addCoupon(cpNum, userNo);
		

				if(result == 1) {
					
					response.setContentType("text/html; charset=utf-8"); 
					PrintWriter out = response.getWriter();
					out.println("<script charset='utf-8'> alert('쿠폰이 등록되었습니다'); location.href='couponLookup.mp';</script>");
					
					out.flush();

					
					
					
				}else {
					
					request.setAttribute("msg", "쿠폰 등록 실패");
					System.out.println("쿠폰등록실패");
					
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
