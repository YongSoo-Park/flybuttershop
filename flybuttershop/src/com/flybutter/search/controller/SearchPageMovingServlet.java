package com.flybutter.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flybutter.member.model.vo.Member;
import com.flybutter.paging.model.vo.Paging;
import com.flybutter.search.model.service.SearchService;
import com.flybutter.search.model.vo.Search;

/**
 * Servlet implementation class searchPageMovingServlet
 */
@WebServlet("/SListPageM.se")
public class SearchPageMovingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPageMovingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int userNo = ((Member)request.getSession().getAttribute("loginMember")).getUserNo();
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		String sWord = request.getParameter("sWord");
		int total = Integer.parseInt(request.getParameter("total"));
		int sKind = Integer.parseInt(request.getParameter("sKind"));
		Paging paging = null;
		ArrayList<Search> searchList = new ArrayList<Search>();
		ArrayList<Search> searchSaleList = new ArrayList<Search>();
		
		paging = new Paging(total, nowPage, 10, 10);
		searchSaleList = new SearchService().searchSaleList(sWord);
		
		searchList = new SearchService().searchListNext(sWord,paging.getStart(),paging.getEnd(),sKind,userNo);
		
			
		request.setAttribute("paging", paging);
		request.setAttribute("searchList", searchList);
		request.setAttribute("searchSaleList", searchSaleList);
		request.setAttribute("searchListEmpty", 0);
		request.setAttribute("sWord", sWord);
		request.setAttribute("sKind", sKind);
		
		request.getRequestDispatcher("views/search/searchResult.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
