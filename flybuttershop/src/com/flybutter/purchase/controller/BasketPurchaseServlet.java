package com.flybutter.purchase.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.consumer.model.vo.Consumer;
import com.flybutter.coupon.model.vo.Coupon;
import com.flybutter.dummy.model.vo.Member;
import com.flybutter.product.model.service.ProductService;
import com.flybutter.product.model.vo.Product;
import com.flybutter.purchase.model.service.PurchaseService;
import com.flybutter.purchase.model.vo.Purchase;

/**
 * Servlet implementation class BasketPurchaseServlet
 */
@WebServlet("/basketPur.hy")
public class BasketPurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketPurchaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//장바구니에서 전달받는 값
		String ck = request.getParameter("checkArr");
		String [] checkArr = ck.split(",");
				
		//장바구니 상품들 판매자 이름 찾기 
		Product pro = new Product();
		ArrayList<Product> pList = new ArrayList<Product>();
		ArrayList<Purchase> sNameList = new ArrayList<Purchase>();
			for(int i = 0; i < checkArr.length; i++) {
				pro = new ProductService().selectUpdateProduct(checkArr[i]); 
				pList.add(pro);
				
				for( Product pd : pList) {
					sNameList = new PurchaseService().selectSName(pd.getStore_No());	
				}
			};
		
		
			
		//나머지
		Member loginM = (Member)request.getSession().getAttribute("loginMember");
			
		int no = loginM.getMEM_USER_NO();
			
		//쿠폰에서 가져와 넘겨주기
		ArrayList<Coupon> list = new PurchaseService().selectCoupon(no);
				
		//적립금 가져와 넘겨주기
		Consumer c = new PurchaseService().selectMoney(no);

		request.setAttribute("pList", pList);
		request.setAttribute("sNameList", sNameList);
		request.setAttribute("list", list);
		request.setAttribute("consumer", c);
		
		request.getRequestDispatcher("views/purchase/basketPurPage.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
