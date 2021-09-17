package com.flybutter.admin.model.dao;

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

import com.flybutter.admin.model.vo.Admin;

public class AdminDao {

	private Properties prop = new Properties();

	public AdminDao() {

		String fileName = AdminDao.class.getResource("/sql/admin/admin-query.properties").getPath();
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

	public ArrayList<Admin> memberList(Connection conn) {

		ArrayList<Admin> memberList = new ArrayList<Admin>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("memberList");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				memberList.add(new Admin(rset.getInt("MEM_LEV"), rset.getString("MEM_USER_ID"),
						rset.getString("MEM_USER_NAME"), rset.getString("MEM_EMAIL"), rset.getString("USER_CEL"),
						rset.getInt("MEM_USER_NO"), rset.getInt("MEM_CATEGORY")));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return memberList;
	}

	public ArrayList<Admin> sellerList(Connection conn) {

		ArrayList<Admin> sellerList = new ArrayList<Admin>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("sellerList");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				sellerList.add(new Admin(rset.getInt("STORE_LEV"), rset.getString("SELLER_NO"),
						rset.getString("STORE_NAME"), rset.getString("CEO"), rset.getString("EMAIL"),
						rset.getInt("TOTALSALES"), rset.getInt("USER_NO"), rset.getInt("STORE_NO")));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return sellerList;

	}

	public int memberListCount(Connection conn) {
		int memberListCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("memberListCount");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				memberListCount = rset.getInt("COUNT");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return memberListCount;
	}

	public int sellerListCount(Connection conn) {
		int sellerListCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("sellerListCount");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				sellerListCount = rset.getInt("COUNT");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return sellerListCount;
	}

}
