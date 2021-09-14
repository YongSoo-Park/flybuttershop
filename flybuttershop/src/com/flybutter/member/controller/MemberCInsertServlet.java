package com.flybutter.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.consumer.model.service.ConsumerService;
import com.flybutter.member.model.service.MemberService;
import com.flybutter.member.model.vo.Member;


/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/cInsert.me")
public class MemberCInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberCInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ConsumerService cs = new ConsumerService();
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		Member mem = new Member(userId, userPwd, userName, phone, email , address);
		
		System.out.println("mem : "+mem);
		int result = new MemberService().insertCMember(mem);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$ result : "+result);
		if(result>0) {
			Member memInfo = new Member(userName, phone,  email);
			

			Member rtnMemInfo = new MemberService().selectMember(memInfo);
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$ rtnMemInfo : "+rtnMemInfo);

			cs.createConsumer(rtnMemInfo.getUserNo());
			
			request.getSession().setAttribute("msg", "축하합니다 ! 회원가입에 성공하셨습니다!");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$ result : "+result);
			response.sendRedirect(request.getContextPath());
		}else {
			
			request.setAttribute("msg", "회원가입에 실패했습니다.");
			
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
