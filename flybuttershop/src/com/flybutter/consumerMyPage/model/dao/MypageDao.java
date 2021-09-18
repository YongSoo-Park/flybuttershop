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
import com.flybutter.consumerMyPage.model.vo.OrderList;
import com.flybutter.dummy.model.vo.Member;
import com.flybutter.purchase.model.vo.Purchase;
import com.flybutter.review.model.vo.PageInfo;

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





	public ArrayList<OrderList> selectOrderList(Connection conn, PageInfo pi, int userNo) {
		ArrayList<OrderList> list = new ArrayList<>();
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
				list.add(new OrderList(rset.getInt("PUR_NO"),
									rset.getString("PUR_INFO"),
									rset.getDate("PUR_DATE")
									
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





	public String getpImage(Connection conn, String pNo) {
		String pImage = "";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getpImage");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				pImage = rset.getString("PIMAGE_ORIGIN");
			
						
			}

			
		} catch (SQLException e) {
			System.out.println("PRODUCT 테이블  getpImage : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return pImage;
	}





	public String getpName(Connection conn, String pNo) {
		String pName = "";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getpName");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				pName = rset.getString("PNAME");
			
						
			}

			
		} catch (SQLException e) {
			System.out.println("PRODUCT 테이블  getpImage : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return pName;
	}





	public OrderList selectOrderDetail(Connection conn, int purNo) {
		OrderList list = new OrderList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOrderDetail");
		

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, purNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.setPurNo(purNo);				
				list.setPurDate(rset.getDate("PUR_DATE"));
				list.setOrderInfo(rset.getString("PUR_INFO"));
			}
		} catch (SQLException e) {
			System.out.println("PURCHASE 테이블  selectOrderDetail : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return list;
	}

}
