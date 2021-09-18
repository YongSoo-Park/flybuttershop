package com.flybutter.admin.contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.admin.model.service.AdminService;
import com.flybutter.admin.model.vo.Admin;
import com.flybutter.paging.model.vo.Paging;

/**
 * Servlet implementation class adminPageCommandServlet
 */
@WebServlet("/adminPageCommand.ad")
public class adminPageCommandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminPageCommandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int pKind = Integer.parseInt(request.getParameter("pKind"));
		int memkind = Integer.parseInt(request.getParameter("memkind"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int result = 0;
		if(pKind == 2) {
			
			result = new AdminService().storeConfirm(userNo);
			
			if(result>0) {
				request.getRequestDispatcher("adminconfirm.ad").forward(request, response);
			}
			
		}else if(pKind == 3) {
			if(memkind == 1) {
				int category = Integer.parseInt(request.getParameter("category"));
				result = new AdminService().memberDel(userNo,category);
				
				
			}else if(memkind == 2){
				
				result = new AdminService().sellerMemberDel(userNo);
				
				
			}
			if(result>0) {
				request.getRequestDispatcher("adminpage.ad").forward(request, response);
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
