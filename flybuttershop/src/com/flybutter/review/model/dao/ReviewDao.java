package com.flybutter.review.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.flybutter.basket.model.dao.BasketDao;
import com.flybutter.review.model.vo.PageInfo;
import com.flybutter.review.model.vo.Review;


import static com.common.JDBCTemplate.*;


public class ReviewDao {
	

		private Properties prop = new Properties();
		
		public ReviewDao() {
			String fileName = BasketDao.class.getResource("/sql/consumerMypage/mypage-query.properties").getPath();
			System.out.println("fileName : " + fileName);
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
	
	
	

	public int reviewListCount(Connection conn, int userNo) {
		
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("reviewListCount");

		try {
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				count = rset.getInt("COUNT(*)");
						
			}

			
		} catch (SQLException e) {
			System.out.println("REVIEW 테이블  reviewListCount : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return count;

	}






	public ArrayList<Review> selectList(Connection conn, PageInfo pi, int userNo) {
		ArrayList<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("reviewList");
		
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Review(rset.getInt("RE_NO"),
									rset.getString("RE_TITLE"),
									rset.getDate("RE_DATE"),
									rset.getInt("SCORE"),
									rset.getString("PNAME")
						));
			}
		} catch (SQLException e) {
			System.out.println("REVIEW 테이블  reviewList : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return list;
	}



	public Review reviewDetail(Connection conn, int no) {
		Review r = new Review();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("reviewDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);

			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				r.setRe_no(rset.getInt("RE_NO"));
				r.setUser_no(rset.getInt("USER_NO"));
				r.setRe_title(rset.getString("RE_TITLE"));
				r.setRe_content(rset.getString("RE_CONTENT"));
				r.setRe_date(rset.getDate("RE_DATE"));
				r.setScore(rset.getInt("SCORE"));
				r.setpName(rset.getString("PNAME"));
				r.setpImage_origin(rset.getString("PIMAGE_ORIGIN"));
				r.setpImage_system(rset.getString("PIMAGE_SYSTEM"));
				r.setRe_originFile(rset.getString("RE_ORIGINFILE"));
				r.setRe_changeFile(rset.getString("RE_CHANGEFILE"));
				r.setUserName(rset.getString("MEM_USER_NAME"));
				
				
			}
		} catch (SQLException e) {
			System.out.println("REVIEW 테이블  reviewDetail : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return r;
	}




	public String reviewInsertInfo(Connection conn, String pCode) {
		String pName = "";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("reviewInsertInfo");

		try {
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setString(1, pCode);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				pName = rset.getString("PNAME");
						
			}

			
		} catch (SQLException e) {
			System.out.println("reviewInsertInfo : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return pName;
	}


	public int reviewInsert(Connection conn, Review r) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("reviewInsert");

		try {
			pstmt = conn.prepareStatement(sql);

			//RE_NO, PCODE, USER_NO, RE_TITLE, RE_CONTENT,RE_DATE,RE_ORIGINFILE,RE_CHANGEFILE,RE_STATUS, PUR_NO, SCORE)
			//VALUES(REVIEW_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, 'N', ?, ?)
			
			pstmt.setString(1, r.getpCode());
			pstmt.setInt(2, r.getUser_no());
			pstmt.setString(3, r.getRe_title());
			pstmt.setString(4, r.getRe_content());
			pstmt.setString(5, r.getRe_originFile());
			pstmt.setString(6, r.getRe_changeFile());
			pstmt.setInt(7, r.getPur_no());
			pstmt.setInt(8, r.getScore());

			result = pstmt.executeUpdate();

			
		} catch (SQLException e) {
			System.out.println("REVIEW 테이블  reviewInsert : " + e.getMessage());
		}finally {

			close(pstmt);
		}
		return result;
	}




	public int updateReview(Connection conn, Review r) {
	int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateReview");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, r.getRe_title());
			pstmt.setString(2, r.getRe_content());
			pstmt.setInt(3, r.getScore());
			pstmt.setInt(4, r.getRe_no());

			result = pstmt.executeUpdate();

			
		} catch (SQLException e) {
			System.out.println("REVIEW 테이블 updateReview : " + e.getMessage());
		}finally {

			close(pstmt);
		}
		return result;
	}

}
