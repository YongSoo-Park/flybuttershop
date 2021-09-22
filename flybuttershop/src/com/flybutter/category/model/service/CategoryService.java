package com.flybutter.category.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.flybutter.category.model.dao.CategoryDao;
import com.flybutter.category.model.vo.Category;

public class CategoryService {

	public ArrayList<Category> categoryList(int mCategory, int sCategory, int userNo) {
		Connection conn = getConnection();
		ArrayList<Category> categoryList = new ArrayList<Category>();
		categoryList = new CategoryDao().categoryList(conn, mCategory, sCategory,userNo);
		close(conn);
		return categoryList;
	}
	public ArrayList<Category> categorySaleList(int mCategory, int sCategory) {
		Connection conn = getConnection();
		ArrayList<Category> categoryList = new ArrayList<Category>();
		categoryList = new CategoryDao().categorySaleList(conn, mCategory, sCategory);
		close(conn);
		return categoryList;
	}
	public int categoryListCount(int mCategory, int sCategory) {
		Connection conn = getConnection();
		int count = new CategoryDao().categoryListCount(conn, mCategory, sCategory);
		close(conn); 
		return count;
	}
	
	public ArrayList<Category> categoryListNext(int mCategory, int sCategory,int start, int end, int sKind, int userNo) {
		Connection conn = getConnection();
		ArrayList<Category> categoryList = new ArrayList<Category>();
		categoryList = new CategoryDao().categoryListNext(conn, mCategory, sCategory, start, end,sKind,userNo);
		close(conn);
		return categoryList;
	}
	
	public String categoryName(int mCategory, int sCategory) {
		Connection conn = getConnection();
		String categoryName;
		
		
		categoryName = new CategoryDao().categoryName(conn, mCategory, sCategory);
		close(conn);
		return categoryName;
		

	}
}
