package com.flybutter.faq.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.faq.model.service.FAQService;
import com.flybutter.faq.model.vo.FAQ;


/**
 * Servlet implementation class FAQUpdateFormServlet
 */
@WebServlet("/updateForm.faq")
public class FAQUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQUpdateFormServlet() {
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
		
		FAQ f = new FAQService().selectUpdateFAQ(no);
		
		if(f != null) {
			request.setAttribute("f", f);
			
			request.getRequestDispatcher("views/faq/faqUpdateForm.jsp").forward(request, response);	
		
		}else { 
			request.setAttribute("msg", "수정할 게시글을 불러오는데  실패했습니다.");
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
