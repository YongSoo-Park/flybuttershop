package com.flybutter.qna.controller;

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
 * Servlet implementation class qnaReplyInsertServlet
 */
@WebServlet("/rInsert.na")
public class qnaReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qnaReplyInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String qna_Comment = request.getParameter("comment");
		System.out.println("qna 댓글~~~~" +qna_Comment);
		int qna_No = Integer.parseInt(request.getParameter("qNo"));
		
		System.out.println("qna 댓글~~~~" +qna_No);
	
		Qna reQna = new QnaService().replyQna(new Qna(qna_No, qna_Comment));

		if(reQna != null) {
			response.setContentType("text/html; charset=utf-8"); 
			request.getSession().setAttribute("msg", "Q&A 답변 등록 성공");
			request.getSession().setAttribute("q", reQna);
			response.sendRedirect("qnaDetail.pr?qNo=" + reQna.getQna_No());
		}else {
			request.setAttribute("msg", "Q&A 답변 등록 실패");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			
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
