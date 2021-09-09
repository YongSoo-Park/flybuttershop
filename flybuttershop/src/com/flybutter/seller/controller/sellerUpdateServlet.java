package com.flybutter.seller.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.seller.model.service.SellerService;
import com.flybutter.seller.model.vo.Seller;

/**
 * Servlet implementation class sellerUpdateServlet
 */
@WebServlet("/updateStore.sl")
public class sellerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sellerUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String storeName = request.getParameter("storeName");
		String address = request.getParameter("address");
		String sellerNo = request.getParameter("sellerNo");
		String account = request.getParameter("account");
		String storeExp = request.getParameter("storeExp");
		
		Seller updateStore = new SellerService().updateSeller(new Seller(storeName, address, sellerNo, account, storeExp));
		
		if(updateStore != null) {
			request.getSession().setAttribute("msg", "");
			request.getSession().setAttribute("seller", updateStore);
			request.getRequestDispatcher("views/seller/sellerMyPage.jsp");
			
		}else {
			request.setAttribute("msg", "상점정보 수정 실패");
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
