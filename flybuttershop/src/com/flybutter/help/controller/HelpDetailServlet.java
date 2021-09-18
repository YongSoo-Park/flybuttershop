package com.flybutter.help.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.help.model.service.HelpService;
import com.flybutter.help.model.vo.Help;
import com.flybutter.help.model.vo.HelpReply;

/**
 * Servlet implementation class HelpDetailServlet
 */
@WebServlet("/detail.help")
public class HelpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelpDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("no : " + request.getParameter("no"));
		int no = Integer.parseInt(request.getParameter("no"));

		
		System.out.println("no : " + no);
		System.out.println("no : " + no);
		Help h = new HelpService().selectHelp(no);
		HelpReply hr = new HelpService().selectReplyHelp(no);
		System.out.println("h : " + h);
		System.out.println("hr : " + hr);
	
			
					if( h != null ) {
						
						request.setAttribute("h", h);	
						request.setAttribute("hr", hr);	
						request.getRequestDispatcher("views/help/helpDetailView.jsp").forward(request, response);
						
					}else {
						request.setAttribute("msg", "문의글을 볼 수 없습니다.");
						
						RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
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
