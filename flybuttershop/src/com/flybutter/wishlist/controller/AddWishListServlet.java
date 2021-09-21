package com.flybutter.wishlist.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.member.model.vo.Member;

/**
 * Servlet implementation class AddWishListServlet
 */
@WebServlet("/addWish.mp")
public class AddWishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWishListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int userNo = ((Member) request.getSession().getAttribute("loginMember")).getUserNo();
		
		String pCode = request.getParameter("pCode");
		
		
		int check = new MypageService().checkWish(userNo, pCode);
		
		if(check > 0) {
			
			request.setAttribute("msg", "이미 등록된 상품입니다");
			
			
		}else {
			
			int result = new MypageService().addWishList(userNo, pCode);
			
			if(result > 0) {
				
				request.setAttribute("msg", "위시리스트에 등록 되었습니다");
				
				
			}else {
				
				request.setAttribute("msg", "위시리스트 등록 실패");
				
			}
			
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
