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

}
