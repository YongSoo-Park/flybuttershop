package com.flybutter.review.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.NoticeFileRenamePolicy;
import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.consumerMyPage.model.vo.OrderInfo;
import com.flybutter.consumerMyPage.model.vo.OrderList;
import com.flybutter.member.model.vo.Member;
import com.flybutter.review.model.service.ReviewService;
import com.flybutter.review.model.vo.Review;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UpdateReviewServlet
 */
@WebServlet("/update.rv")
public class UpdateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReviewServlet() {
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
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new NoticeFileRenamePolicy());
			
			int rNo = Integer.parseInt(multiRequest.getParameter("rNo"));

			int score = Integer.parseInt(multiRequest.getParameter("score"));
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			
			
			Review r = new Review();
			
			r.setRe_no(rNo);
			r.setScore(score);
			r.setRe_title(title);
			r.setRe_content(content);

			
			if(multiRequest.getOriginalFileName("upfile") != null) {
				String originName = multiRequest.getOriginalFileName("upfile");
				String changeName = multiRequest.getFilesystemName("upfile");
				
				r.setRe_originFile(originName);
				
				r.setRe_changeFile(changeName);
				
				
			}
			
			System.out.println(multiRequest.getOriginalFileName("upfile") );
			
			int result = new ReviewService().updateReview(r);
			

			if(result > 0) {
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script charset='utf-8'> alert('리뷰가 수정 되었습니다'); location.href='reviewList.rv';</script>");
				
				out.flush();
			}else {
				if(multiRequest.getOriginalFileName("upfile") != null) {
					File failedFile = new File(r.getRe_originFile() +r.getRe_changeFile());
					failedFile.delete();
				}
				
				request.setAttribute("msg", "게시판 등록 실패");
				
				RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
				view.forward(request, response);
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
