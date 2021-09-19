package com.flybutter.consumerMyPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.member.model.vo.Member;

/**
 * Servlet implementation class CheckPasswordInvalidationServlet
 */
@WebServlet("/checkPassInv.mp")
public class CheckPasswordInvalidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckPasswordInvalidationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		String password = request.getParameter("checkPass");
		
		System.out.println(password);
		
		Member member = (Member) request.getSession().getAttribute("loginMember");
		
		int userNo = member.getUserNo();
		
		System.out.println(member.getUserPwd());
		
		Member m = new MypageService().selectMember(userNo);
		
		String originPass = m.getUserPwd();
		
		System.out.println(m.getUserPwd());
		
		if(password.equals(originPass)) {
			
			request.setAttribute("m", m);
			request.getRequestDispatcher("views/consumerMypage/updateMemberForm.jsp").forward(request, response);
			
		}else {
			request.getRequestDispatcher("views/consumerMypage/errorPassPage.jsp").forward(request, response);
			
		}
		
		
		//if
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
