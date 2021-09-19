package com.flybutter.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.review.model.service.ReviewService;

/**
 * Servlet implementation class ReviewInsertServlet
 */
@WebServlet("/insertForm.rv")
public class ReviewInsertFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int purNo = Integer.parseInt(request.getParameter("purNo"));
		String pCode =  request.getParameter("pCode");
		
		 String pName = new ReviewService().reviewInsertInfo(pCode);
		 
		 System.out.println(pName);
		 System.out.println(pCode);
		
		request.setAttribute("pCode", pCode);
		request.setAttribute("purNo", purNo);
		request.setAttribute("pName", pName);
		
		
		request.getRequestDispatcher("views/review/ReviewInsertForm.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
