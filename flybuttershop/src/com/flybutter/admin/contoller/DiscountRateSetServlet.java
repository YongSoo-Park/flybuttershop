package com.flybutter.admin.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.admin.model.service.AdminService;
import com.flybutter.admin.model.vo.Admin;

/**
 * Servlet implementation class DiscountRateSetServlet
 */
@WebServlet("/discountRate.ad")
public class DiscountRateSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DiscountRateSetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Admin mainPageList = null;
		int newSaleRate = 0;
		int result = 0;

		newSaleRate = Integer.parseInt(request.getParameter("newSaleRate"));
		
		result = new AdminService().newSaleRate(newSaleRate);
		
		if (result > 0) {
			request.setAttribute("upResultMsg", "일괄 할인율 수정을 완료하였습니다.");
		} else {
			request.setAttribute("upResultMsg", "일괄 할인율 수정을 실패하였습니다.");
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
