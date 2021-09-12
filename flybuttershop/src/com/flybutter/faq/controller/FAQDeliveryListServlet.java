package com.flybutter.faq.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.faq.model.service.FAQService;
import com.flybutter.faq.model.vo.FAQ;


/**
 * Servlet implementation class FAQDeliveryServlet
 */
@WebServlet("/deliveryList.faq")
public class FAQDeliveryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQDeliveryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<FAQ> list = new FAQService().deliverySelectList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/faq/faqDeliveryList.jsp").forward(request, response);
		System.out.println("servlet list : " + list); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
