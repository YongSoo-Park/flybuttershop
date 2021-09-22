package com.flybutter.search.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import static com.common.JDBCTemplate.*;

import com.flybutter.search.model.dao.SearchDao;
import com.flybutter.search.model.vo.Search;

public class SearchService {

	public ArrayList<Search> searchList(String sWord, int userNo) {
		Connection conn = getConnection();
		ArrayList<Search> searchList = new ArrayList<Search>();
		searchList = new SearchDao().searchList(conn, sWord, userNo);
		close(conn);
		return searchList;
	}
	public ArrayList<Search> searchSaleList(String sWord) {
		Connection conn = getConnection();
		ArrayList<Search> searchSaleList = new ArrayList<Search>();
		searchSaleList = new SearchDao().searchSaleList(conn, sWord);
		close(conn);
		return searchSaleList;
	}
	public int searchListCount(String sWord) {
		Connection conn = getConnection();
		int count = new SearchDao().searchListCount(conn, sWord);
		close(conn); 
		return count;
	}
	
	public ArrayList<Search> searchListNext(String sWord,int start, int end, int sKind, int userNo) {
		Connection conn = getConnection();
		ArrayList<Search> searchList = new ArrayList<Search>();
		searchList = new SearchDao().searchListNext(conn, sWord, start, end,sKind,userNo);
		close(conn);
		return searchList;
	}
}
