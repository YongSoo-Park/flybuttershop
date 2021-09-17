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
 * Servlet implementation class FindPwdScrvlet
 */
@WebServlet("/findPwdForm.me")
public class FindPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindPwdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher("views/member/memberPwdFindForm.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		Member mem = new Member(userId, userName, phone, email, address);

		Member member = new MemberService().selectMember(mem);

		if (member != null) {

			String findedPwd = member.getUserPwd();
			String maskedPwd = "";

			System.out.println("member.getUserId>>>>>>>>>>>>>>> : " + findedPwd);

			if (!"".contentEquals(findedPwd) || findedPwd != null) {
				if (findedPwd.length() > 3) {
					maskedPwd = findedPwd.substring(0, 3);
					for (int i = 3; i < findedPwd.length(); i++) {
						maskedPwd += "*";
					}

				} else {
					maskedPwd = findedPwd.substring(0, 1);
					for (int i = 1; i < findedPwd.length(); i++) {
						maskedPwd = "*";
					}

				}

				// return maskedName;
				member.setUserPwd(maskedPwd);
				System.out.println("member>>>>>>>>>>>>>>> : " + member);

				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				RequestDispatcher view = request.getRequestDispatcher("views/member/memberPwdFindResult.jsp");
				view.forward(request, response);
			} else {

				request.setAttribute("msg", "존재하지 않습니다.");
				RequestDispatcher view = request.getRequestDispatcher("views/member/errorPage.jsp");
				view.forward(request, response);

			}

		}
	}
}
