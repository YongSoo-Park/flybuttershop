package com.flybutter.seller.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.flybutter.product.model.vo.PageInfo;
import com.flybutter.product.model.vo.Product;
import com.flybutter.purchase.model.vo.Purchase;
import com.flybutter.qna.model.vo.Qna;
import com.flybutter.review.model.vo.Review;
import com.flybutter.seller.model.vo.Seller;
import com.flybutter.seller.model.vo.SoldList;

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
		public Seller selectStore(Connection conn, int userNo) {
			
			Seller sel = null;
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectSeller");
			//selectSeller=SELECT * FROM SELLER WHERE USER_NO = ?
			try {
				pstmt = conn.prepareStatement(sql);		
				pstmt.setInt(1, userNo);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					sel = new Seller(rset.getInt("STORE_NO"),
									 rset.getInt("USER_NO"),
									 rset.getString("STORE_NAME"),
									 rset.getString("STORE_ADDRESS"),
									 rset.getString("SELLER_NO"),
									 rset.getString("STORE_ACCOUNT"),
									 rset.getString("STORE_EXP"),
									 rset.getInt("STORE_LEV"),
									 rset.getInt("TOTALSALES"),
									 rset.getString("STORECALL"),
									 rset.getString("CEO"),
									 rset.getString("EMAIL")
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
		
		
		public int updateStore(Connection conn, Seller seller) {
			
			int result = 0;
			
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("updateStore");
			//UPDATE SELLER SET SELLER_NO = ?, STORE_ADDRESS = ?, STORE_ACCOUNT = ?, STORE_EXP = ? STORECALL = ? CEO = ? EMAIL = ? WHERE STORE_NAME = ?   
			
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, seller.getSeller_No());
					pstmt.setString(2, seller.getStore_Address());
					pstmt.setString(3, seller.getStore_Account());
					pstmt.setString(4, seller.getStore_Exp());
					pstmt.setString(5, seller.getStoreCall());
					pstmt.setString(6, seller.getCeo());
					pstmt.setString(7, seller.getEmail());
					pstmt.setString(8, seller.getStore_Name());
					
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
									 rset.getInt("USER_NO"),
									 rset.getString("STORE_NAME"),
									 rset.getString("STORE_ADDRESS"),
									 rset.getString("SELLER_NO"),
									 rset.getString("STORE_ACCOUNT"),
									 rset.getString("STORE_EXP"),
									 rset.getInt("STORE_LEV"),
									 rset.getInt("TOTALSALES"),
									 rset.getString("STORECALL"),
									 rset.getString("CEO"),
									 rset.getString("EMAIL")
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
		public ArrayList<Product> productList(Connection conn, PageInfo pi, int storeNo) {
			
			ArrayList<Product> list = new ArrayList<Product>();
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("productList");
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, storeNo);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
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
		public ArrayList<Qna> qnaList(Connection conn, PageInfo pi, int storeNo) {

			ArrayList<Qna> list = new ArrayList<Qna>();
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("sellerQnaList");
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, storeNo);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					list.add(new Qna(rset.getInt("QNA_NO"),
									 rset.getString("PCODE"),
									 rset.getInt("QNA_CATEGORY"),
									 rset.getInt("USER_NO"),
									 rset.getString("QNA_TITLE"),
									 rset.getString("QNA_CONTENT"),
									 rset.getDate("QNA_DATE"),
									 rset.getString("QNA_STATUS")
									));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
		public ArrayList<Review> reviewList(Connection conn, PageInfo pi, int storeNo) {
			ArrayList<Review> list = new ArrayList<Review>();
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("sellerReviewList");
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, storeNo);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					list.add(new Review(rset.getInt("RE_NO"),
										 rset.getString("PCODE"),
										 rset.getInt("USER_NO"),
										 rset.getString("RE_TITLE"),
										 rset.getString("RE_CONTENT"),
										 rset.getDate("RE_DATE"),
										 rset.getString("RE_ORIGINFILE"),
										 rset.getString("RE_CHANGEFILE"),
										 rset.getString("RE_STATUS").charAt(0),
										 rset.getString("RERE_TITLE"),
										 rset.getString("RERE_CONTENT"),
										 rset.getDate("RERE_DATE"),
										 rset.getInt("STORE_NO"),
										 rset.getInt("PUR_NO"),
										 rset.getInt("SCORE"),
										 rset.getString("MEM_USER_ID")
										));
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
		public ArrayList<Purchase> soldList(Connection conn, int storeNo) {
			
			ArrayList<Purchase> pList = new ArrayList<>();
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("soldList");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "_____"+storeNo+"%");
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					pList.add(new Purchase(rset.getInt("PUR_NO"),
										   rset.getDate("PUR_DATE"),
										   rset.getString("PUR_INFO")
										   ));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return pList;
		}
		public Review selectReview(Connection conn, int rNo) {
			
			Review r = null;
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectReviewDetail");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					r = new Review(rset.getInt("RE_NO"),
									 rset.getString("PCODE"),
									 rset.getInt("USER_NO"),
									 rset.getString("RE_TITLE"),
									 rset.getString("RE_CONTENT"),
									 rset.getDate("RE_DATE"),
									 rset.getString("RE_ORIGINFILE"),
									 rset.getString("RE_CHANGEFILE"),
									 rset.getString("RE_STATUS").charAt(0),
									 rset.getString("RERE_TITLE"),
									 rset.getString("RERE_CONTENT"),
									 rset.getDate("RERE_DATE"),
									 rset.getInt("STORE_NO"),
									 rset.getInt("PUR_NO"),
									 rset.getInt("SCORE"),
									 rset.getString("MEM_USER_ID"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return r;
		}
		public int replyReview(Connection conn, Review review) {
			
			int result = 0;
			
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("replyReview");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, review.getRere_content());
				pstmt.setInt(2, review.getRe_no());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
		}
		public ArrayList<SoldList> selectSold(Connection conn, int pno) {

			ArrayList<SoldList> list = new ArrayList<>();
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectSold");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pno);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					list.add(new SoldList(rset.getInt("USER_NO"),
										  rset.getInt("PUR_NO"),
									      rset.getDate("PUR_DATE"),
									      rset.getInt("PUR_PRICE"),
									      rset.getString("PUR_ADDRESS"),
									      rset.getInt("PUR_TYPE"),
									      rset.getInt("DEL_NO"),
									      rset.getString("PUR_INFO"),
									      rset.getString("MEM_USER_ID"),
									      rset.getString("MEM_USER_NAME"),
									      rset.getString("MEM_PHONE")
										  ));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
		public SoldList selectSoldInfo(Connection conn, int pno) {

			SoldList s = null;
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectSoldInfo");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pno);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					s = new SoldList(rset.getInt("USER_NO"),
									  rset.getInt("PUR_NO"),
								      rset.getDate("PUR_DATE"),
								      rset.getInt("PUR_PRICE"),
								      rset.getString("PUR_ADDRESS"),
								      rset.getInt("PUR_TYPE"),
								      rset.getInt("DEL_NO"),
								      rset.getString("PUR_INFO"),
								      rset.getString("MEM_USER_ID"),
								      rset.getString("MEM_USER_NAME"),
								      rset.getString("MEM_PHONE")
									);				
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			
			return s;
		}
		public int updateDel(Connection conn, int pno, int delNo) {
			
			int result = 0;
			
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("updateDel");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, delNo);
				pstmt.setInt(2, pno);
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			
			return result;
		}
		public int productQnaListCount(Connection conn, String pcode) {
			
			int qnaListCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("productQnaListCount");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pcode);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					qnaListCount = rset.getInt(1);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return qnaListCount;
		}
		public int productReviewCount(Connection conn, String pcode) {
			int reListCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("productReviewCount");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pcode);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					reListCount = rset.getInt(1);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return reListCount;
		}
		public int storeReviewCount(Connection conn, int storeNo) {
			
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("storeReviewCount");
			
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
