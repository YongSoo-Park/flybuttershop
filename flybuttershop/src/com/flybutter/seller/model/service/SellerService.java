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

	public ArrayList<Product> selectProductList() {
		
		
		
		return null;
}

}
