package com.flybutter.consumer.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.flybutter.consumer.model.dao.ConsumerDao;
import com.flybutter.consumer.model.vo.Consumer;

public class ConsumerService {

	
	public int createConsumer(int user_No) {
		
		Connection conn = getConnection();
		
		int result = new ConsumerDao().createConsumer(conn, user_No);
		close(conn);
		return result;
	}

}
