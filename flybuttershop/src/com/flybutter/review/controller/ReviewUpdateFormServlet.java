package com.flybutter.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.review.model.vo.Review;

/**
 * Servlet implementation class ReviewUpdateFormServlet
 */
@WebServlet("/updateForm.rv")
public class ReviewUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reNo = Integer.parseInt(request.getParameter("rno"));
		
		Review r = new MypageService().updateReviewForm(reNo);
		
		if(r.getRe_no() > 0) {
			
			request.setAttribute("r", r);
			request.getRequestDispatcher("views/review/ReviewUpdateFormView.jsp").forward(request, response);
			
			
		}else {
			
			request.setAttribute("msg", "수정불가");
			
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
