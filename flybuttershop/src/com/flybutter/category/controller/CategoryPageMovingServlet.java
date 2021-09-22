package com.flybutter.category.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.category.model.service.CategoryService;
import com.flybutter.category.model.vo.Category;
import com.flybutter.member.model.vo.Member;
import com.flybutter.paging.model.vo.Paging;
import com.flybutter.search.model.service.SearchService;
import com.flybutter.search.model.vo.Search;

/**
 * Servlet implementation class categoryPageMovingServlet
 */
@WebServlet("/CListPageM.ca")
public class CategoryPageMovingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryPageMovingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int userNo = ((Member)request.getSession().getAttribute("loginMember")).getUserNo();
		int mCategory; 
		int sCategory;
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		mCategory = Integer.parseInt(request.getParameter("mCategory"));
		sCategory = Integer.parseInt(request.getParameter("sCategory"));
		int total = Integer.parseInt(request.getParameter("total"));
		int sKind = Integer.parseInt(request.getParameter("sKind"));
		Paging paging = null;
		ArrayList<Category> categoryList = new ArrayList<Category>();
		ArrayList<Category> categorySaleList = new ArrayList<Category>();
		String categoryName = new CategoryService().categoryName(mCategory, sCategory);
		
		paging = new Paging(total, nowPage, 10, 10);
		categorySaleList = new CategoryService().categorySaleList(mCategory, sCategory);

		categoryList = new CategoryService().categoryListNext(mCategory, sCategory,paging.getStart(),paging.getEnd(),sKind,userNo);
		

		System.out.println(categoryList);
		request.setAttribute("paging", paging);
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("categorySaleList", categorySaleList);
		request.setAttribute("categoryListEmpty", 0);
		request.setAttribute("categoryName", categoryName);
		request.setAttribute("mCategory", mCategory);
		request.setAttribute("sCategory", sCategory);
		request.setAttribute("sKind", sKind);

		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("views/category/categoryResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
