package com.flybutter.seller.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.flybutter.product.model.vo.PageInfo;
import com.flybutter.product.model.vo.Product;
import com.flybutter.purchase.model.vo.Purchase;
import com.flybutter.qna.model.vo.Qna;
import com.flybutter.review.model.vo.Review;
import com.flybutter.seller.model.dao.SellerDao;
import com.flybutter.seller.model.vo.Seller;
import com.flybutter.seller.model.vo.SoldList;

public class SellerService {
	
	public Seller selectStore(int userNo) {
		
		Connection conn = getConnection();
		
		Seller sel = new SellerDao().selectStore(conn, userNo);
		
		close(conn);
		
		
		return sel;
	}


	public Seller updateStore(Seller seller) {
		
		Connection conn = getConnection();
		
		Seller updateStore = null;
		
		int result = new SellerDao().updateStore(conn, seller);
		
		if(result > 0) {
			
			commit(conn);
			updateStore = new SellerDao().selectStore(conn, seller.getStore_Name());
			
			System.out.println("상점 업데이트         : " + updateStore);
			
		}else {
			rollback(conn);
		}
		close(conn);
		
		return updateStore;
	}
	

	public ArrayList<Product> productList(PageInfo pi, int storeNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Product> list = new SellerDao().productList(conn, pi, storeNo);
		close(conn);
		
		
		return list;
	}


	public int getProductListCount(int storeNo) {
		Connection conn = getConnection();
		
		int listCount = new SellerDao().getProductListCount(conn, storeNo);
		close(conn);
		return listCount;
	}


	public Seller selectStore(String store_Name) {
		
		Connection conn = getConnection();
		
		Seller sel = new SellerDao().selectStore(conn, store_Name);
		
		return sel;
	}


	public ArrayList<Qna> qnaList(PageInfo pi, int storeNo) {

		Connection conn = getConnection();
		
		ArrayList<Qna> list = new SellerDao().qnaList(conn, pi, storeNo);
		close(conn);
		
		
		return list;
	}


	public ArrayList<Review> reviewList(PageInfo pi, int storeNo) {
		Connection conn = getConnection();
		
		ArrayList<Review> list = new SellerDao().reviewList(conn, pi, storeNo);
		close(conn);
		
		
		return list;
	}


	public ArrayList<SoldList> soldList(PageInfo pi, int storeNo) {
		
		Connection conn = getConnection();
		
		ArrayList<SoldList> pList = new SellerDao().soldList(conn, pi, storeNo);
		
		close(conn);
		
		return pList;
	}


	public Review selectReview(int rNo) {

		Connection conn = getConnection();
		
		Review r = new SellerDao().selectReview(conn, rNo);
		
		close(conn);
		
		return r;
	}


	public Review replyReview(Review review) {

		Connection conn = getConnection();
		
		Review reReview = null;
		
		int result = new SellerDao().replyReview(conn, review);
		
		if(result > 0) {
			commit(conn);
			
			reReview = new SellerDao().selectReview(conn, review.getRe_no());
			
		}else {
			rollback(conn);
		}
		close(conn);
		
		
		return reReview;
	}


	public ArrayList<SoldList> selectSold(int pno) {

		Connection conn = getConnection();
		
		ArrayList<SoldList> list = new SellerDao().selectSold(conn, pno);
		
		close(conn);
		
		return list;
	}


	public SoldList selectSoldInfo(int pno) {
		
		Connection conn = getConnection();
		
		SoldList s = new SellerDao().selectSoldInfo(conn, pno);
		
		close(conn);
		
		return s;
	}


	public SoldList updateDel(int pno, int delNo) {
		
		Connection conn = getConnection();
		
		SoldList updateDel = null;
		
		int result = new SellerDao().updateDel(conn, pno, delNo);
		
		if(result > 0) {
			
			commit(conn);
			updateDel = new SellerDao().selectSoldInfo(conn, pno);
			
			System.out.println("송장 업데이트         : " + updateDel);
			
		}else {
			rollback(conn);
		}
		close(conn);	
		
		return updateDel;
	}


	public int productQnaListCount(String pcode) {
		
		Connection conn = getConnection();
		
		int qnaListCount = new SellerDao().productQnaListCount(conn, pcode);
		
		close(conn);
		
		return qnaListCount;
	}


	public int productReviewCount(String pcode) {
		
		Connection conn = getConnection();
		
		int reListCount = new SellerDao().productReviewCount(conn, pcode);
		
		close(conn);
		
		return reListCount;
	}


	public int storeReviewCount(int storeNo) {
		
		Connection conn = getConnection();
		
		int listCount = new SellerDao().storeReviewCount(conn, storeNo);
		
		close(conn);
		
		return listCount;
	}


	public int soldListCount(int storeNo) {

		Connection conn = getConnection();
		
		int soldListCount = new SellerDao().soldListCount(conn, storeNo);
		
		close(conn);
		
		return soldListCount;
	}


	public String getpImage(String pCode) {

		Connection conn = getConnection();
		
		String pImg = new SellerDao().getpImage(conn, pCode);
		
		close(conn);
		return pImg;
	}


	public String getpName(String pCode) {
		
		Connection conn = getConnection();
		
		String pName = new SellerDao().getpName(conn, pCode);
		
		close(conn);
		return pName;
	}


}
