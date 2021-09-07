package com.flybutter.seller.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.common.JDBCTemplate.*;

import com.flybutter.seller.model.vo.Seller;

public class SellerDao {
	
		private Properties prop = new Properties();
		
		public SellerDao() {
			
			String fileName = SellerDao.class.getResource("/sql/seller/seller-query.properties").getPath();
			System.out.println("fileName   " + fileName);
			
			try {
				prop.load(new FileReader(fileName));
				
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			
		}
		public Seller selectSeller(Connection conn) {
			
			Seller sel = null;
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectSeller");
			
			try {
				pstmt = conn.prepareStatement(sql);		
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					sel = new Seller(rset.getInt("STORE_NO"),
									 rset.getInt("USER_NO"),
									 rset.getString("STORE_NAME"),
									 rset.getString("STORE_ADDRESS"),
									 rset.getString("SELLER_NO"),
									 rset.getString("STORE_ACCOUNT"),
									 rset.getString("STORE_EXP")
							  		 );
					}

				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return sel;
		}

	}
