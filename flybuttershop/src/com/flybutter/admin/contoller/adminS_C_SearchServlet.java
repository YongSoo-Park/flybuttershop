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
 * Servlet implementation class adminS_C_SearchServlet
 */
@WebServlet("/adminS_C_Search.ad")
public class adminS_C_SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminS_C_SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int sellerFListCount;
		int sKind = Integer.parseInt(request.getParameter("sKind"));
		String sWord = request.getParameter("sWord");
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		ArrayList<Admin> sellerFList = null;
		Paging sellerFListPaging = null;
		sellerFListCount = new AdminService().sellerFListNextCount(sKind,sWord);
		sellerFListPaging = new Paging(sellerFListCount, nowPage, 5, 5);
		sellerFList = new AdminService().sellerFListNext(sKind,sWord,sellerFListPaging.getStart(),sellerFListPaging.getEnd());
		
		request.setAttribute("sellerFList", sellerFList);;
		request.setAttribute("sellerFListPaging", sellerFListPaging);
		request.setAttribute("sKind", sKind);
		request.setAttribute("sWord", sWord);
		request.getRequestDispatcher("views/admin/adminPageSellerConfirm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
