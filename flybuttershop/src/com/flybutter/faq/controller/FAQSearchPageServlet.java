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
 * Servlet implementation class FAQSearchPageServlet
 */
@WebServlet("/searchPage.faq")
public class FAQSearchPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQSearchPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		String sWord = request.getParameter("sWord");
		int total = Integer.parseInt(request.getParameter("total"));

		Paging paging = null;
		ArrayList<FAQ> searchList = new ArrayList<FAQ>();
	
		
		paging = new Paging(total, nowPage, 10, 10);
		
		
		searchList = new FAQService().searchListNext(sWord,paging.getStart(),paging.getEnd());
		
			
		request.setAttribute("paging", paging);
		request.setAttribute("searchList", searchList);
		
		request.setAttribute("searchListEmpty", 0);
		request.setAttribute("sWord", sWord);
		
		
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
