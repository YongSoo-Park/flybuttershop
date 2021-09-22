package com.flybutter.consumerMyPage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.member.model.vo.Member;

/**
 * Servlet implementation class CheckPhoneServlet
 */
@WebServlet("/checkPhone.mp")
public class CheckPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckPhoneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = ((Member) request.getSession().getAttribute("loginMember")).getUserNo();
		String originPhone = new MypageService().getPhone(userNo);
		String checkPhone = request.getParameter("number");
		
		
		System.out.println(originPhone);
		System.out.println(checkPhone);
		
		if(originPhone.equals(checkPhone)) {
			request.setAttribute("originPhone", originPhone);
			request.getRequestDispatcher("views/consumerMypage/IdentificationView.jsp").forward(request, response);;
			
		}else {
			
			request.setAttribute("msg", "번호가 일치하지 않습니다");
			request.getRequestDispatcher("views/consumerMypage/IdentificationView.jsp").forward(request, response);
			
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
