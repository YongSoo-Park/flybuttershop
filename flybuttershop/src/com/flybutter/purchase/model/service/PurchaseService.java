package com.flybutter.purchase.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.flybutter.purchase.model.dao.PurchaseDao;
import com.flybutter.purchase.model.vo.Purchase;

public class PurchaseService {

	public int insertPurInfo(Purchase p) {
		Connection conn = getConnection();
		
		int result = new PurchaseDao().insertPurInfo(conn, p);
		
		if(result > 0) {
			commit(conn);
		}else {	
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public ArrayList<Purchase> selectPurInfo(int no, int pNo) {
		Connection conn = getConnection();
		
		ArrayList<Purchase> list = new PurchaseDao().selectPurInfo(conn, no, pNo); 
		close(conn);
		
		return list;
	}

	

}
