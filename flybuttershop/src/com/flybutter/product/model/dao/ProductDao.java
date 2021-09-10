package com.flybutter.product.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.common.JDBCTemplate.*;

import com.flybutter.product.model.vo.Product;
import com.flybutter.seller.model.dao.SellerDao;

public class ProductDao {
	
	private Properties prop = new Properties();
	
	public ProductDao() {
		
		String fileName = SellerDao.class.getResource("/sql/product/product-query.properties").getPath();
		System.out.println("fileName   " + fileName);
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Product selectProduct(Connection conn, String pCode) {

		Product p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Product(rset.getString("PCODE"),
								rset.getString("PNAME"),
								rset.getString("POPTION"),
								rset.getString("PIMAGE_ORIGIN"),
								rset.getInt("PRICE"),
								rset.getString("PSTATUS"),
								rset.getInt("SALE_FLAG")
								);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return p;
	}

}
