package com.flybutter.search.model.dao;

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

import com.flybutter.search.model.vo.Search;

public class SearchDao {

	private Properties prop = new Properties();

	public SearchDao() {

		String fileName = SearchDao.class.getResource("/sql/search/search-query.properties").getPath();
		System.out.println("fileName   " + fileName);

		try {
			prop.load(new FileReader(fileName));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Search> searchList(Connection conn, String sWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Search> searchList = new ArrayList<Search>();
		String sql = prop.getProperty("searchList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+sWord+"%");
			rset = pstmt.executeQuery();
			while (true) {
				if (rset.next()) {
					searchList.add(new Search(rset.getString("PCODE"),rset.getString("PIMAGE_ORIGIN"),rset.getString("PNAME"),rset.getInt("PRICE"), rset.getString("SCORE_AVG"),rset.getInt("PSTOCK"),rset.getInt("STORE_NO"),rset.getString("STORE_NAME"),rset.getInt("STORE_LEV")));
					continue;
				} else {
					break;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(rset);
			close(pstmt);
		}
		System.out.println(searchList);
		return searchList;
	}
	
	public ArrayList<Search> searchSaleList(Connection conn, String sWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Search> searchSaleList = new ArrayList<Search>();
		String sql = prop.getProperty("searchSaleList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+sWord+"%");
			rset = pstmt.executeQuery();
			while (true) {
				if (rset.next()) {
					searchSaleList.add(new Search(rset.getString("PCODE"),rset.getString("PIMAGE_ORIGIN"),rset.getString("PNAME"),rset.getInt("PRICE")));
					continue;
				} else {
					break;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(rset);
			close(pstmt);
		}
		return searchSaleList;
	}

}
