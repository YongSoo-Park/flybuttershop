package com.flybutter.qna.model.dao;

import static com.common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.flybutter.notice.model.dao.NoticeDao;
import com.flybutter.qna.model.vo.Qna;

public class QnaDao {
	
	private Properties prop = new Properties();
	
	public QnaDao() {
		
		String fileName = NoticeDao.class.getResource("/sql/qna/qna-query.properties").getPath();
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

	public int insertQna(Connection conn, Qna q) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertQna");
		//INSERT INTO QNA(SEQ_QNA_NO.nextval,?,?,?,?,?,?,?,SYSDATE,DEFAULT,NULL,NULL,?,?)
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, q.getUser_No());
			pstmt.setString(2, q.getpCode());
			pstmt.setInt(3, q.getStore_no());
			pstmt.setInt(4, q.getQna_Pwd());
			pstmt.setInt(5, q.getQna_Category());
			pstmt.setString(6, q.getQna_Title());
			pstmt.setString(7, q.getQna_Content());
			pstmt.setInt(8,q.getLock_Flag());
			pstmt.setString(9, q.getQna_Writer());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Qna selectQna(Connection conn, int qNo) {
		
		Qna q = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectQnaDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				q = new Qna(rset.getInt("QNA_NO"),
							rset.getInt("USER_NO"),
							rset.getString("PCODE"),
							rset.getInt("QNA_PWD"),
							rset.getInt("QNA_CATEGORY"),
							rset.getString("QNA_TITLE"),
							rset.getString("QNA_CONTENT"),
							rset.getDate("QNA_DATE"),
							rset.getString("QNA_STATUS"),
							rset.getInt("LOCK_FLAG"),
							rset.getString("QNA_COMMENT"),
							rset.getDate("QNA_COMMENT_DATE"),
							rset.getString("MEM_USER_ID")
							);
						
			}
			
			System.out.println("serviceeeeeee " + q);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return q;
	}

}
