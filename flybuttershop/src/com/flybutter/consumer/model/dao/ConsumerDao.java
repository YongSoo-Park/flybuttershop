package com.flybutter.consumer.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConsumerDao {
	
	private Properties prop = new Properties();

	public ConsumerDao() {
		String fileName = ConsumerDao.class.getResource("/sql/consumer/consumer-query.properties").getPath();
		System.out.println("fileName   " + fileName);
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int createConsumer(Connection conn, int user_No) {
			
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("createconsumer");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, user_No);
					
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}	
			
		return result;
	}

}
