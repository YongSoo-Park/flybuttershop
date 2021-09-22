package com.flybutter.product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.ProductFileRenamePolicy;
import com.flybutter.member.model.vo.Member;
import com.flybutter.product.model.service.ProductService;
import com.flybutter.product.model.vo.Product;
import com.flybutter.seller.model.service.SellerService;
import com.flybutter.seller.model.vo.Seller;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class productInsertServlet
 */
@WebServlet("/insert.pr")
public class productInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public productInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");

		System.out.println("상품등록 서블릿 입장");

		if (ServletFileUpload.isMultipartContent(request)) {
			// size
			int maxSize = 10 * 1024 * 1024;
			System.out.println("maxSize" + maxSize);

			// path
			String savePath = request.getServletContext().getRealPath("/resources/product");
			System.out.println("savePath : " + savePath);

			// rename
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
					new ProductFileRenamePolicy());

			Product pi = new Product();

			File tempFile = null;

			for (int i = 1; i <= 2; i++) {
				String name = "file" + i;

				if (i == 1) {
					if (multiRequest.getOriginalFileName(name) != null) {
						String originPimg = multiRequest.getOriginalFileName(name);
						String changePimg = multiRequest.getFilesystemName(name);

						pi.setpImage_Origin("/resources/product/" + changePimg);
						pi.setpImage_System("/resources/product/" + originPimg);

						tempFile = new File(savePath + originPimg);
						tempFile.delete();
					}

				} else if (i == 2) {
					if (multiRequest.getOriginalFileName(name) != null) {
						String originExpimg = multiRequest.getOriginalFileName(name);
						String changeExpimg = multiRequest.getFilesystemName(name);

						pi.setpExp_Image_Origin("/resources/product/" + changeExpimg);
						pi.setpExp_Image_System("/resources/product/" + originExpimg);

						tempFile = new File(savePath + originExpimg);
						tempFile.delete();
					}
				}
			}


			String pCode = multiRequest.getParameter("pCode");
			String pName = multiRequest.getParameter("pName");
			int category1 = Integer.parseInt(multiRequest.getParameter("category1"));
			int category2 = Integer.parseInt(multiRequest.getParameter("category2"));
			int pStock = Integer.parseInt(multiRequest.getParameter("pStock"));
			int price = Integer.parseInt(multiRequest.getParameter("price"));
			String option = multiRequest.getParameter("option");
			int sale = Integer.parseInt(multiRequest.getParameter("sale"));

			int userNo = ((Member) request.getSession().getAttribute("loginMember")).getUserNo();
			Seller seller = new SellerService().selectStore(userNo);
			int storeNo = seller.getStore_No();

			System.out.println("상품등록 ~~~~ " + storeNo);

			pi.setpCode(pCode);
			pi.setStore_No(storeNo);
			pi.setpCategory(category1);
			pi.setpCategory2(category2);
			pi.setpName(pName);
			pi.setpOption(option);
			pi.setpStock(pStock);
			pi.setPrice(price);
			pi.setSale_Flag(sale);

			int result = new ProductService().insertProduct(pi);

			
			
			if(result > 0) {
				response.sendRedirect("productManager.sl");
			}else {
				request.setAttribute("msg", "상품등록 실패");
				RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
				view.forward(request, response);
			}
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
