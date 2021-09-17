package com.flybutter.review.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.flybutter.dummy.model.vo.Member;
import com.flybutter.review.model.service.ReviewService;
import com.flybutter.review.model.vo.Review;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ReviewInsertServlet
 */
@WebServlet("/insert.rv")
public class ReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		if(ServletFileUpload.isMultipartContent(request)) { 
			

			int maxSize = 10 * 1024 * 1024;
			
			
			String savePath = request.getServletContext().getRealPath("/resources/reviewUpfile");
		
			System.out.println("savePath" + savePath);
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
			
			int score = Integer.parseInt(multiRequest.getParameter("score"));
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			
			Member m = (Member) request.getSession().getAttribute("loginMember");
			
			Review r = new Review();
			
			r.setScore(score);
			r.setRe_title(title);
			r.setRe_content(content);
			r.setUser_no(m.getMEM_USER_NO());
			
			
			if(multiRequest.getOriginalFileName("upfile") != null) {
				String originName = multiRequest.getOriginalFileName("upfile");
				String changeName = multiRequest.getFilesystemName("upfile");
				
				r.setRe_originFile(originName);
				r.setRe_changeFile(changeName);
				
				
			}
			
			//int result = new ReviewService().insertReview(r);
			/*if(result > 0) {
				request.getSession().setAttribute("msg", "리뷰 등록 성공");
				response.sendRedirect("reviewList.rv");
			}else {
				if(multiRequest.getOriginalFileName("upfile") != null) {
					File failedFile = new File(r.getRe_originFile() +r.getRe_changeFile());
					failedFile.delete();
				}
				
				request.setAttribute("msg", "게시판 등록 실패");
				
				RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
				view.forward(request, response);
			}*/
			
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
