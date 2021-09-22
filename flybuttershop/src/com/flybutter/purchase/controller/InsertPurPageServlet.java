package com.flybutter.purchase.controller;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flybutter.basket.model.service.BasketService;
import com.flybutter.consumer.model.vo.Consumer;
import com.flybutter.consumerMyPage.model.service.MypageService;
import com.flybutter.coupon.model.vo.Coupon;
import com.flybutter.mainpage.model.service.MainPageService;
import com.flybutter.member.model.vo.Member;
import com.flybutter.money.model.vo.Money;
import com.flybutter.product.model.service.ProductService;
import com.flybutter.product.model.vo.Product;
import com.flybutter.purchase.model.service.PurchaseService;
import com.flybutter.purchase.model.vo.Purchase;
import com.flybutter.seller.model.service.SellerService;
import com.flybutter.seller.model.vo.Seller;

/**
 * Servlet implementation class InsertPurchasePageServlet
 */
@WebServlet("/insertPurInfo.hy")
public class InsertPurPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPurPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8"); 
	try {
		Member loginM = (Member)request.getSession().getAttribute("loginMember");
		
		int no = loginM.getUserNo();
		
		//소비자 인증여부
		Consumer cc = new PurchaseService().selectMoney(no);
		
		if(cc.getUser_Cel().equals("Y")) {

		
		//현재 로그인 유저의 정보가져오기
		Member m = new PurchaseService().selectMember(no);
		
		//제품상세페이지에서 전달받는 값들
		Purchase p = new Purchase();

		String pCode = request.getParameter("pCode");
		String pImg = request.getParameter("pImg");
		String pName = request.getParameter("pName");
		String option = request.getParameter("pOption");
		int price = Integer.parseInt(request.getParameter("price"));
		int pAmount = Integer.parseInt(request.getParameter("pAmount"));
		String sName = request.getParameter("sName");
		
		p.setUser_No(no);
		p.setpCode(pCode);
		p.setPur_Image(pImg);
		p.setPur_Pname(pName);
		p.setPur_POption(option);
		p.setPur_Price(price);
		p.setPur_Amount(pAmount);
		p.setPur_SName(sName);		
		
		//쿠폰에서 가져와 넘겨주기
		int use = 0;
		ArrayList<Coupon> list = new PurchaseService().selectCoupon(no, use);
		
		//적립금 가져와 넘겨주기
		Consumer c = new PurchaseService().selectMoney(no);
		
		//할인상품 체크 및 할인가격 넘겨주기
		int discountRate = new MainPageService().discountRate();
		double dr = discountRate * 0.01;
		Product pd = new ProductService().selectUpdateProduct(pCode); 
		int salePrice = 0;
		if(pd.getSale_Flag() == 1) {
			salePrice = (int) (price * dr);
		}
		
		Seller s = new Seller();
		SellerService ss = new SellerService();
	
		s=ss.selectStore(sName);

		
		request.setAttribute("salePrice", salePrice);
		request.setAttribute("purInfo", p);
		request.setAttribute("list", list);
		request.setAttribute("consumer", c);
		request.setAttribute("seller", s);
		request.setAttribute("m", m);
		request.getRequestDispatcher("views/purchase/purchasePage.jsp").forward(request, response);
		
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script charset='utf-8'> alert('소비자 인증 후 이용해주세요.'); location.href='indentifi.mp';</script>");
			
			out.flush();
		}
	}catch(NullPointerException e) {
		
		PrintWriter out = response.getWriter();
		out.println("<script charset='utf-8'> alert('로그인 후 이용해주세요.'); location.href='mainpage.ma';</script>");
		
		out.flush();
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
