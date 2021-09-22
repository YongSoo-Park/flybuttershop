package com.flybutter.category.model.dao;

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

import com.flybutter.category.model.vo.Category;
import com.flybutter.consumerMyPage.model.service.MypageService;

public class CategoryDao {

	private Properties prop = new Properties();

	public CategoryDao() {

		String fileName = CategoryDao.class.getResource("/sql/category/category-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Category> categoryList(Connection conn, int mCategory, int sCategory, int userNo) {
		int wishListTemp;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Category> categoryList = new ArrayList<Category>();
		String sql = prop.getProperty("categoryList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mCategory);
			if (sCategory == 0) {
				pstmt.setString(2, "%");
			} else {
				pstmt.setInt(2, sCategory);
			}
			rset = pstmt.executeQuery();
			while (true) {
				if (rset.next()) {
					wishListTemp = new MypageService().checkWish(userNo, rset.getString("PCODE"));
					categoryList.add(new Category(rset.getString("PCODE"), rset.getString("PIMAGE_ORIGIN"),
							rset.getString("PNAME"), rset.getInt("PRICE"), rset.getString("SCORE_AVG"),
							rset.getInt("PSTOCK"), rset.getInt("STORE_NO"), rset.getString("STORE_NAME"),
							rset.getInt("STORE_LEV"),wishListTemp));
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
		return categoryList;
	}

	public ArrayList<Category> categorySaleList(Connection conn, int mCategory, int sCategory) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Category> categoryList = new ArrayList<Category>();
		String sql = prop.getProperty("categorySaleList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mCategory);
			if (sCategory == 0) {
				pstmt.setString(2, "%");
			} else {
				pstmt.setInt(2, sCategory);
			}
			rset = pstmt.executeQuery();
			while (true) {
				if (rset.next()) {
					categoryList.add(new Category(rset.getString("PCODE"), rset.getString("PIMAGE_ORIGIN"),
							rset.getString("PNAME"), rset.getInt("PRICE")));
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
		return categoryList;
	}

	public int categoryListCount(Connection conn, int mCategory, int sCategory) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("categoryListCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mCategory);
			if (sCategory == 0) {
				pstmt.setString(2, "%");
			} else {
				pstmt.setInt(2, sCategory);
			}
			rset = pstmt.executeQuery();

			if (rset.next()) {
				count = rset.getInt("TOTAL");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(rset);
			close(pstmt);
		}
		return count;
	}

	public ArrayList<Category> categoryListNext(Connection conn, int mCategory, int sCategory, int start, int end,
			int sKind, int userNo) {
		int wishListTemp;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Category> categoryList = new ArrayList<Category>();
		String sql = prop.getProperty("categoryListNext");
		if (sKind == 2) {
			sql = prop.getProperty("categoryListNextHighPrice");
		} else if (sKind == 3) {
			sql = prop.getProperty("categoryListNextRowPrice");
		} else if (sKind == 4) {
			sql = prop.getProperty("categoryListNextNew");
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mCategory);
			if (sCategory == 0) {
				pstmt.setString(2, "%");
			} else {
				pstmt.setInt(2, sCategory);
			}
			pstmt.setInt(3, end);
			pstmt.setInt(4, start);
			rset = pstmt.executeQuery();
			while (true) {
				if (rset.next()) {
					wishListTemp = new MypageService().checkWish(userNo, rset.getString("PCODE"));
					categoryList.add(new Category(rset.getString("PCODE"), rset.getString("PIMAGE_ORIGIN"),
							rset.getString("PNAME"), rset.getInt("PRICE"), rset.getString("SCORE_AVG"),
							rset.getInt("PSTOCK"), rset.getInt("STORE_NO"), rset.getString("STORE_NAME"),
							rset.getInt("STORE_LEV"),wishListTemp));
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
		return categoryList;
	}

	public String categoryName(Connection conn, int mCategory, int sCategory) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String categoryName = null;
		String sql = prop.getProperty("categoryName");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mCategory);
			pstmt.setInt(2, sCategory);
			
			
			rset = pstmt.executeQuery();
			if (rset.next()) {
				categoryName = rset.getString("categoryName");	
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(rset);
			close(pstmt);
		}
		return categoryName;
	}

}
