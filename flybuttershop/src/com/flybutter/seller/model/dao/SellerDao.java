package com.flybutter.seller.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.flybutter.product.model.vo.Product;
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
		public int updateMember(Connection conn, Seller seller) {
			
			int result = 0;
			
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("updateStore");
			//UPDATE SELLER SET SELLER_NO = ?, STORE_ADDRESS = ?, STORE_ACCOUNT = ?, STORE_EXP = ? WHERE STORE_NAME = ?   
			
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, seller.getStore_Address());
					pstmt.setString(2, seller.getSeller_No());
					pstmt.setString(3, seller.getStore_Account());
					pstmt.setString(4, seller.getStore_Exp());
					pstmt.setString(5, seller.getStore_Name());
					
					result = pstmt.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					close(pstmt);
				}
				
			return result;
		}
		public Seller selectStore(Connection conn, String store_Name) {
			
			Seller sel = null;
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectStore");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, store_Name);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					sel = new Seller(rset.getInt("STORE_NO"),
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
		public ArrayList<Product> productList(Connection conn, int storeNo) {
			
			ArrayList<Product> list = new ArrayList<Product>();
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("productList");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, storeNo);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					list.add(new Product(rset.getString("PCODE"),
										 rset.getInt("PCATEGORY"),
										 rset.getInt("PCATEGORY2"),
										 rset.getString("PNAME"),
										 rset.getString("POPTION"),
										 rset.getInt("PRICE"),
										 rset.getInt("PSTOCK"),
										 rset.getDate("PDATE"),
										 rset.getString("PSTATUS"),
										 rset.getInt("SALE_FLAG")
										));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
		public int getProductListCount(Connection conn, int storeNo) {
			
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("getProductListCount");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, storeNo);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					listCount = rset.getInt(1);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return listCount;
		}

	}
