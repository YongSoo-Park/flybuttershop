package com.flybutter.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.qna.model.service.QnaService;
import com.flybutter.qna.model.vo.Qna;

/**
 * Servlet implementation class qnaInsertServlet
 */
@WebServlet("/insertQna.pr")
public class qnaInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qnaInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		String title = request.getParameter("title");
		int category = Integer.parseInt(request.getParameter("category"));
		int pwd = Integer.parseInt(request.getParameter("pwd"));
		int lock = Integer.parseInt(request.getParameter("lock"));
		String content = request.getParameter("content");
		
		if(lock != 2) {
			lock = 1;
		}
		
		Qna q = new Qna();
		q.setQna_Title(title);
		q.setQna_Category(category);
		q.setQna_Pwd(pwd);
		q.setLock_Flag(lock);
		q.setQna_Content(content);
		
		int result = new QnaService().insertQna(q);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
