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
		//System.out.println("%%%%%%%%%%%%%%%%%%%%%% userId,userPwd: "+ userId+","+userPwd);
		//String originPwd = request.getParameter("originPwd");
		
		Member loginUser = new MemberService().loginMember(userId, userPwd);
		
		if(loginUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginUser);
			//session.setAttribute("originPwd", originPwd);
			
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$ CATEGOGY : "+ loginUser.getCategory());
			int category = loginUser.getCategory();
			if(category == 1) {
				Member consumerInfo = new MemberService().selectCMember(loginUser);
				
				if(consumerInfo != null) {
				
					consumerInfo.setUserName(loginUser.getUserName());
					consumerInfo.setLev(loginUser.getLev());
					consumerInfo.setCategory(loginUser.getCategory());
                //	consumerInfo.setUserId(loginUser.getUserId());
				//	consumerInfo.setPhone(loginUser.getPhone());
				//	consumerInfo.setEmail(loginUser.getEmail());
				//	consumerInfo.setAddress(loginUser.getAddress());					
				//	consumerInfo.setStatus(loginUser.getStatus());
					

					session.setAttribute("consumerInfo", consumerInfo);
					System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$ consumerInfo : "+ consumerInfo);
				}

			}
			if(category == 2) {
				Member sellerInfo = new MemberService().selectSMember(loginUser);
				
				if(sellerInfo != null) {
					
					sellerInfo.setUserName(loginUser.getUserName());
					sellerInfo.setLev(loginUser.getLev());
					sellerInfo.setCategory(loginUser.getCategory());
		             //	consumerInfo.setUserId(loginUser.getUserId());
					//	consumerInfo.setPhone(loginUser.getPhone());
					//	consumerInfo.setEmail(loginUser.getEmail());
					//	consumerInfo.setAddress(loginUser.getAddress());					
					//	consumerInfo.setStatus(loginUser.getStatus());
					
					session.setAttribute("sellerInfo", sellerInfo);
					System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$ sellerInfo : "+ sellerInfo);
				}
				
			}

			RequestDispatcher view = request.getRequestDispatcher("/main.ma");
			view.forward(request, response);
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% loginUser :"+loginUser);
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
