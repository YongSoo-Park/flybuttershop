package com.flybutter.notice.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.NoticeFileRenamePolicy;
import com.flybutter.member.model.vo.Member;
import com.flybutter.notice.model.service.NoticeService;
import com.flybutter.notice.model.vo.Notice;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class NoticeInsertServlet
 */
@WebServlet("/insert.no")
public class NoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				if(ServletFileUpload.isMultipartContent(request)) {
			
					int maxSize = 10 * 1024 * 1024;
										
					String savePath = request.getServletContext().getRealPath("/resources/notice_file");
					
					System.out.println("savePath " + savePath);
					
					//MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
					MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new NoticeFileRenamePolicy());
					System.out.println(1);
					int category = Integer.parseInt(multiRequest.getParameter("category"));
					String title = multiRequest.getParameter("title");
					String content = multiRequest.getParameter("content");
					
			//		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
					
					Notice n = new Notice();
					n.setNotice_Category(category);
					n.setNotice_Title(title);
					n.setNotice_Content(content);
					System.out.println(2);
					
					if(multiRequest.getOriginalFileName("upfile") != null) {
						String originName = multiRequest.getOriginalFileName("upfile");
						String changeName = multiRequest.getFilesystemName("upfile");
						
						n.setNotice_File_Origin(originName);
						n.setNotice_File_System(changeName);
											
					}
					
					int result = new NoticeService().insertNotice(n);
					System.out.println("servlet result" + result);
					
					
					if(result > 0) {
						request.getSession().setAttribute("msg", "게시글등록성공");
						response.sendRedirect("entireList.no");
					}else {
						if(multiRequest.getOriginalFileName("upfile") != null) {
							File failedFile = new File(n.getNotice_File_Origin() + n.getNotice_File_System());
							failedFile.delete();
						}
						
						request.setAttribute("msg", "게시판등록 실패");
						
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
