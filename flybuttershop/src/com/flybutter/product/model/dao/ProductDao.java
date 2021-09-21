package com.flybutter.product.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.common.JDBCTemplate.*;

import com.flybutter.product.model.vo.PageInfo;
import com.flybutter.product.model.vo.Product;
import com.flybutter.qna.model.vo.Qna;
import com.flybutter.review.model.vo.Review;
import com.flybutter.seller.model.dao.SellerDao;
import com.flybutter.seller.model.vo.Seller;

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

	public Product selectProductDetail(Connection conn, String pcode) {
		
		Product p = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pcode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Product(rset.getString("PCODE"),
								rset.getInt("STORE_NO"),
								rset.getInt("PCATEGORY"),
								rset.getInt("PCATEGORY2"),
								rset.getString("PNAME"),
								rset.getString("POPTION"),
								rset.getInt("PSTOCK"),
								rset.getString("PIMAGE_ORIGIN"),
								rset.getString("PIMAGE_SYSTEM"),
								rset.getString("PEXP_IMAGE_ORIGIN"),
								rset.getString("PEXP_IMAGE_SYSTEM"),
								rset.getInt("PRICE"),
								rset.getString("PSTATUS"),
								rset.getDate("PDATE"),
								rset.getInt("SALE_FLAG"),
								rset.getString("SCORE_AVG"),
								rset.getInt("SCORE_COUNT")
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

	public int codeCheck(Connection conn, String pCode) {

		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("codeCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int insertProduct(Connection conn, Product pi) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pi.getpCode());
			pstmt.setInt(2, pi.getStore_No());
			pstmt.setInt(3, pi.getpCategory());
			pstmt.setInt(4, pi.getpCategory2());
			pstmt.setString(5, pi.getpName());
			pstmt.setString(6, pi.getpOption());
			pstmt.setInt(7, pi.getpStock());
			pstmt.setString(8, pi.getpImage_Origin());
			pstmt.setString(9, pi.getpImage_System());
			pstmt.setString(10, pi.getpExp_Image_Origin());
			pstmt.setString(11, pi.getpExp_Image_System());
			pstmt.setInt(12, pi.getPrice());
			pstmt.setInt(13, pi.getSale_Flag());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Product selectUpdateProduct(Connection conn, String pCode) {
		
		Product p = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectUpdateProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Product(rset.getString("PCODE"),
								rset.getInt("STORE_NO"),
								rset.getInt("PCATEGORY"),
								rset.getInt("PCATEGORY2"),
								rset.getString("PNAME"),
								rset.getString("POPTION"),
								rset.getInt("PSTOCK"),
								rset.getString("PIMAGE_ORIGIN"),
								rset.getString("PIMAGE_SYSTEM"),
								rset.getString("PEXP_IMAGE_ORIGIN"),
								rset.getString("PEXP_IMAGE_SYSTEM"),
								rset.getInt("PRICE"),
								rset.getString("PSTATUS"),
								rset.getDate("PDATE"),
								rset.getInt("SALE_FLAG"),
								rset.getString("SCORE_AVG"),
								rset.getInt("SCORE_COUNT")
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

	public Seller selectProductStore(Connection conn, String pcode) {
		
		Seller s = null;
		

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductStore");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pcode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				s = new Seller(rset.getInt("STORE_NO"),
								 rset.getString("STORE_NAME"),
								 rset.getString("STORE_ADDRESS"),
								 rset.getString("SELLER_NO"),
								 rset.getString("STORE_ACCOUNT"),
								 rset.getString("STORE_EXP"),
								 rset.getInt("STORE_LEV"),
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
		
		return s;
	}

	public ArrayList<Qna> productQnaList(Connection conn, PageInfo piQna, String pcode) {
		
		ArrayList<Qna> qList = new ArrayList<Qna>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("productQnaList");
		
		int startRow = (piQna.getCurrentPage()-1)*piQna.getBoardLimit()+1;
		int endRow = startRow + piQna.getBoardLimit()-1;
		
		

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pcode);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				qList.add(new Qna(rset.getInt("QNA_NO"),
								  rset.getInt("QNA_CATEGORY"),
								  rset.getInt("USER_NO"),
								  rset.getString("QNA_TITLE"),
								  rset.getString("QNA_CONTENT"),
								  rset.getDate("QNA_DATE"),
								  rset.getString("QNA_STATUS"),
								  rset.getInt("LOCK_FLAG"),
								  rset.getInt("QNA_PWD")
								  
								  ));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return qList;
	}

	public ArrayList<Review> productReviewList(Connection conn, PageInfo pire, String pcode) {

		ArrayList<Review> rList = new ArrayList<Review>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("productReviewList");
		
		int startRow = (pire.getCurrentPage()-1)*pire.getBoardLimit()+1;
		int endRow = startRow + pire.getBoardLimit()-1;
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pcode);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				rList.add(new Review(rset.getInt("RE_NO"),
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
		
		return rList;
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

	public int deleteProduct(Connection conn, String pcode) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pcode);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		} 

		return result;
	}

	public int updateProduct(Connection conn, Product pi) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pi.getpName());
			pstmt.setInt(2, pi.getpCategory());
			pstmt.setInt(3, pi.getpCategory2());
			pstmt.setInt(4, pi.getpStock());
			pstmt.setInt(5, pi.getPrice());
			pstmt.setString(6, pi.getpOption());
			pstmt.setInt(7, pi.getSale_Flag());
			pstmt.setString(8, pi.getpImage_Origin());
			pstmt.setString(9, pi.getpImage_System());
			pstmt.setString(10, pi.getpExp_Image_Origin());
			pstmt.setString(11, pi.getpExp_Image_System());
			
			pstmt.setString(12, pi.getpCode());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
}
