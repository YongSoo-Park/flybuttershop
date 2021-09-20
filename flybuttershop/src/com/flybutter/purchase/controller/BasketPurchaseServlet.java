package com.flybutter.purchase.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.basket.model.service.BasketService;
import com.flybutter.basket.model.vo.Basket;
import com.flybutter.consumer.model.vo.Consumer;
import com.flybutter.coupon.model.vo.Coupon;
import com.flybutter.mainpage.model.service.MainPageService;
import com.flybutter.member.model.vo.Member;
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
		Member loginM = (Member)request.getSession().getAttribute("loginMember");
			
		int no = loginM.getUserNo();
		
		//장바구니에서 전달받는 값
		String ck = request.getParameter("checkArr");
		String [] checkArr = ck.split(",");
				
		//장바구니 정보 가져오기
		Basket b = new Basket();
		ArrayList<Basket> bList = new ArrayList<Basket>();
			for(int i = 0; i < checkArr.length; i++) {
				b = new BasketService().selectInBasket(checkArr[i] , no);
				bList.add(b);
			};
			
		//현재 로그인 유저의 정보가져오기
		Member m = new PurchaseService().selectMember(no);
		
		//쿠폰에서 가져와 넘겨주기
		ArrayList<Coupon> list = new PurchaseService().selectCoupon(no);
		
		//적립금 가져와 넘겨주기
		Consumer c = new PurchaseService().selectMoney(no);
		
		//배송비 넘겨주기
		int delPrice = Integer.parseInt(request.getParameter("delPrice"));
		
		//할인상품 체크 및 할인가격 넘겨주기
		int discountRate = new MainPageService().discountRate();
		double dr = discountRate * 0.01;
		
		Product pro = new Product();
		ArrayList<Product> pList = new ArrayList<Product>();
			
		for(int i = 0; i < checkArr.length; i++) {
			pro = new ProductService().selectUpdateProduct(checkArr[i]); 
			pList.add(pro);	
		};
		
		int [] salePrice = new int [bList.size()];
		int j = 0;
		for(Product p : pList) {
			if(p.getSale_Flag() == 1) {
				salePrice [j] = (int) (p.getPrice() * dr);
			}
			j++;
		};
		
		//String[] sp = Arrays.toString(salePrice).split("[\\[\\]]")[1].split(", "); 
		
		//request.setAttribute("sp", sp);
		request.setAttribute("delPrice", delPrice);
		request.setAttribute("list", list);
		request.setAttribute("bList", bList);
		request.setAttribute("consumer", c);
		request.setAttribute("m", m);
		request.setAttribute("salePrice", salePrice);
		
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
