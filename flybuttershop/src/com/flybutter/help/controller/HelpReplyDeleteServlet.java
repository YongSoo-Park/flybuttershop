package com.flybutter.help.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.help.model.service.HelpService;
import com.flybutter.help.model.vo.Help;

/**
 * Servlet implementation class HelpReplyDeleteServlet
 */
@WebServlet("/replyDelete.help")
public class HelpReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelpReplyDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("delete reply no : " + no);
		int result = new HelpService().deleteReplyHelp(no);
		System.out.println("delete reply result : " + result);
		
		
		Help h = new Help();
		h.setHelp_No(no);
		int result1 = new HelpService().changeStatusDeleteHelp(h);
		
		
		if(result > 0 && result1 > 0) {  
			System.out.println("delete reply result in if : " + result);
	
			response.sendRedirect("list.help");
			System.out.println("delete reply result after response in if : " + result);
		}else {
			request.setAttribute("msg", "답변이 삭제되지 않았습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
