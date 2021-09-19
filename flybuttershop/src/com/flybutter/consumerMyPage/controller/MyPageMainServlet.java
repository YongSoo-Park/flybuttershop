package com.flybutter.consumerMyPage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.member.model.vo.Member;

/**
 * Servlet implementation class MyPageMainServlet
 */
@WebServlet("/main.mp")
public class MyPageMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyPageMainServlet() {
        // TODO Auto-generated constructor stub
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Member m = (Member) request.getSession().getAttribute("loginMember");
		
		//int no = Integer.parseInt(request.getParameter("no"));
		//Member loginMember = new MemberService().loginMember(no);
		

		System.out.println(m);
		
		
		
		if(m != null) {
			
			int userNo = m.getUserNo();
			String userName = m.getUserName();
			int level = m.getLev();

			int sumPrice = new MypageService().selectSumPrice(userNo);
			
			//System.out.println("sumPrice = " + sumPrice);
			
			request.setAttribute("name", userName);
			request.setAttribute("level", level);
			
			request.setAttribute("sumPrice", sumPrice);
			
			
			
			request.getRequestDispatcher("views/consumerMypage/ConsumerMyPageMain.jsp").forward(request, response);
			
			
		}else {
			
			//request.setAttribute("msg", "로그인이 필요한 서비스 입니다.");
			//RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.getRequestDispatcher("views/member/loginPage.jsp").forward(request, response);
;			//view.forward(request, response);
			
			
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
