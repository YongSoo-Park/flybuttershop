package com.flybutter.notice.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.NoticeFileRenamePolicy;
import com.flybutter.notice.model.service.NoticeService;
import com.flybutter.notice.model.vo.Notice;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/update.no")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateServlet() {
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
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new NoticeFileRenamePolicy());
			System.out.println(1);
			
			int no = Integer.parseInt(multiRequest.getParameter("no"));
			System.out.println("servlet no : " + no);
			
			Notice n = new Notice();
			n.setNotice_Category(Integer.parseInt(multiRequest.getParameter("category")));
			n.setNotice_Title(multiRequest.getParameter("title"));
			n.setNotice_Content(multiRequest.getParameter("content"));
			System.out.println(2);
			
			
				
			if(multiRequest.getOriginalFileName("upFile") != null) {
				
				n.setNotice_File_Origin(multiRequest.getOriginalFileName("upFile"));
				n.setNotice_File_System(multiRequest.getFilesystemName("upFile"));
			
				
				if(multiRequest.getParameter("originFile") != null) {
					File deleteFile = new File(savePath + multiRequest.getParameter("originFile"));
					
					deleteFile.delete();
					
						}
			}
			
			int result = new NoticeService().updateNotice(n);
			
			if(result > 0) {
				System.out.println("update from servlet result : " + result);
				response.sendRedirect("detail.no?no=" + no);
			}else {
				request.setAttribute("msg", "게시글 수정에  실패했습니다.");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
