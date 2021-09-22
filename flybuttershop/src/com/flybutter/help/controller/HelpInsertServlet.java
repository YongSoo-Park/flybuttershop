package com.flybutter.help.controller;

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
import com.flybutter.help.model.service.HelpService;
import com.flybutter.help.model.vo.Help;
import com.flybutter.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class HelpInsertServlet
 */
@WebServlet("/insert.help")
public class HelpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelpInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10 * 1024 * 1024;
			String savePath = request.getServletContext().getRealPath("/resources/help");
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
					new NoticeFileRenamePolicy());
			Member m = (Member) request.getSession().getAttribute("loginMember");
			if (m != null) {

				int userNo = m.getUserNo();
				System.out.println("userNo servlet : " + userNo);

				int category = Integer.parseInt(multiRequest.getParameter("category"));
				String title = multiRequest.getParameter("title");
				String content = multiRequest.getParameter("content");

				// int userNo =
				// ((Member)request.getSession().getAttribute("loginUser")).getUserNo();

				Help h = new Help();
				h.setHelp_Category(category);
				h.setHelp_Title(title);
				h.setHelp_Content(content);
				h.setUser_No(userNo);
				if (multiRequest.getOriginalFileName("upfile") != null) {
					String originName = multiRequest.getOriginalFileName("upfile");
					String changeName = multiRequest.getFilesystemName("upfile");

					h.setHelp_File_Origin(originName);
					h.setHelp_File_System(changeName);

				}

				int result = new HelpService().insertHelp(h);
				System.out.println("result : " + result);
				if (result > 0) {
					request.getSession().setAttribute("msg", "문의글이 등록되었습니다.");
					response.sendRedirect("list.help");
				} else {
					if (multiRequest.getOriginalFileName("upfile") != null) {
						File failedFile = new File(h.getHelp_File_Origin() + h.getHelp_File_System());
						failedFile.delete();
					}

					request.setAttribute("msg", "문의글이 등록되지 않았습니다.");

					RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
					view.forward(request, response);

				}
			

		} else {
			request.setAttribute("msg", "로그인이 필요한 서비스 입니다.");
			request.getRequestDispatcher("views/member/loginPage.jsp").forward(request, response);
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
