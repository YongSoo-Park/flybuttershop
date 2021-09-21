package com.flybutter.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flybutter.product.model.service.ProductService;
import com.flybutter.product.model.vo.PageInfo;
import com.flybutter.product.model.vo.Product;
import com.flybutter.qna.model.vo.Qna;
import com.flybutter.review.model.vo.Review;
import com.flybutter.seller.model.service.SellerService;
import com.flybutter.seller.model.vo.Seller;

/**
 * Servlet implementation class productDetailServlet
 */
@WebServlet("/detail.pr")
public class productDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pcode = request.getParameter("pCode");
		System.out.println("pCode" + pcode);
		
		
		//qna 페이징
		
		int qnaListCount;			// 총 게시글 갯수
		int qnacurrentPage;		// 현재 페이지 (즉, 요청한 페이지)
		int qnastartPage;			// 현재 페이지에 하단에 보여지는 페이징 바의 시작 수 
		int qnaendPage;			// 현재 페이지에 하단에 보여지는 페이징 바의 끝 수
		int qnamaxPage;			// 전체 페이지에서의 가장 마지막 페이지
		
		int qnapageLimit;			// 한 페이지 하단에 보여질 페이지 최대 갯수
		int qnaboardLimit;			// 한 페이지에 보여질 게시글 최대 갯수
		
		qnaListCount = new SellerService().productQnaListCount(pcode);
		
		qnacurrentPage = 1;
		
		if(request.getParameter("qnacurrentPage") != null) {
			qnacurrentPage = Integer.parseInt(request.getParameter("qnacurrentPage"));
			//클릭하면 다시 currentPage 값을 셋팅해줌
		}
		
		// * pageLimit : 한 페이지 하단에 보여질 페이지 최대 갯수 
		qnapageLimit = 10;
		
		// * boardLimit : 한 페이지에 보여질 게시글 최대 갯수
		qnaboardLimit = 10;
		
		qnamaxPage = (int)Math.ceil((double)qnaListCount/qnaboardLimit);
		qnastartPage = (qnacurrentPage - 1) / qnapageLimit * qnapageLimit + 1;
		qnaendPage = qnastartPage + qnapageLimit - 1;
		
		if(qnamaxPage < qnaendPage) {
			qnaendPage = qnamaxPage;
		}
		
		PageInfo piQna = new PageInfo(qnaListCount, qnacurrentPage, qnastartPage, qnaendPage, qnamaxPage, qnapageLimit, qnaboardLimit); 
		
		//review 페이징
		
		int reListCount;			// 총 게시글 갯수
		int recurrentPage;		// 현재 페이지 (즉, 요청한 페이지)
		int restartPage;			// 현재 페이지에 하단에 보여지는 페이징 바의 시작 수 
		int reendPage;			// 현재 페이지에 하단에 보여지는 페이징 바의 끝 수
		int remaxPage;			// 전체 페이지에서의 가장 마지막 페이지
		
		int repageLimit;			// 한 페이지 하단에 보여질 페이지 최대 갯수
		int reboardLimit;			// 한 페이지에 보여질 게시글 최대 갯수
		
		reListCount = new SellerService().productReviewCount(pcode);
		
		recurrentPage = 1;
		
		if(request.getParameter("recurrentPage") != null) {
			recurrentPage = Integer.parseInt(request.getParameter("recurrentPage"));
			//클릭하면 다시 currentPage 값을 셋팅해줌
		}
		
		// * pageLimit : 한 페이지 하단에 보여질 페이지 최대 갯수 
		repageLimit = 10;
		
		// * boardLimit : 한 페이지에 보여질 게시글 최대 갯수
		reboardLimit = 10;
		
		remaxPage = (int)Math.ceil((double)reListCount/reboardLimit);
		restartPage = (recurrentPage - 1) / repageLimit * repageLimit + 1;
		reendPage = restartPage + repageLimit - 1;
		
		if(remaxPage < reendPage) {
			reendPage = remaxPage;
		}
		
		PageInfo pire = new PageInfo(reListCount, recurrentPage, restartPage, reendPage, remaxPage, repageLimit, reboardLimit); 
		
		
		Product pr = new ProductService().selectProductDetail(pcode);
		
		Seller s = new ProductService().selectProductStore(pcode);
		
		ArrayList<Qna> qList = new ProductService().productQnaList(piQna, pcode);
		
		ArrayList<Review> rList = new ProductService().productReviewList(pire, pcode);
		
		System.out.println("상품상세페이지서블릿  : " + qList);
		
		System.out.println("프로덕트 디테일"+pr);
		System.out.println("프로덕트 디테일"+s);
		System.out.println("프로덕트 디테일"+qList);
		System.out.println("프로덕트 디테일"+rList);
		
		RequestDispatcher view = null;
	
		if(pr != null || s != null || qList != null || rList != null) {
			
			request.setAttribute("pr", pr);
			request.setAttribute("s", s);
			request.setAttribute("qList", qList);
			request.setAttribute("rList", rList);
			request.setAttribute("piQna", piQna);
			request.setAttribute("pire", pire);
			request.getRequestDispatcher("views/product/productDetailView.jsp").forward(request, response);
			
		}else if(pr == null) {
			request.setAttribute("msg", "상품정보를 불러올 수 없습니다.");
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
