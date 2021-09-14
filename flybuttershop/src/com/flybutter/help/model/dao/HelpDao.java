package com.flybutter.help.model.dao;

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


import com.flybutter.help.model.vo.Help;
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
	
	public ArrayList<Help> helpSelectList(Connection conn) {
		ArrayList<Help> list = new ArrayList<Help>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("helpSelectList");

		//helpSelectList=SELECT HELP_NO, HELP_TITLE, HELP_DATE FROM HELP
		try {
			pstmt = conn.prepareStatement(sql);
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
		//insertHelp=INSERT INTO HELP VALUES(HELP_NO.NEXTVAL, USER_NO, ?, ?, ?, ?, ?, SYSDATE, 'Y', )
				
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
		
		String sql = prop.getProperty("insertHelp");
		
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
