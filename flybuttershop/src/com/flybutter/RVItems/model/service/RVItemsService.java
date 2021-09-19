package com.flybutter.RVItems.model.service;

import java.sql.Connection;

import com.flybutter.RVItems.model.dao.RVItemsDao;

import static com.common.JDBCTemplate.*;

public class RVItemsService {

	public int updateRVItems(String newRecPno, int userNo) {
		Connection conn = getConnection();
		int result;
		result = new RVItemsDao().updateRVItems(conn, newRecPno, userNo);
		if(result > 0) {
			
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

}
