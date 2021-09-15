package com.flybutter.help.model.dao;

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

import static com.common.JDBCTemplate.*;


import com.flybutter.help.model.vo.Help;
import com.flybutter.help.model.vo.PageInfo;
import com.flybutter.notice.model.vo.Notice;

public class HelpDao {

	private Properties prop = new Properties();
	public HelpDao() {
		String fileName = HelpDao.class.getResource("/sql/help/help-query.properties").getPath();
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
	
	public ArrayList<Help> helpSelectList(Connection conn, PageInfo pi) {
		ArrayList<Help> list = new ArrayList<Help>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("helpSelectList");
		
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;

		//helpSelectList=SELECT HELP_NO, HELP_TITLE, HELP_DATE FROM HELP
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Help(rset.getInt("HELP_NO"),
									rset.getString("HELP_TITLE"),
									rset.getDate("HELP_DATE")));
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

	public Help selectHelp(Connection conn, int no) {
		Help h = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectHelp");
		//selectHelp=SELECT HELP_NO, USER_NO, HELP_CATEGORY, HELP_TITLE, HELP_CONTENT, HELP_FILE_ORIGIN, HELP_FILE_SYSTEM, HELP_DATE, HELP_STATUS, HELP_ANSWER_CONTENT, HELP_ANSWER_DATE FROM HELP WHERE HELP_NO=?
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				h = new Help( rset.getInt("HELP_NO"),
						rset.getInt("USER_NO"),
						rset.getInt("HELP_CATEGORY"),
						rset.getString("HELP_TITLE"),
						rset.getString("HELP_CONTENT"),
						rset.getString("HELP_FILE_ORIGIN"),
						rset.getString("HELP_FILE_SYSTEM"),
						rset.getDate("HELP_DATE"),
						rset.getString("HELP_STATUS"),
						rset.getString("HELP_ANSWER_CONTENT"),
						rset.getDate("HELP_ANSWER_DATE")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return h;
	}

	public int insertHelp(Connection conn, Help h) {
		int result = 0;
		PreparedStatement pstmt = null;
		//insertHelp=INSERT INTO HELP VALUES(HELP_NO.NEXTVAL, ?, ?, ?, ?, ?, ?, SYSDATE, 'Y', ?, SYSDATE)
/*				
		HELP_NO
		USER_NO
		HELP_CATEGORY
		HELP_TITLE
		HELP_CONTENT
		HELP_FILE_ORIGIN
		HELP_FILE_SYSTEM
		HELP_DATE
		HELP_STATUS
		HELP_ANSWER_CONTENT
		HELP_ANSWER_DATE
*/		
		String sql = prop.getProperty("insertHelp");
		
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, h.getUser_No());
				pstmt.setInt(2, h.getHelp_Category());
				pstmt.setString(3, h.getHelp_Title());
				pstmt.setString(4, h.getHelp_Content());
				pstmt.setString(5, h.getHelp_File_Origin());
				pstmt.setString(6, h.getHelp_File_System());
				pstmt.setString(7, h.getHelp_Answer_Content());
			
				
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

	public int updateHelp(Connection conn, Help h) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateHelp");
	//updateHelp=UPDATE HELP SET HELP_CATEGORY=?, HELP_TITLE=?, HELP_CONTENT=?, HELP_FILE_ORIGIN=?, HELP_FILE_SYSTEM=?, HELP_STATUS='Y' WHERE HELP_NO=?
/*		HELP_NO
		USER_NO
		HELP_CATEGORY
		HELP_TITLE
		HELP_CONTENT
		HELP_FILE_ORIGIN
		HELP_FILE_SYSTEM
		HELP_DATE
		HELP_STATUS
		HELP_ANSWER_CONTENT
		HELP_ANSWER_DATE
*/
		try {
			pstmt = conn.prepareStatement(sql);
				// 유저넘버 추가해야함
			pstmt.setInt(1, h.getHelp_Category());
			pstmt.setString(2, h.getHelp_Title());
			pstmt.setString(3, h.getHelp_Content());
			pstmt.setString(4, h.getHelp_File_Origin());
			pstmt.setString(5, h.getHelp_File_System());
			pstmt.setInt(6, h.getHelp_No());
		
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteHelp(Connection conn, int no) {
		int result = 0;
	
		PreparedStatement pstmt = null;
	
		String sql = prop.getProperty("deleteHelp");
	
		//deleteHelp=DELETE HELP WHERE HELP_NO=?
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

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getListCount");
		
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
