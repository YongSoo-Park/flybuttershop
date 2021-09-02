package com.flybutter.dummy.model.dao;

import static com.common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.flybutter.dummy.model.vo.Member;


public class MemberDao {

	private Properties prop = new Properties();

	public MemberDao() {
		String fileName = MemberDao.class.getResource("/sql/dummy/dummy-query.properties").getPath();
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

	public Member loginMember(Connection conn) {
		Member loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("dummyMember");
		try {
			pstmt = conn.prepareStatement(sql);


			rset = pstmt.executeQuery();

			if (rset.next()) {
				loginUser = new Member(rset.getInt("MEM_USER_NO"), rset.getString("MEM_USER_ID"), rset.getString("MEM_USER_PWD"),
						rset.getString("MEM_USER_NAME"), rset.getString("MEM_PHONE"), rset.getString("MEM_EMAIL"),
						rset.getString("MEM_ADDRESS"), rset.getInt("MEM_LEV"), rset.getString("MEM_STATUS"));
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(rset);
			close(pstmt);
		}

		return loginUser;
	}

}
