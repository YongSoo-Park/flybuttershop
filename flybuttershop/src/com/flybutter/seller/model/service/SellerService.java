package com.flybutter.seller.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.common.JDBCTemplate.*;

import com.flybutter.product.model.vo.Product;
import com.flybutter.seller.model.dao.SellerDao;
import com.flybutter.seller.model.vo.Seller;

public class SellerService {
	
	public Seller selectSeller() {
		
		Connection conn = getConnection();
		
		Seller sel = new SellerDao().selectSeller(conn);
		
		close(conn);
		
		
		return sel;
	}


	public Seller updateSeller(Seller seller) {
		
		Connection conn = getConnection();
		
		Seller updateStore = null;
		
		int result = new SellerDao().updateMember(conn, seller);
		
		if(result > 0) {
			commit(conn);
			updateStore = new SellerDao().selectStore(conn, seller.getStore_Name());
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


}
