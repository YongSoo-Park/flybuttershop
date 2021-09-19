package com.flybutter.RVItems.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class RVItemsDao {

	private Properties prop = new Properties();

	public RVItemsDao() {

		String fileName = RVItemsDao.class.getResource("/sql/RVItems/RVItems-query.properties").getPath();
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

	public int updateRVItems(Connection conn, String newRecPno, int userNo) {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updateRVItems");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newRecPno);
			pstmt.setInt(2, userNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(pstmt);
		}

		return result;
	}

}
