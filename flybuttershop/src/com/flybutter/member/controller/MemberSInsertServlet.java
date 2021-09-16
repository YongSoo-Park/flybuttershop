package com.flybutter.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.consumer.model.service.ConsumerService;
import com.flybutter.member.model.service.MemberService;
import com.flybutter.member.model.vo.Member;


/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/sInsert.me")
public class MemberSInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ConsumerService cs = new ConsumerService();
		
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String sellerYn = request.getParameter("sellerYn");
		String storeName = request.getParameter("storeName");
		String storeAddress = request.getParameter("storeAddress");
		String storeAccount = request.getParameter("storeAccount");
		String storeExp = request.getParameter("storeExp");
		String storeCall = request.getParameter("storeCall");
		String ceo = request.getParameter("ceo");
		String storeEmail = request.getParameter("storeEmail");
		
		System.out.println("############### sellerYn :"+ sellerYn);
		
		
		if(sellerYn.equals("N")) {
			
			Member mem = new Member(userId, userPwd, userName, phone, email , address);
			System.out.println("############### mem : "+mem);
			int result = new MemberService().insertCMember(mem);
			if(result>0) {
				Member memInfo = new Member(userName, phone,  email);
				
				Member rtnMemInfo = new MemberService().selectMember(memInfo);
				
				cs.createConsumer(rtnMemInfo.getUserNo());
				
				//리턴값 
				//request.getSession().setAttribute("msg", "축하합니다 ! 회원가입에 성공하셨습니다!");
				//response.sendRedirect(request.getContextPath());
				response.getWriter().write("member");
			}else{
				
				request.setAttribute("msg", "회원가입에 실패했습니다.");
				
				RequestDispatcher view = request.getRequestDispatcher("views/member/errorPage.jsp");
				view.forward(request, response);
				
			}
		}
		if(sellerYn.equals("Y")) {
			Member mem = new Member(userId, userPwd, userName, phone, email , address,storeName, storeAddress, storeAccount
					,storeExp, storeCall, ceo, storeEmail);

			System.out.println("############### mem : "+mem);
			int result = new MemberService().insertSMember(mem);
			if(result>0) {
				Member memInfo = new Member(userName, phone,  email);
				
				Member rtnMemInfo = new MemberService().selectMember(memInfo);
				
				cs.createConsumer(rtnMemInfo.getUserNo());
				//request.getSession().setAttribute("msg", "축하합니다 !회원가입과 판매자 가입에 성공하셨습니다!");
				//response.sendRedirect(request.getContextPath());
				response.getWriter().write("seller");
			}else{
				
				request.setAttribute("msg", "회원가입에 실패했습니다.");
				
				RequestDispatcher view = request.getRequestDispatcher("views/member/errorPage.jsp");
				view.forward(request, response);
			}
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
