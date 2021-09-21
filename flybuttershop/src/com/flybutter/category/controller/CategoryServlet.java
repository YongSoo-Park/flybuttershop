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
import com.flybutter.paging.model.vo.Paging;

/**
 * Servlet implementation class categoryServlet
 */
@WebServlet("/categoryList.ca")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int mCategory; 
		int sCategory;
		
		mCategory = Integer.parseInt(request.getParameter("mCategory"));
		sCategory = Integer.parseInt(request.getParameter("sCategory"));
		Paging paging = null;
		ArrayList<Category> categoryList = new ArrayList<Category>();
		ArrayList<Category> categorySaleList = new ArrayList<Category>();
		categoryList = new CategoryService().categoryList(mCategory, sCategory);
		categorySaleList = new CategoryService().categorySaleList(mCategory, sCategory);
		String categoryName = new CategoryService().categoryName(mCategory, sCategory);
		request.setAttribute("mCategory", mCategory);
		request.setAttribute("sCategory", sCategory);
		request.setAttribute("categoryName", categoryName);
		if(categoryList.size()!= 0) {
			paging = new Paging(new CategoryService().categoryListCount(mCategory, sCategory), 1, 10, 10);
			request.setAttribute("paging", paging);
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("categorySaleList", categorySaleList);
			request.setAttribute("categoryListEmpty", 0);
			request.setAttribute("sKind", 1);
			System.out.println("fsafasf");
		}else {
			request.setAttribute("categoryListEmpty", 1);
		}
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
