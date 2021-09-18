package com.flybutter.faq.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.faq.model.service.FAQService;
import com.flybutter.faq.model.vo.FAQ;

import com.flybutter.paging.model.vo.Paging;


/**
 * Servlet implementation class FAQSearchServlet
 */
@WebServlet("/search.faq")
public class FAQSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String sWord = request.getParameter("sWord");
		Paging paging = null;
		ArrayList<FAQ> searchList = new ArrayList<FAQ>();
	
		
		searchList = new FAQService().searchList(sWord);
		
		if(searchList.size()!= 0) {
			paging = new Paging(new FAQService().searchListCount(sWord), 1, 10, 10);
			request.setAttribute("paging", paging);
			request.setAttribute("searchList", searchList);
		
			request.setAttribute("searchListEmpty", 0);
			request.setAttribute("sWord", sWord);
		
		}else {
			request.setAttribute("searchListEmpty", 1);
			request.setAttribute("sWord", sWord);
		}
		
		request.getRequestDispatcher("views/search/faqSearchResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
