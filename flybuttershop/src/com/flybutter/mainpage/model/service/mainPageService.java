package com.flybutter.mainpage.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.HashMap;

import com.flybutter.mainpage.model.dao.mainPageDao;
import com.flybutter.product.model.vo.Product;

public class mainPageService {

	public HashMap<String,Product> RVItemsList(String rec_PNO) {
		Connection conn = getConnection();
		HashMap<String,Product> RVItemsList = new mainPageDao().RVItemsList(conn, rec_PNO);
		close(conn);
		return RVItemsList;
	}

}
