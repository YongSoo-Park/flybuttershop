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

import com.flybutter.consumer.model.vo.Consumer;

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
		String sql = prop.getProperty("insertconsumer");
		
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

	public int updateAdd(Connection conn, int no, String newAddress) {
		int addResult = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateAddress");
		
//		updateAddress=UPDATE CONSUMER SET NEW_ADDRESS = ? WHERE USER_NO = ?
		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,newAddress);
			pstmt.setInt(2,no);
			
			addResult = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("CONSUMER 테이블  updateAddress : " + e.getMessage());
		}finally {
			close(pstmt);
		}
		return addResult;

	}


}
