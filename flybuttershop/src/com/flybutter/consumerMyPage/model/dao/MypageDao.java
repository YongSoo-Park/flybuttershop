package com.flybutter.consumerMyPage.model.dao;


import static com.common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.flybutter.basket.model.dao.BasketDao;
import com.flybutter.basket.model.vo.Basket;
import com.flybutter.dummy.model.vo.Member;

public class MypageDao {
	
	
	
	private Properties prop = new Properties();
	
	public MypageDao() {
		String fileName = BasketDao.class.getResource("/sql/consumerMypage/mypage-query.properties").getPath();
		System.out.println("fileName : " + fileName);
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
	
	
	
	

	public int selectSumPrice(Connection conn, int userNo) {
		
		int sumPrice = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectSumPrice");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				sumPrice = rset.getInt("SUM_PRICE");
			
						
			}

			
		} catch (SQLException e) {
			System.out.println("CONSUMER 테이블  selectSumPrice : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return sumPrice;

	}





	public Member selectMember(Connection conn, int userNo) {
		
	Member m =  new Member();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			System.out.println(pstmt);
			System.out.println(userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				m.setMEM_USER_ID(rset.getString("MEM_USER_ID"));
				m.setMEM_USER_PWD(rset.getString("MEM_USER_PWD"));
				m.setMEM_USER_NAME(rset.getString("MEM_USER_NAME"));
				m.setMEM_PHONE(rset.getString("MEM_PHONE"));
				m.setMEM_EMAIL(rset.getString("MEM_EMAIL"));
				m.setMEM_ADDRESS(rset.getString("MEM_ADDRESS"));
				System.out.println(m);		
			}

			
		} catch (SQLException e) {
			System.out.println("MEMBER 테이블  selectMember : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return m;

	}

}
