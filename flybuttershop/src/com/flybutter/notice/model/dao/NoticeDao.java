package com.flybutter.notice.model.dao;

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

import com.flybutter.notice.model.vo.Notice;


public class NoticeDao {
	private Properties prop = new Properties();
	
	public NoticeDao() {
		String fileName = NoticeDao.class.getResource("/sql/notice/notice-query.properties").getPath();
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
	

	public ArrayList<Notice> entireSelectList(Connection conn) {
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("entireSelectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("NOTICE_CATEGORY"),
									rset.getString("NOTICE_TITLE")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		System.out.println("dao list : " + list);
		return list;
	}


	public int insertNotice(Connection conn, Notice n) {
		int result = 0;
		PreparedStatement pstmt = null;
		//insertNotice=INSERT INTO NOTICE VALUES(NOTICE_NO.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)
		
		
		String sql = prop.getProperty("insertNotice");
		
		
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, n.getNotice_Category());
				pstmt.setString(2, n.getNotice_Title());
				pstmt.setString(3, n.getNotice_Content() );
				pstmt.setString(4, n.getNotice_File_Origin());
				pstmt.setString(5, n.getNotice_File_System());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			System.out.println("result from dao : " + result);
		return result;
	}

		
		
		
		
		
		
		
		
}
	
	
	
	
	
	
	
	
