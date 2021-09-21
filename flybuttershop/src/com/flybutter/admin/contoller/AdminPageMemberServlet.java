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
 * Servlet implementation class adminPageServlet
 */
@WebServlet("/adminpage.ad")
public class AdminPageMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberListCount;
		int sellerListCount;
		int sKind = 0;
		int memkind = 1;
		String sWord = "";
		ArrayList<Admin> memberList = null;
		ArrayList<Admin> sellerList = null;
		Paging memberListPaging = null;
		Paging sellerListPaging = null;
		memberListCount = new AdminService().memberListCount();
		sellerListCount = new AdminService().sellerListCount();
		memberList = new AdminService().memberList();
		sellerList = new AdminService().sellerList();
		memberListPaging = new Paging(memberListCount, 1, 10, 10);
		sellerListPaging = new Paging(sellerListCount, 1, 10, 10);
		System.out.println(sellerListPaging);
		request.setAttribute("memberList", memberList);
		request.setAttribute("sellerList", sellerList);
		request.setAttribute("memberListPaging", memberListPaging);
		request.setAttribute("sellerListPaging", sellerListPaging);
		request.setAttribute("sKind", sKind);
		request.setAttribute("memkind", memkind);
		request.setAttribute("sWord", sWord);
		
		request.getRequestDispatcher("views/admin/adminPageMember.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
