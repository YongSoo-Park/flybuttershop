package com.flybutter.faq.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.faq.model.service.FAQService;
import com.flybutter.faq.model.vo.FAQ;

/**
 * Servlet implementation class FAQUpdateServlet
 */
@WebServlet("/update.faq")
public class FAQUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		int category = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		FAQ f = new FAQ();
		f.setFaq_No(no);
		f.setFaq_Category(category);
		f.setFaq_Title(title);
		f.setFaq_Content(content);
		
		int result = new FAQService().updateFAQ(f);
		if(result > 0 ) {
			request.getSession().setAttribute("msg", "공지사항이 성공적으로 수정되었습니다.");
			response.sendRedirect("detail.faq?no="+ no);
		
		}else {
			request.setAttribute("msg", "공지사항 삭제에 실패했습니다.");
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
