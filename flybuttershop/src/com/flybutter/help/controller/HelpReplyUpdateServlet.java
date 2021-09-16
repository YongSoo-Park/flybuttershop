package com.flybutter.help.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.help.model.service.HelpService;
import com.flybutter.help.model.vo.HelpReply;

/**
 * Servlet implementation class HelpReplyUpdateServlet
 */
@WebServlet("/updateReply.help")
public class HelpReplyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelpReplyUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("no 전: " + request.getParameter("no"));
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("no 후 : " + no);
		String content = request.getParameter("content");
		
		
		HelpReply hr = new HelpReply();
	
		hr.setReply_Content(content);
		hr.setHelp_No(no);
		
		int result = new HelpService().updateReplyHelp(hr);
		
		if(result > 0) {
			response.sendRedirect("detail.help?no=" + no);
			System.out.println("detail no" + no);
		}else { 
			request.setAttribute("msg", "답변이 수정되지 않았습니다.");
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
