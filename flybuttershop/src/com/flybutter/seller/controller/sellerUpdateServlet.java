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
		
		String store_Name = request.getParameter("storeName");
		String ceo = request.getParameter("ceo");
		String store_Address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String seller_No = request.getParameter("sellerNo");
		String store_Account = request.getParameter("account");
		String store_Exp = request.getParameter("storeExp");
		
		Seller updateStore = new SellerService().updateStore(new Seller(store_Name, store_Address, seller_No, store_Account, store_Exp, phone, ceo, email));
		
		if(updateStore != null) {
			request.getSession().setAttribute("msg", "상점 정보 수정 완료");
			request.getSession().setAttribute("seller", updateStore);
			response.sendRedirect("sellerMyPage.sl");
			
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
