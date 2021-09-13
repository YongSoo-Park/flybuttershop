package com.flybutter.faq.model.dao;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import com.flybutter.faq.model.vo.FAQ;



public class FAQDao {
	private Properties prop = new Properties();
	public FAQDao() {
		String fileName = FAQDao.class.getResource("/sql/faq/faq-query.properties").getPath();
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
	
	public ArrayList<FAQ> deliverySelectList(Connection conn) {
		ArrayList<FAQ> list = new ArrayList<FAQ>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("deliverySelectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new FAQ(rset.getInt("FAQ_NO"),
									rset.getInt("FAQ_CATEGORY"),
									rset.getString("FAQ_TITLE")));
			}
			System.out.println("dao list : " + list);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt); 
		
		}
	
		return list;
	}

	public int insertFAQ(Connection conn, FAQ f) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertFAQ");
		
		try {
			pstmt = conn.prepareStatement(sql);
			//insertFAQ=INSERT INTO FAQ VALUES(SEQ_FNO.NEXTVAL, ?, ?, ?)
			pstmt.setInt(1,f.getFaq_Category());
			pstmt.setString(2, f.getFaq_Title());
			pstmt.setString(3, f.getFaq_Content());
			
			result = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
		return result;
	}

	public FAQ selectFAQ(Connection conn, int no) {
		FAQ f = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFAQ");
	//	selectFAQ=SELECT FAQ_NO, FAQ_CATEGORY, FAQ_TITLE, FAQ_CONTENT FROM FAQ
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				f = new FAQ(
						rset.getInt("FAQ_NO"),
						rset.getInt("FAQ_CATEGORY"),
						rset.getString("FAQ_TITLE"),
						rset.getString("FAQ_CONTENT")						
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		
		}
		
		
		return f;
	}

	public int updateFAQ(Connection conn, FAQ f) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateFAQ");

		//updateFAQ=UPDATE FAQ SET FAQ_CATEGORY=?, FAQ_TITLE=?, FAQ_CONTENT=? WHERE FAQ_NO=?
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, f.getFaq_Category());
			pstmt.setString(2, f.getFaq_Title());
			pstmt.setString(3, f.getFaq_Content());
			pstmt.setInt(4, f.getFaq_No());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
				
		return result;
		
		
	}

	public int deleteFAQ(Connection conn, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteFAQ");
		//deleteFAQ=DELETE FAQ WHERE FAQ_NO=?
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
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