package com.flybutter.product.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.flybutter.product.model.dao.ProductDao;
import com.flybutter.product.model.vo.Product;

public class ProductService {

	public Product selectProduct(String pCode) {
		
		Connection conn = getConnection();
		
		Product p = new ProductDao().selectProduct(conn, pCode);
		
		close(conn);
	
		
		return p;
	}

	public Product selectProductDetail(String pcode) {
		
		Connection conn = getConnection();
		
		Product p = new ProductDao().selectProductDetail(conn, pcode);
		
		close(conn);
		
		return p;
	}

	public int codeCheck(String pCode) {
		
		Connection conn = getConnection();
		
		int result = new ProductDao().codeCheck(conn, pCode);
		
		close(conn);

		return result;
	}

}
