package com.flybutter.consumer.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.flybutter.consumer.model.dao.ConsumerDao;
import com.flybutter.consumer.model.vo.Consumer;

public class ConsumerService {

	
	public int createConsumer(int userNo) {
		
		Connection conn = getConnection();
		
		int result = new ConsumerDao().createConsumer(conn, userNo);
		close(conn);
		return result;
	}

}
