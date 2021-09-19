package com.flybutter.RVItems.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flybutter.RVItems.model.service.RVItemsService;
import com.flybutter.mainpage.model.service.MainPageService;
import com.flybutter.member.model.vo.Member;
import com.flybutter.product.model.vo.Product;

/**
 * Servlet implementation class RVItemsServlet
 */
@WebServlet("/rvitems.rv")
public class RVItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RVItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Member loginMember = null;
		int result;
		ArrayList<Product> RVItemsList = null;
		HttpSession session = request.getSession();
		String pCode = request.getParameter("pCode");
		loginMember = (Member) session.getAttribute("loginMember");
			
		ArrayList<String> list = new ArrayList<String>();
		String recPno=loginMember.getRecPno();
		String newRecPno = "";
		if(recPno !=null) {
			String[] temp =recPno.split("/");
			for(String s : temp) {
				list.add(s);
			}
			
			for(int i = 0 ; i <list.size() ; i++) {
				if(list.get(i).equals(pCode)) {
					list.remove(i);
				}
			}
			while(list.size() >= 10) {
				list.remove(list.size()-1);
			}
			list.add(0,pCode);
			for(String s : list) {
				newRecPno += (s+"/");
			}
		}else {
			newRecPno += (pCode+"/");
		}
		loginMember.setRecPno(newRecPno);
		if (loginMember.getUserNo() == 0) {
			newRecPno = "0";
		}
		RVItemsList = new MainPageService().RVItemsList(newRecPno);
		
		result = new RVItemsService().updateRVItems(newRecPno, loginMember.getUserNo());
		
		session.setAttribute("RVItemsList", RVItemsList);
		session.setAttribute("loginMember", loginMember);
		request.setAttribute("pCode", pCode);
		
		response.setContentType("text/html;charset=UTF-8");

		if(result > 0) {
		request.getRequestDispatcher("detail.pr").forward(request, response);
		}else {
			request.getRequestDispatcher("detaiasfafafsl.pr").forward(request, response);
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
