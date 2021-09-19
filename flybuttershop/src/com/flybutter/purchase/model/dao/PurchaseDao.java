package com.flybutter.purchase.model.dao;
 
import static com.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import com.flybutter.basket.model.dao.BasketDao;
import com.flybutter.basket.model.vo.Basket;
import com.flybutter.consumer.model.vo.Consumer;
import com.flybutter.coupon.model.vo.Coupon;
import com.flybutter.member.model.vo.Member;
import com.flybutter.money.model.vo.Money;
import com.flybutter.purchase.model.vo.Purchase;

public class PurchaseDao {

	private Properties prop = new Properties();
	
	public PurchaseDao() {
		String fileName = BasketDao.class.getResource("/sql/purchase/purchase-query.properties").getPath();
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

	public Member selectMember(Connection conn, int no) {
	
		Member m = new Member();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		System.out.println("멤버셀렉트다오 : " + no);
		
//		selectMember=SELECT MEM_USER_ID, MEM_USER_NAME, MEM_PHONE, MEM_EMAIL, MEM_ADDRESS FROM MEMBER WHERE MEM_USER_NO = ?
		
		String sql = prop.getProperty("selectMember");
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
					
			while(rset.next()) {
				
				m = new Member( rset.getString("MEM_USER_ID"), rset.getString("MEM_USER_NAME"),
						rset.getString("MEM_PHONE"), rset.getString("MEM_EMAIL"), rset.getString("MEM_ADDRESS"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Member 테이블  selectMember 오류메세지 : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}

	public ArrayList<Coupon> selectCoupon(Connection conn, int no) {
		ArrayList<Coupon> list = new ArrayList<Coupon>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCoupon");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
//			selectCoupon=SELECT * FROM COUPON WHERE USER_NO = ? ORDER BY CP_DISCOUNT DESC;
					
//			CP_NO	NUMBER
//			USER_NO	NUMBER
//			ORDER_NO	NUMBER
//			PCODE	VARCHAR2(30 BYTE)
//			CP_COUNT	NUMBER
//			CP_DISCOUNT	NUMBER
//			CP_DATE	DATE
//			CP_NAME	VARCHAR2(50 BYTE)

			while(rset.next()) {
				list.add(new Coupon(
								no,
								rset.getInt("ORDER_NO"),
								rset.getString("PCODE"),
								rset.getInt("CP_NO"),
								rset.getInt("CP_COUNT"),
								rset.getInt("CP_DISCOUNT"),
								rset.getDate("CP_DATE"),
								rset.getString("CP_NAME"),	
								rset.getInt("MINPRICE")		
						));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Coupon 테이블  selectCoupon 오류메세지 : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public Consumer selectMoney(Connection conn, int no) {
		Consumer c = new Consumer();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
//		USER_NO	NUMBER
//		NEW_ADDRESS	VARCHAR2(100 BYTE)
//		REC_PNO	VARCHAR2(100 BYTE)
//		USER_CEL	string
//		MONEY	NUMBER
//		SUM_PRICE	NUMBER
		
		String sql = prop.getProperty("selectMoney");
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
//			selectMoney=SELECT * FROM CONSUMER WHERE USER_NO = ?	
			while(rset.next()) {
				
				c = new Consumer(no,
						rset.getString("NEW_ADDRESS"), rset.getString("REC_PNO"), rset.getString("USER_CEL"),
						rset.getInt("MONEY"), rset.getInt("SUM_PRICE"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Consumer 테이블  selectMoney 오류메세지 : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return c;
	}

	public ArrayList<Purchase> selectSName(Connection conn, int store_No) {
		ArrayList<Purchase> sNameList = new ArrayList<Purchase>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectSName");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, store_No);
			
			rset = pstmt.executeQuery();
			
//			selectSName=SELECT STORE_NAME FROM SELLER WHERE STORE_NO = ?
					
			while(rset.next()) {
				sNameList.add(new Purchase(
								rset.getString("STORE_NAME")				
						));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Seller 테이블  selectSName 오류메세지 : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return sNameList;
	}


}
