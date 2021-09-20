package com.flybutter.admin.contoller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.NewFileRenamePolicy;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fileSize = 1024 * 1024 * 20;
		
		int emptyCount = 0;
		
		String saveDir = "d:/java/semiproject/upload/";
		String saveDir2 = "d:/java/semiproject/upload2/";
		
		MultipartRequest multiRequest = new MultipartRequest(request, saveDir,fileSize,"UTF-8",new NewFileRenamePolicy());
		
		
	
		for(int i = 1 ; i <= 2 ; i++) {
			String name = "eventImg" + i;
			if(multiRequest.getOriginalFileName(name)!=null) {
				String originName = multiRequest.getOriginalFileName(name);
				String changeName = multiRequest.getFilesystemName(name);
				
				if(!(originName.toUpperCase().endsWith(".PNG")||originName.toUpperCase().endsWith(".JPG"))) {
					File tempFile = new File(saveDir+changeName);
					tempFile.delete();
					request.setAttribute("upResultMsg", i+"번째 파일은 업로드 하실 수 없는 확장자 파일입니다.");
				}else {
					
					if(i==2) {
						
						File tempFile = new File(saveDir+changeName);
						System.out.println(saveDir+changeName);
						tempFile.renameTo(new File(saveDir2+changeName));
					
					}
					
				}									
			}else {
				emptyCount++;
			}
			
		}
		if(emptyCount==2) {
			request.setAttribute("upResultMsg", "아무 이미지도 업로드 하지 않으셨습니다.");
		}
		
		request.getRequestDispatcher("views/admin/adminPageEvent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
