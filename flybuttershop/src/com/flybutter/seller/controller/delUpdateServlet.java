package com.flybutter.seller.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.seller.model.service.SellerService;
import com.flybutter.seller.model.vo.SoldList;

/**
 * Servlet implementation class delUpdateServlet
 */
@WebServlet("/updateDel.sl")
public class delUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public delUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pno = Integer.parseInt(request.getParameter("pNo"));
		int delNo = Integer.parseInt(request.getParameter("number"));

		SoldList list = new SellerService().selectSoldInfo(pno);

		String purInfo = list.getPurInfo();

		ArrayList<SoldList> purList = new ArrayList<SoldList>();

		String[] temp1 = purInfo.split("/");
		String[] temp2;

		for (int j = 0; j < temp1.length; j++) {
			if (temp1[j] != null) {

				temp2 = temp1[j].split(":");

				purList.add(new SoldList(temp2[0], temp2[1], temp2[2], temp2[3], Integer.parseInt(temp2[4])));
			}
		}
		String[] info = new String[purList.size()];

		for (int i = 0; i < purList.size(); i++) {
			String infoStr = "";
			purList.get(i).setpStatus(3);
			infoStr += purList.get(i).getpCode() + ":";
			infoStr += purList.get(i).getStoreNo() + ":";
			infoStr += purList.get(i).getpAmount() + ":";
			infoStr += purList.get(i).getpOption() + ":";
			infoStr += purList.get(i).getpStatus();

			info[i] = infoStr;
			System.out.println("결과 확인 : " + infoStr);
		}

		String result = String.join("/", info);
		System.out.println("결과 확인2 : " + info);

		list.setPurInfo(result);

		System.out.println("result~~~~" + result);

		int updateDel = new SellerService().updateDel(pno, delNo, result);
		
		if(updateDel > 0) {
			response.sendRedirect("purchaseManager.sl");
		}else {
			request.setAttribute("msg", "운송장번호 입력 실패");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
