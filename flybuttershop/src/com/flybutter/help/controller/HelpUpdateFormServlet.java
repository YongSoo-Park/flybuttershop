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
 * Servlet implementation class HelpUpdateFormServlet
 */
@WebServlet("/updateForm.help")
public class HelpUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelpUpdateFormServlet() {
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
			
			Help h = new HelpService().selectUpdateHelp(no);
			System.out.println("helpUpdateFormServlet no : " + no);
			if(h != null) {
				request.setAttribute("h", h);
				
				request.getRequestDispatcher("views/help/helpUpdateForm.jsp").forward(request, response);	
				
			}else { 
				request.setAttribute("msg", "게시글을 수정할 수 없습니다.");
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
