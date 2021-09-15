package com.flybutter.consumerMyPage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.dummy.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/updateMem.mp")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String pwd = request.getParameter("user_PW1");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		System.out.println(address);
		
		Member m = new Member();
		
		int userNo = ((Member)request.getSession().getAttribute("loginMember")).getMEM_USER_NO();
		
		m.setMEM_USER_NO(userNo);
		m.setMEM_USER_PWD(pwd);
		m.setMEM_PHONE(phone);
		m.setMEM_EMAIL(email);
		m.setMEM_ADDRESS(address);
		
		System.out.println(address);
		
		int result = new MypageService().updateMember(m);
		
		if(result == 1) {
			
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script> alert('변경이 완료 되었습니다'); location.href='main.mp';</script>");
			
			out.flush();

			
		}else {
			
			request.setAttribute("msg", "변경실패");
			System.out.println("멤버 업데이트 실패");
			
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
