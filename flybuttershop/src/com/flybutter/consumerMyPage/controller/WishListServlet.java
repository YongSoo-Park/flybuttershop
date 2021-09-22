package com.flybutter.consumerMyPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.consumerMyPage.model.vo.OrderInfo;
import com.flybutter.consumerMyPage.model.vo.OrderList;
import com.flybutter.member.model.vo.Member;
import com.flybutter.review.model.vo.PageInfo;
import com.flybutter.wishlist.model.vo.Wishlist;

/**
 * Servlet implementation class WishListServlet
 */
@WebServlet("/wishlist.mp")
public class WishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Member m = (Member) request.getSession().getAttribute("loginMember");
		int userNo = m.getUserNo();
		
	
				int listCount;			
				int currentPage;		
				int startPage;			
				int endPage;			
				int maxPage;		
				
				int pageLimit;			
				int boardLimit;			
				
				
				listCount = new MypageService().getWishlistCount(userNo);
				
				
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
				
				ArrayList<Wishlist> list = new MypageService().selectWishlist(pi,userNo);
				
				System.out.println(list);
				
				request.setAttribute("list", list);
				request.setAttribute("pi", pi);
				request.getRequestDispatcher("views/consumerMypage/WishListView.jsp").forward(request, response);;
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
