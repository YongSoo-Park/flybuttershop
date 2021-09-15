package com.flybutter.product.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.flybutter.product.model.dao.ProductDao;
import com.flybutter.product.model.vo.Product;
import com.flybutter.qna.model.vo.Qna;
import com.flybutter.seller.model.vo.Seller;

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

	public int insertProduct(Product p) {
		

		Connection conn = getConnection();
		
		int result = new ProductDao().insertProduct(conn, p);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);

		return result;
	}

	public Product selectUpdateProduct(String pCode) {
		Connection conn = getConnection();
		
		Product p = new ProductDao().selectUpdateProduct(conn, pCode);
		
		close(conn);
		
		System.out.println();
		
		return p;
	}

	public Seller selectProductStore(String pcode) {
		
		Connection conn = getConnection();
		
		Seller s = new ProductDao().selectProductStore(conn, pcode);
		
		close(conn);
		
		return s;
	}

	public ArrayList<Qna> productQnaList(String pcode) {

		Connection conn = getConnection();
		
		ArrayList<Qna> qList = new ProductDao().productQnaList(conn, pcode);
		
		close(conn);
		
		return qList;
	}

	
}
