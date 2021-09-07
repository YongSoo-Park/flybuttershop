package com.flybutter.member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.flybutter.member.model.vo.Member;

import static com.common.JDBCTemplate.*;
import static com.common.JDBCTemplate.close;


public class MemberDao {
	
	private Properties prop = new Properties();

	public MemberDao() {
		String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
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

	public Member loginMember(Connection conn, String userId, String userPwd) {
		Member loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^ userId :"+userId);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^ userPwd :"+userPwd);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^ sql :"+conn);
		
		String sql = prop.getProperty("loginMember");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();

			if(rset.next()) {
				loginUser = new Member(
						rset.getInt("MEM_USER_NO"),
						rset.getString("MEM_USER_ID"),
						rset.getString("MEM_USER_PWD"),
						rset.getString("MEM_USER_NAME"),
						rset.getString("MEM_PHONE"),
						rset.getString("MEM_EMAIL"),
						rset.getString("MEM_ADDRESS"),
						rset.getInt("MEM_LEV"),
						rset.getString("MEM_STATUS"),
						rset.getInt("MEM_CATEGORY")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return loginUser;
	}

	public int insertCMember(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertCMember");
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getAddress());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertSMember(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertSMember");
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getAddress());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int idCheck(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();	
			if (rset.next()) {
				result = rset.getInt(1);		
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int idFind(Connection conn, Member mem) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("idFind");	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getUserName());
			pstmt.setString(2, mem.getPhone());
			pstmt.setString(3, mem.getEmail());
			rset = pstmt.executeQuery();
			if (rset.next()) {
				//result = rset.getInt(1);
				
						
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public Member selectMember(Connection conn, Member mem) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectMember");	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getUserName());
			pstmt.setString(2, mem.getPhone());
			pstmt.setString(3, mem.getEmail());
			
			System.out.println("$$$$$$$$$$$$$$$$ getUserName()"+ mem);

			rset = pstmt.executeQuery();
			if (rset.next()) {
				member = new Member(
						
						rset.getInt("MEM_USER_NO"), 
						rset.getString("MEM_USER_ID"), 
						rset.getString("MEM_USER_PWD"),
						rset.getString("MEM_USER_NAME"), 
						rset.getString("MEM_PHONE"), 
						rset.getString("MEM_EMAIL"),
						rset.getString("MEM_ADDRESS"),
						rset.getInt("MEM_LEV"), 
						rset.getString("MEM_STATUS"),
						rset.getInt("MEM_CATEGORY")
						);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("$$$$$$$$$$$$$$$$ return:"+ member);
		return member;
	}

}
