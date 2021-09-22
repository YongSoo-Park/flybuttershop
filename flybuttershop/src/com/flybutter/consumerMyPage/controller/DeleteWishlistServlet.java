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
 * Servlet implementation class DeleteWishlistServlet
 */
@WebServlet("/deleteWish.mp")
public class DeleteWishlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteWishlistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int wNo = Integer.parseInt(request.getParameter("no"));
		
		
		//int userNo = ((Member)request.getSession().getAttribute("loginMember")).getUserNo();
		
		int result = new MypageService().deleteWish(wNo);
		
		if(result > 0) {
			
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script charset='utf-8'> alert('위시리스트에서 삭제 되었습니다'); location.href='wishlist.mp';</script>");
			
			out.flush();
			
			
			
		}else {
			
			request.setAttribute("msg", "위시리스트 제거에 실패했습니다");
			
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
