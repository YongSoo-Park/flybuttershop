package com.flybutter.seller.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.member.model.vo.Member;
import com.flybutter.product.model.vo.PageInfo;
import com.flybutter.review.model.vo.Review;
import com.flybutter.seller.model.service.SellerService;
import com.flybutter.seller.model.vo.Seller;

/**
 * Servlet implementation class reviewListManagerServlet
 */
@WebServlet("/reviewManager.sl")
public class reviewListManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reviewListManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int userNo = ((Member)request.getSession().getAttribute("loginMember")).getUserNo();
		Seller sel = new SellerService().selectStore(userNo);
		System.out.println("sel" + sel);
		System.out.println("storeNo : "+sel.getStore_No());
		int storeNo = sel.getStore_No();
		
		int listCount;			// 총 게시글 갯수
		int currentPage;		// 현재 페이지 (즉, 요청한 페이지)
		int startPage;			// 현재 페이지에 하단에 보여지는 페이징 바의 시작 수 
		int endPage;			// 현재 페이지에 하단에 보여지는 페이징 바의 끝 수
		int maxPage;			// 전체 페이지에서의 가장 마지막 페이지
		
		int pageLimit;			// 한 페이지 하단에 보여질 페이지 최대 갯수
		int boardLimit;			// 한 페이지에 보여질 게시글 최대 갯수
		
		listCount = new SellerService().storeReviewCount(storeNo);
		
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			//클릭하면 다시 currentPage 값을 셋팅해줌
		}
		
		// * pageLimit : 한 페이지 하단에 보여질 페이지 최대 갯수 
		pageLimit = 10;
		
		// * boardLimit : 한 페이지에 보여질 게시글 최대 갯수
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, startPage, endPage, maxPage, pageLimit, boardLimit); 
		
		
		ArrayList<Review> list = new SellerService().reviewList(pi, storeNo);
		
		System.out.println("리뷰별점~~" + list);
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		RequestDispatcher view = request.getRequestDispatcher("views/seller/reviewListManager.jsp");
		view.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
