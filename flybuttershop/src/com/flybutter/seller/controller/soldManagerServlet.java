package com.flybutter.seller.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.dummy.model.vo.Member;
import com.flybutter.purchase.model.vo.Purchase;
import com.flybutter.seller.model.service.SellerService;
import com.flybutter.seller.model.vo.Seller;
import com.flybutter.seller.model.vo.SoldList;

/**
 * Servlet implementation class soldManagerServlet
 */
@WebServlet("/purchaseManager.sl")
public class soldManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public soldManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = ((Member)request.getSession().getAttribute("loginMember")).getMEM_USER_NO();
	    Seller seller = new SellerService().selectStore(userNo);
		
		System.out.println("sel" + seller);
		System.out.println("storeNo : "+seller.getStore_No());
		int storeNo = seller.getStore_No();
		
		ArrayList<Purchase> pList = new SellerService().soldList(storeNo);
		
		System.out.println("상점 판매내역 ~~~ pList" + pList);
		
		int pno = 0;
		Date pDate = null;
		String pInfo = null;
		
		for(Purchase p : pList) {
			pno = p.getPur_No();
			pDate = p.getPur_Date();
			pInfo = p.getPur_Info();
		}
		
		System.out.println(pno);
		System.out.println(pDate);
		System.out.println(pInfo);
		SoldList s = new SoldList();
		
		String[] temp1 = pInfo.split("/");
		String[] temp2;
		
		ArrayList<SoldList[]> list = new ArrayList<SoldList[]>();
		for(int i = 0 ; i <temp1.length; i++) {
	         
	         if(temp1[i].contains(String.valueOf(storeNo))) {
	            
	            temp2=temp1[i].split(":");
	            
	            list.add(new SoldList(temp2[0],temp2[1],temp2[2],temp2[3], temp2[4]));
	         }
		
		
	
		
		StringTokenizer st1 = new StringTokenizer(pInfo, "/");
		
		for (int p = 0; p < 2; p++) {
			s.setTotalPur(st1.nextToken());
			System.out.println("st1.nextToken()~~" + st1.nextToken());

			StringTokenizer st2 = new StringTokenizer(s.getTotalPur(), ":");
				System.out.println("st1.countTokens()===" + st1.countTokens());
				
			for (int k = 0; k < 2; k++) {
				s.setpCode(k + "--" + st2.nextToken());
				s.setStoreNo(k + "--" + st2.nextToken());
				s.setpAmount(k + "--" + st2.nextToken());
				s.setpOption(k + "--" + st2.nextToken());
				s.setpStatus(k + "--" + st2.nextToken());
			
				System.out.println("s.getpCode() --" + s.getpCode());
				System.out.println("s.getStoreNo --" + s.getStoreNo());
				System.out.println("s.getpAmount --" + s.getpAmount());
				System.out.println("s.getpOption --" + s.getpOption());
				System.out.println("s.getstatus() --" + s.getpStatus());
				
				
				System.out.println("########" + s);
				
				ArrayList<SoldList> slist = new ArrayList<>();
				list.add(s);
				System.out.println("list---" + list);
				
			}
		}

		
		
//		while(st.hasMoreTokens()) {
//			System.out.println(st.nextToken() +"    "+ i++);
//			
//			
//		}
//		
//		for(int j = 0; j < st.countTokens(); j++) {
//			
//		}
//		
//		ResultSet rset = null;
//		
//		
//		while(st.hasMoreTokens()) {
//			sList.add(new SoldList());
//		}
	
		
		request.setAttribute("pList", pList);
		
		RequestDispatcher view = request.getRequestDispatcher("views/seller/soldManager.jsp");
		view.forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
