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
 * Servlet implementation class checkQnaPwdInputServlet
 */
@WebServlet("/checkPwd.na")
public class checkQnaPwdInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkQnaPwdInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		int pwd = Integer.parseInt(request.getParameter("pwd"));
		
		System.out.println("qna 비밀번호 확인 시작 : qNo =" + qNo);
		
		Qna q = new QnaService().selectQna(qNo);
		
		int originPwd = q.getQna_Pwd();
		
		RequestDispatcher view = null;
		
		if(pwd==originPwd) {
			
			request.setAttribute("q", q);
			request.getRequestDispatcher("views/product/productQnaView.jsp").forward(request, response);;
		}else {
			request.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
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
