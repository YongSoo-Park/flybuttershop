package com.flybutter.help.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.help.model.service.HelpService;
import com.flybutter.help.model.vo.Help;
import com.flybutter.help.model.vo.HelpReply;


/**
 * Servlet implementation class HelpReplyServlet
 */
@WebServlet("/reply.help")
public class HelpReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelpReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
			
			int no = Integer.parseInt(request.getParameter("no"));
			String content = request.getParameter("content");
			
			System.out.println("no : " + no);
			
			Help h = new Help();
			h.setHelp_No(no);
			
			HelpReply hr = new HelpReply();
			
			hr.setReply_Content(content);
			hr.setHelp_No(no);
			
			int result = new HelpService().insertReplyHelp(hr);
			int result1 = new HelpService().changeStatusHelp(h);
			if(result > 0 && result1 > 0) {
				response.sendRedirect("detail.help?no=" + no);
				
			}else { 
				request.setAttribute("msg", "답변이 작성되지 않았습니다.");
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
