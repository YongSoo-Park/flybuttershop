package com.flybutter.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.dummy.model.vo.Member;
import com.flybutter.review.model.service.ReviewService;
import com.flybutter.review.model.vo.PageInfo;
import com.flybutter.review.model.vo.Review;

/**
 * Servlet implementation class ReviewListServlet
 */
@WebServlet("/reviewList.rv")
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member m = (Member) request.getSession().getAttribute("loginMember");
		int userNo = m.getMEM_USER_NO();
		
	
				int listCount;			
				int currentPage;		
				int startPage;			
				int endPage;			
				int maxPage;		
				
				int pageLimit;			
				int boardLimit;			
				
				
				listCount = new ReviewService().getMyListCount(userNo);
				
				
				currentPage = 1;
				
				
				if(request.getParameter("currentPage") != null) {
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}
				
			
				pageLimit = 10;
				
				boardLimit = 10;
				
				
				maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
				startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
				
			
				endPage = startPage + pageLimit - 1;
			
				if(maxPage < endPage) {
					endPage = maxPage;
				}
				
				PageInfo pi = new PageInfo(listCount, currentPage, startPage, endPage, maxPage, pageLimit, boardLimit);
				
				ArrayList<Review> list = new ReviewService().selectList(pi,userNo);
				
				System.out.println(list);
				System.out.println(pi);
				
				request.setAttribute("list", list);
				request.setAttribute("pi", pi);
				request.getRequestDispatcher("views/review/ReviewListView.jsp").forward(request, response);;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
