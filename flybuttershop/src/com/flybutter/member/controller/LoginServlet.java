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
import com.flybutter.member.model.vo.MemberLogin;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginPage.lp")
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
		
		Member loginUser = new MemberService().loginMember(userId, userPwd);
		
		if(loginUser != null) {
			int userNo = loginUser.getUserNo();
			String userName = loginUser.getUserName();
			int lev = loginUser.getLev();
			int category = loginUser.getCategory();		
			String recPno = "";
			int money = 0;
			
			HttpSession session = request.getSession();

			if(category == 1) {
				Member consumerInfo = new MemberService().selectCMember(loginUser);
				if(consumerInfo != null) {
					 recPno= consumerInfo.getRecPno();
					 money = consumerInfo.getMoney();
				}
			}


	
			com.flybutter.dummy.model.vo.Member loginMember = new com.flybutter.dummy.model.vo.Member(userNo, userName, lev, category, recPno, money);

			session.setAttribute("loginMember", loginMember);
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@  loginMember : "+loginMember);
			response.sendRedirect("mainpage.ma");
//			RequestDispatcher view = request.getRequestDispatcher("/mainpage.ma");
//			view.forward(request, response);
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
