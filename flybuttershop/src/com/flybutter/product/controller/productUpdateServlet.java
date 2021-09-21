package com.flybutter.product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.ProductFileRenamePolicy;
import com.flybutter.member.model.vo.Member;
import com.flybutter.product.model.service.ProductService;
import com.flybutter.product.model.vo.Product;
import com.flybutter.seller.model.service.SellerService;
import com.flybutter.seller.model.vo.Seller;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class productUpdateServlet
 */
@WebServlet("/update.pr")
public class productUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//size
		int maxSize = 10 * 1024 * 1024;
		System.out.println("maxSize" + maxSize);
		
		//path
		String resources = request.getSession().getServletContext().getRealPath("/resources");
		String savePath = resources + "\\product\\";
		System.out.println("savePath : " + savePath);
		
		String savePath2 = resources + "\\productExp\\";
		System.out.println("savePath : " + savePath2);
		//rename
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new ProductFileRenamePolicy());

		Product pi = new Product();
		
		File tempFile = null;
		
		int emptyCount = 0;
		
		for(int i = 1; i<=2; i++) {
			String name = "file"+i;
			if(multiRequest.getOriginalFileName(name) != null) {
				String originPimg = multiRequest.getOriginalFileName(name);
				String changePimg = multiRequest.getFilesystemName(name);
				
				pi.setpImage_Origin(savePath+originPimg);
				pi.setpImage_System(savePath+changePimg);
				

				tempFile = new File(savePath+changePimg);
				tempFile.delete();
				
				if(i==2) {
					String originExpimg = multiRequest.getOriginalFileName(name);
					String changeExpimg = multiRequest.getOriginalFileName(name);
					
					pi.setpExp_Image_Origin(savePath2+originExpimg);
					pi.setpExp_Image_System(savePath2+changeExpimg);
					
					tempFile = new File(savePath2+changeExpimg);
					tempFile.delete();
				}
			}else {
				emptyCount++;
			}
		}
		
		String pCode = multiRequest.getParameter("pCode");
		String pName = multiRequest.getParameter("pName");
		int category1 = Integer.parseInt(multiRequest.getParameter("category1"));
		int category2 = Integer.parseInt(multiRequest.getParameter("category2"));
		int pStock = Integer.parseInt(multiRequest.getParameter("pStock"));
		int price = Integer.parseInt(multiRequest.getParameter("price"));
		String option = multiRequest.getParameter("pOption");
		int sale = Integer.parseInt(multiRequest.getParameter("sale"));
		
		int userNo = ((Member)request.getSession().getAttribute("loginMember")).getUserNo();
		Seller seller = new SellerService().selectStore(userNo);
		int storeNo = seller.getStore_No();
		
		pi.setpCode(pCode);
		pi.setpCategory(category1);
		pi.setpCategory2(category2);
		pi.setpName(pName);
		pi.setpOption(option);
		pi.setpStock(pStock);
		pi.setPrice(price);
		pi.setSale_Flag(sale);
		
		int result = new ProductService().updateProduct(pi);
		
		if(emptyCount==2) {
			request.setAttribute("msg", "상품 수정 실패");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
		
		response.sendRedirect("productManager.sl");
		}
		

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
