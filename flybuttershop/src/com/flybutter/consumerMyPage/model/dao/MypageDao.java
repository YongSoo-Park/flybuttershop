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
import com.flybutter.dummy.model.vo.Member;
import com.flybutter.purchase.model.vo.Purchase;
import com.flybutter.review.model.vo.PageInfo;
import com.flybutter.review.model.vo.Review;

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





	public int updateMember(Connection conn, Member m) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("updateMember");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,m.getMEM_USER_PWD());
			pstmt.setString(2, m.getMEM_PHONE());
			pstmt.setString(3, m.getMEM_EMAIL());
			pstmt.setString(4, m.getMEM_ADDRESS());
			pstmt.setInt(5, m.getMEM_USER_NO());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("MEMBER 테이블  updateMember : " + e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;

	
	}





	public int orderListCount(Connection conn, int userNo) {
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("orderListCount");

		try {
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				count = rset.getInt("COUNT(*)");
						
			}

			
		} catch (SQLException e) {
			System.out.println("PURCHASE 테이블  orderListCount : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return count;

	}





	public ArrayList<Purchase> selectOrderList(Connection conn, PageInfo pi, int userNo) {
		ArrayList<Purchase> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("orderList");
		
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Purchase(rset.getInt("PUR_NO"),
									rset.getDate("PUR_DATE"),
									rset.getString("PIMAGE_ORIGIN"),
									rset.getString("PNAME"),
									rset.getInt("PUR_AMOUNT"),
									rset.getInt("PUR_STATE")
									
						));
			}
		} catch (SQLException e) {
			System.out.println("PURCHASE 테이블  orderList : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return list;
	}

}
