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
 * Servlet implementation class adminPageSearchServlet
 */
@WebServlet("/adminsearch.ad")
public class AdminPageSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int memberListCount;
		int sellerListCount;
		String sWord = request.getParameter("sWord");
		int sKind = Integer.parseInt(request.getParameter("sKind"));
		int memkind = Integer.parseInt(request.getParameter("memkind"));
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		ArrayList<Admin> memberList = null;
		ArrayList<Admin> sellerList = null;
		Paging memberListPaging = null;
		Paging sellerListPaging = null;
		if(memkind == 1) {
			memberListCount = new AdminService().memberListNextCount(sWord,sKind);
			sellerListCount = new AdminService().sellerListCount();
			sellerList = new AdminService().sellerList();
			memberListPaging = new Paging(memberListCount, nowPage, 10, 10);
			sellerListPaging = new Paging(sellerListCount, 1, 10, 10);
			memberList = new AdminService().memberListNext(sWord,sKind,memberListPaging.getStart(),memberListPaging.getEnd());
			System.out.println(memberListCount);
		}else {
			
			memberListCount = new AdminService().memberListCount();
			sellerListCount = new AdminService().sellerListNextCount(sWord,sKind);
			memberList = new AdminService().memberList();
			memberListPaging = new Paging(memberListCount, 1, 10, 10);
			sellerListPaging = new Paging(sellerListCount, nowPage, 10, 10);
			sellerList = new AdminService().sellerNextList(sWord,sKind,sellerListPaging.getStart(),sellerListPaging.getEnd());
			
		}
		
		request.setAttribute("memberList", memberList);
		request.setAttribute("sellerList", sellerList);
		request.setAttribute("memberListPaging", memberListPaging);
		request.setAttribute("sellerListPaging", sellerListPaging);
		request.setAttribute("sWord", sWord);
		request.setAttribute("sKind", sKind);
		request.setAttribute("memkind", memkind);
		
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
