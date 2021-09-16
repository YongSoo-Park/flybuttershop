package com.flybutter.mainpage.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.flybutter.mainpage.model.dao.MainPageDao;
import com.flybutter.mainpage.model.vo.Mainpage;
import com.flybutter.product.model.vo.Product;

public class MainPageService {

	public HashMap<String,Product> RVItemsList(String rec_PNO) {
		Connection conn = getConnection();
		HashMap<String,Product> RVItemsList = new MainPageDao().RVItemsList(conn, rec_PNO);
		close(conn);
		return RVItemsList;
	}

	public ArrayList<Mainpage> saleList() {
		Connection conn = getConnection();
		ArrayList<Mainpage> saleList= new MainPageDao().saleList(conn);
		close(conn);
		return saleList;
	}
	
	public ArrayList<ArrayList<Mainpage>> saleTotalList() {
		Connection conn = getConnection();
		ArrayList<ArrayList<Mainpage>> saleTotalList= new MainPageDao().saleTotalList(conn);
		close(conn);
		return saleTotalList;
	}
	
	public ArrayList<Mainpage> newList() {
		Connection conn = getConnection();
		ArrayList<Mainpage> newList= new MainPageDao().newList(conn);
		close(conn);
		return newList;
	}

	public ArrayList<Mainpage> bestList() {
		Connection conn = getConnection();
		ArrayList<Mainpage> bestList= new MainPageDao().bestList(conn);
		close(conn);
		return bestList;
	}
}
