package com.flybutter.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class findIdservlet
 */
@WebServlet("/findIdForm.me")
public class FindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindIdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher("views/member/memberIdFindForm.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");

		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		Member mem = new Member(userName, phone, email);

		Member member = new MemberService().selectMember(mem);

		if (member != null) {

			String findedName = member.getUserId();
			String maskedName = "";


			if (!"".contentEquals(findedName) || findedName != null) {
				if (findedName.length() > 3) {
					maskedName = findedName.substring(0, 3);
					for (int i = 3; i < findedName.length(); i++) {
						maskedName += "*";
					}

				} else {
					maskedName = findedName.substring(0, 1);
					for (int i = 1; i < findedName.length(); i++) {
						maskedName = "*";
					}

				}

				member.setUserId(maskedName);

				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				RequestDispatcher view = request.getRequestDispatcher("views/member/memberIdFindResult.jsp");
				view.forward(request, response);
			}

		} else {

			request.setAttribute("msg", "존재하지 않습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/member/errorPage.jsp");
			view.forward(request, response);

		}
	}
}
