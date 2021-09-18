package com.flybutter.seller.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.flybutter.product.model.vo.Product;
import com.flybutter.purchase.model.vo.Purchase;
import com.flybutter.qna.model.vo.Qna;
import com.flybutter.review.model.vo.Review;
import com.flybutter.seller.model.dao.SellerDao;
import com.flybutter.seller.model.vo.Seller;

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
	

	public ArrayList<Product> productList(int storeNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Product> list = new SellerDao().productList(conn, storeNo);
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


	public ArrayList<Qna> qnaList(int storeNo) {

		Connection conn = getConnection();
		
		ArrayList<Qna> list = new SellerDao().qnaList(conn, storeNo);
		close(conn);
		
		
		return list;
	}


	public ArrayList<Review> reviewList(int storeNo) {
		Connection conn = getConnection();
		
		ArrayList<Review> list = new SellerDao().reviewList(conn, storeNo);
		close(conn);
		
		
		return list;
	}


	public ArrayList<Purchase> soldList(int storeNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Purchase> pList = new SellerDao().soldList(conn, storeNo);
		
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


}
