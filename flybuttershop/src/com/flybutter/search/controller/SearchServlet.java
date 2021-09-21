package com.flybutter.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.paging.model.vo.Paging;
import com.flybutter.search.model.service.SearchService;
import com.flybutter.search.model.vo.Search;

/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/search.ma")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sWord = request.getParameter("sWord");
		Paging paging = null;
		ArrayList<Search> searchList = new ArrayList<Search>();
		ArrayList<Search> searchSaleList = new ArrayList<Search>();
		
		searchList = new SearchService().searchList(sWord);
		searchSaleList = new SearchService().searchSaleList(sWord);
		if(searchList.size()!= 0) {
			paging = new Paging(new SearchService().searchListCount(sWord), 1, 10, 10);
			request.setAttribute("paging", paging);
			request.setAttribute("searchList", searchList);
			request.setAttribute("searchSaleList", searchSaleList);
			request.setAttribute("searchListEmpty", 0);
			request.setAttribute("sWord", sWord);
			request.setAttribute("sKind", 1);
		}else {
			request.setAttribute("searchListEmpty", 1);
			request.setAttribute("sWord", sWord);
		}
		
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
