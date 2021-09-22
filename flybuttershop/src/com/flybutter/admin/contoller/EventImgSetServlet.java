package com.flybutter.admin.contoller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.NewFileRenamePolicy;
import com.flybutter.admin.model.service.AdminService;
import com.flybutter.admin.model.vo.Admin;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class EventImgSetServlet
 */
@WebServlet("/mainpageEventSet.ad")
public class EventImgSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EventImgSetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int fileSize = 1024 * 1024 * 20;

		int judgeDBUpdate = 0;

		int result = 0;
		String temp = "";
		ArrayList<String> fileNameList = new ArrayList<String>();
		Admin mainPageList = null;
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/event/");
		String DBsaveDir = "/flybuttershop/resources/event/";
//		String saveDir2 = "d:/java/semiproject/upload2/";
		MultipartRequest multiRequest = null;
		File mkdir = new File(saveDir);
		mkdir.mkdirs();
		try {
			multiRequest = new MultipartRequest(request, saveDir, fileSize, "UTF-8", new NewFileRenamePolicy());
		} catch (IOException e) {

			request.setAttribute("upResultMsg", "파일크기는 20메가 이하로만 업로드 하실 수 있습니다.");

		}

		if (multiRequest != null) {
			for (int i = 1; i <= 2; i++) {
				String name = "eventImg" + i;
				
				if (multiRequest.getOriginalFileName(name) != null) {
					String originName = multiRequest.getOriginalFileName(name);
					String changeName = multiRequest.getFilesystemName(name);

					if (!(originName.toUpperCase().endsWith(".PNG") || originName.toUpperCase().endsWith(".JPG"))) {
						File tempFile = new File(saveDir + changeName);
						tempFile.delete();
						request.setAttribute("upResultMsg", i + "번째 파일은 업로드 하실 수 없는 확장자 파일입니다.");
						temp =  i + "번째 파일은 업로드 하실 수 없는 확장자 파일입니다." +(3-i)+"번째 파일은 ";
					} else {

//					if(i==2) {
//						
//						File tempFile = new File(saveDir+changeName);
//						System.out.println(saveDir+changeName);
//						tempFile.renameTo(new File(saveDir2+changeName));
//					
//					}

						judgeDBUpdate += i;
						fileNameList.add(DBsaveDir + originName);
						fileNameList.add(DBsaveDir + changeName);

					}

				}

			}
			if (judgeDBUpdate == 0) {
				request.setAttribute("upResultMsg", "아무 이미지도 업로드 하지 않으셨습니다.");
			} else{

				result = new AdminService().eventImgSet(fileNameList, judgeDBUpdate);

				if (result > 0) {
					request.setAttribute("upResultMsg", temp + "이벤트 이미지 교체를 성공적으로 완료하였습니다.");
				} else {
					request.setAttribute("upResultMsg", "이벤트 이미지 교체를 실패하였습니다.");
				}

			}
		}
		mainPageList = new AdminService().mainPageList();
		request.setAttribute("mainPageList", mainPageList);
		request.getRequestDispatcher("views/admin/adminPageEvent.jsp").forward(request, response);
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
