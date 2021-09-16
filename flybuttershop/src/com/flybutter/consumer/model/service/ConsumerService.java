package com.flybutter.consumer.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.flybutter.consumer.model.dao.ConsumerDao;

public class ConsumerService {

	
	public int createConsumer(int userNo) {
		
		Connection conn = getConnection();
		
		int result = new ConsumerDao().createConsumer(conn, userNo);
		
		if(result > 0) {
			commit(conn);
		}else {	
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int updateAdd(int no, String newAddress) {
		Connection conn = getConnection();
		
		int addResult = new ConsumerDao().updateAdd(conn, no, newAddress);
		
		if(addResult > 0) {
			commit(conn);
		}else {	
			rollback(conn);
		}
		
		close(conn);
		return addResult;
	}

}
