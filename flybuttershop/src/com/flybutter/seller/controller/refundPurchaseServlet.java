package com.flybutter.seller.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.seller.model.service.SellerService;
import com.flybutter.seller.model.vo.SoldList;

/**
 * Servlet implementation class refundPurchaseServlet
 */
@WebServlet("/refund.sl")
public class refundPurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public refundPurchaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pno = Integer.parseInt(request.getParameter("pNo"));

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

		System.out.println(purList);

		String[] info = new String[purList.size()];

		for (int i = 0; i < purList.size(); i++) {
			String infoStr = "";
			purList.get(i).setpStatus(9);
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
		
		int refund = new SellerService().refundPurchase(pno, result);
		
		//사용한 쿠폰, 적립금 돌려주기
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int price = Integer.parseInt(request.getParameter("price"));
		System.out.println("판매취소 ~~" + userNo);
		System.out.println("판매취소 ~~" + price);
		
		double d = 0.01;
		int sumResult = new SellerService().updateSumPrice(userNo, price); 
		int mResult = new SellerService().updateMoney(userNo,(price*d), pno);

		
		
		if(refund > 0) {
			response.sendRedirect("purchaseManager.sl");
		}else {
			request.setAttribute("msg", "주문수정 실패");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
