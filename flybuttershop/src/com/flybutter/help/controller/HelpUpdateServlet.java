package com.flybutter.help.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.NoticeFileRenamePolicy;
import com.flybutter.help.model.service.HelpService;
import com.flybutter.help.model.vo.Help;

import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class HelpUpdateServlet
 */
@WebServlet("/update.help")
public class HelpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelpUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 10 * 1024 * 1024;
								
			String savePath = request.getServletContext().getRealPath("/resources/help");
		
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new NoticeFileRenamePolicy());
			
			int no = Integer.parseInt(multiRequest.getParameter("no"));
			
			Help h = new Help();
			h.setHelp_Category(Integer.parseInt(multiRequest.getParameter("category")));
			h.setHelp_Title(multiRequest.getParameter("title"));
			h.setHelp_Content(multiRequest.getParameter("content"));
			h.setHelp_File_System(multiRequest.getParameter("upfile"));
			h.setHelp_File_Origin(multiRequest.getParameter("upfile2"));
			h.setHelp_No(no);
			
							
			if(multiRequest.getOriginalFileName("new_upFile") != null) {
				
				h.setHelp_File_Origin(multiRequest.getOriginalFileName("new_upFile"));
				h.setHelp_File_System(multiRequest.getFilesystemName("new_upFile"));
				
				if(multiRequest.getParameter("upfile") != null) {
					File deleteFile = new File(savePath + multiRequest.getParameter("upfile"));		
					deleteFile.delete();
						}
			}

			int result = new HelpService().updateHelp(h);

			if(result > 0) {
				response.sendRedirect("detail.help?no=" + no);
				
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
