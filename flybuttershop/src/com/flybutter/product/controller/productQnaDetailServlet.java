package com.flybutter.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.qna.model.service.QnaService;
import com.flybutter.qna.model.vo.Qna;

/**
 * Servlet implementation class productQnaDetailServlet
 */
@WebServlet("/qnaDetail.pr")
public class productQnaDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productQnaDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		
		Qna q = new QnaService().selectQna(qNo);
		
		RequestDispatcher view = null;
		
		if(q != null) {
			request.setAttribute("q", q);
			request.getRequestDispatcher("views/product/productQnaView.jsp").forward(request, response);;
		}else {
			request.setAttribute("msg", "Q&A를 불러올 수 없습니다.");
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
