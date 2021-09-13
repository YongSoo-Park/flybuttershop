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

import com.common.ProductExpFileRenamePolicy;
import com.common.ProductFileRenamePolicy;
import com.flybutter.product.model.service.ProductService;
import com.flybutter.product.model.vo.Product;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(ServletFileUpload.isMultipartContent(request)) {
			//size
			int maxSize = 10 * 1024 * 1024;
			//path
			String resources1 = request.getSession().getServletContext().getRealPath("/resources");
			String savePath1 = resources1 + "\\product\\";
			System.out.println("savePath : " + savePath1);
			
			String resources2 = request.getSession().getServletContext().getRealPath("/resources");
			String savePath2 = resources2 + "\\productExp\\";
			System.out.println("savePath : " + savePath2);
			//rename
			MultipartRequest multiRequest1 = new MultipartRequest(request, savePath1, maxSize, "UTF-8", new ProductFileRenamePolicy());
			
			MultipartRequest multiRequest2 = new MultipartRequest(request, savePath2, maxSize, "UTF-8", new ProductExpFileRenamePolicy());

			String pCode = multiRequest1.getParameter("pCode");
			String pName = multiRequest1.getParameter("pName");
			int category1 = Integer.parseInt(multiRequest1.getParameter("category1"));
			int category2 = Integer.parseInt(multiRequest1.getParameter("category2"));
			int pStock = Integer.parseInt(multiRequest1.getParameter("pStock"));
			int price = Integer.parseInt(multiRequest1.getParameter("price"));
			String option = multiRequest1.getParameter("option");
			int sale = Integer.parseInt(multiRequest1.getParameter("sale"));
			
			int storeNo = ((Seller)request.getSession().getAttribute("seller")).getStore_No();
			
			Product p = new Product();
			p.setpCode(pCode);
			p.setStore_No(storeNo);
			p.setpCategory(category1);
			p.setpCategory2(category2);
			p.setpName(pName);
			p.setpOption(option);
			p.setpStock(pStock);
			p.setPrice(price);
			p.setSale_Flag(sale);
			
			
			if(multiRequest1.getOriginalFileName("pImg") != null) {
				String originPimg1 = multiRequest1.getOriginalFileName("pImg");
				String changePimg1 = multiRequest1.getFilesystemName("pImg");
				
				p.setpImage_Origin(originPimg1);
				p.setpImage_System(changePimg1);
			}
			
			if(multiRequest2.getOriginalFileName("pExpImg") != null) {
				String originPimg2 = multiRequest2.getOriginalFileName("pExpImg");
				String changePimg2 = multiRequest2.getFilesystemName("pExpImg");
				
				p.setpExp_Image_Origin(originPimg2);
				p.setpExp_Image_System(changePimg2);
			}
			
			int result = new ProductService().insertProduct(p);
			
			
			if(result > 0) {
				request.getSession().setAttribute("msg", "상품등록성공");
				response.sendRedirect("productDetail.sl");
			}else {
				if(multiRequest1.getOriginalFileName("pImg") != null || multiRequest2.getOriginalFileName("pExpImg") != null) {
					File failedFile = new File(p.getpExp_Image_Origin() + p.getpExp_Image_System()
												+ p.getpImage_Origin() + p.getpImage_System());
					failedFile.delete();
				}
				
				request.setAttribute("msg", "상품등록실패");
				RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
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
