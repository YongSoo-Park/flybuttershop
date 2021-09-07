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

import com.flybutter.dummy.model.service.MemberService;
import com.flybutter.dummy.model.vo.Member;

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
		
	
		request.getRequestDispatcher("views/consumerMypage/ConsumerMyPageMain.jsp").forward(request, response);;
		
		
		
		
		/*if(userId != null) {
			
			//메인페이지 jsp 띄우기 
			//멤버 접속해서 현재 등급 , 구매 실적 확인하기 실적 확인
			
			RequestDispatcher view = request.getRequestDispatcher("views/consumerMyPage/ConsumerMyPageMain.jsp");
			
			view.forward(request, response);
			
			
			
			
		}else {
			
			request.setAttribute("msg", "로그인이 필요한 서비스 입니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			
			view.forward(request, response);
			
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	

}
