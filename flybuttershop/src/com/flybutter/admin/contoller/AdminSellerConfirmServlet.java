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
 * Servlet implementation class adminSellerConfirmServlet
 */
@WebServlet("/adminconfirm.ad")
public class AdminSellerConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSellerConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sellerFListCount;
		int sKind = 0;
		String sWord = "";
		ArrayList<Admin> sellerFList = null;
		Paging sellerFListPaging = null;
		sellerFListCount = new AdminService().sellerFListCount();
		sellerFList = new AdminService().sellerFList();
		sellerFListPaging = new Paging(sellerFListCount, 1, 5, 5);
		
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
