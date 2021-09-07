package com.flybutter.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flybutter.member.model.service.MemberService;
import com.flybutter.member.model.vo.Member;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginPage.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%% userId,userPwd: "+ userId+","+userPwd);
		String originPwd = request.getParameter("originPwd");
		
		Member loginUser = new MemberService().loginMember(userId, userPwd);
		
		if(loginUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("originPwd", originPwd);
			//response.sendRedirect(request.getContextPath() + "/loginPage.lp");
			RequestDispatcher view = request.getRequestDispatcher("views/member/loginPage.jsp");
			view.forward(request, response);
			System.out.println("%%%%%%%%%%%%%%%%%%%%%% request.getContextPath() : " + request.getContextPath());
			
		}else {
			request.setAttribute("msg", "로그인에 실패했습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("views/member/errorPage.jsp");
			view.forward(request, response);
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
