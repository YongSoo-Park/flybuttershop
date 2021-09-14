package com.flybutter.consumerMyPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.dummy.model.vo.Member;

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
		
		int userNo = member.getMEM_USER_NO();
		
		System.out.println(member.getMEM_USER_PWD());
		
		Member m = new MypageService().selectMember(userNo);
		
		String originPass = m.getMEM_USER_PWD();
		
		System.out.println(m.getMEM_USER_PWD());
		
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
