package com.flybutter.notice.model.dao;

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

import com.flybutter.notice.model.vo.Notice;
import com.flybutter.notice.model.vo.PageInfo;


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
	

	public ArrayList<Notice> entireSelectList(Connection conn, PageInfo pi) {
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("entireSelectList");
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("NOTICE_NO"),
									rset.getInt("NOTICE_CATEGORY"),
									rset.getString("NOTICE_TITLE")));
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


	public Notice selectNotice(Connection conn, int no) {
		Notice n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNotice");
		//selectNotice=SELECT NOTICE_NO, NOTICE_CATEGORY, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_FILE_ORIGIN, NOTICE_FILE_SYSTEM, NOTICE_DATE FROM NOTICE WHERE NOTICE_NO=?

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new Notice( rset.getInt("NOTICE_NO"),
						rset.getInt("NOTICE_CATEGORY"),
						rset.getString("NOTICE_TITLE"),
						rset.getString("NOTICE_CONTENT"),
						rset.getString("NOTICE_FILE_ORIGIN"),
						rset.getString("NOTICE_FILE_SYSTEM"),
						rset.getDate("NOTICE_DATE")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("dao select n : " + n);
		return n;
	}


	public int updateNotice(Connection conn, Notice n) {
		int result = 0;
		PreparedStatement pstmt = null;
		System.out.println("123");
		String sql = prop.getProperty("updateNotice");
System.out.println(sql);
	//updateNotice=UPDATE NOTICE SET NOTICE_CATEGORY=?, NOTICE_TITLE=?, NOTICE_CONTENT=? NOTICE_FILE_ORIGIN=? NOTICE_FILE_SYSTEM=? WHERE NOTICE_NO=?
		System.out.println("try ???");
		try {
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setInt(1, n.getNotice_Category());
			System.out.println("category : " + n.getNotice_Category());
			pstmt.setString(2, n.getNotice_Title());
			System.out.println("title : " + n.getNotice_Title());
			pstmt.setString(3, n.getNotice_Content());
			System.out.println("content : " + n.getNotice_Content());
			pstmt.setString(4, n.getNotice_File_Origin());
			System.out.println("origin : " + n.getNotice_File_Origin());
			pstmt.setString(5, n.getNotice_File_System());
			System.out.println("system : " + n.getNotice_File_System());
	
			pstmt.setInt(6, n.getNotice_No());
			System.out.println("no : " + n.getNotice_No());
				
			result = pstmt.executeUpdate();
			System.out.println("update dao result : " + result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int deleteNotice(Connection conn, int no) {
		int result = 0;
		System.out.println("delete dao no : " + no);
		PreparedStatement pstmt = null;
	
		String sql = prop.getProperty("deleteNotice");
		System.out.println("delete dao sql : " + sql);
		//deleteNotice=DELTE Notice WHERE NOTICE_NO=?
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
		
			
			result = pstmt.executeUpdate();
			System.out.println("delete dao result in try : " + result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		} 
		System.out.println("delete dao result 3 : " + result);
		return result;
	}


	public ArrayList<Notice> noticeSelectList(Connection conn, PageInfo pi) {
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("noticeSelectList");

		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("NOTICE_NO"),
									rset.getInt("NOTICE_CATEGORY"),
									rset.getString("NOTICE_TITLE")));
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


	public ArrayList<Notice> eventSelectList(Connection conn, PageInfo pi) {
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("eventSelectList");

		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("NOTICE_NO"),
									rset.getInt("NOTICE_CATEGORY"),
									rset.getString("NOTICE_TITLE")));
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


	public int getEntireListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getEntireListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);//count
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		
		return listCount;
	}


	public int getNoticeListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getNoticeListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);//count
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		
		return listCount;
	}


	public int getEventListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getEventListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);//count
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		
		return listCount;
	}


	

		
		
		
		
		
		
		
		
}
	
	
	
	
	
	
	
	
