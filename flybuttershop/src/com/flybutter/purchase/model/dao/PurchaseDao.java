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

	public ArrayList<Coupon> selectCoupon(Connection conn, int no, int use) {
		ArrayList<Coupon> list = new ArrayList<Coupon>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCoupon");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setInt(2, use);
			
			rset = pstmt.executeQuery();
			
//			selectCoupon=SELECT * FROM COUPON WHERE USER_NO = ? AND CP_COUNT = ? ORDER BY CP_DISCOUNT DESC
					
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

	public int updateCoupon(Connection conn, int no, String cName, int use) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateCoupon");
		
//		updateCoupon=UPDATE COUPON SET CP_COUNT = ? WHERE USER_NO = ? AND CP_NAME = ?
		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, use);
			pstmt.setInt(2, no);
			pstmt.setString(3, cName);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("COUPON 테이블  updateCoupon : " + e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertBankPur(Connection conn, Purchase bankPur, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertBankPur");
		
//		insertBankPur=INSERT INTO PURCHASE (USER_NO, PUR_NO, PUR_DATE, PUR_PRICE, PUR_ADDRESS, PUR_TYPE, PUR_BANK, PUR_ACCOUNT, CP_USE, MONEY_USE, PUR_INFO) VALUES(?,PUR_NO_SQ.NEXTVAL,SYSDATE,?,?,?,?,?,?,?,?)
		
//		USER_NO	NUMBER
//		PUR_PRICE	NUMBER
//		PUR_ADDRESS	VARCHAR2(100 BYTE)
//		PUR_TYPE	NUMBER
//		PUR_BANK	VARCHAR2(50 BYTE)
//		PUR_ACCOUNT	VARCHAR2(50 BYTE)
//		CP_USE	VARCHAR2(20 BYTE)
//		MONEY_USE	VARCHAR2(20 BYTE)
//		PUR_INFO	VARCHAR2(1000 BYTE)
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			pstmt.setInt(2, bankPur.getPur_Price());
			pstmt.setString(3, bankPur.getPur_Address());
			pstmt.setInt(4, bankPur.getPur_Type());
			pstmt.setString(5, bankPur.getPur_Bank());
			pstmt.setString(6, bankPur.getPur_Account());
			pstmt.setString(7, bankPur.getCp_Use());
			pstmt.setString(8, bankPur.getMoney_Use());
			pstmt.setString(9, bankPur.getPur_Info());
		
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertCardPur(Connection conn, Purchase cardPur, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertCardPur");
		
//		insertCardPur=INSERT INTO PURCHASE (USER_NO, PUR_NO, PUR_DATE, PUR_PRICE, PUR_ADDRESS, PUR_TYPE, CARD_NO, CARD_AGENCY, CARD_DATE, CP_USE, MONEY_USE, PUR_INFO) VALUES(?,PUR_NO_SQ.NEXTVAL,SYSDATE,?,?,?,?,?,?,?,?,?)
		
//		USER_NO	NUMBER
//		PUR_PRICE	NUMBER
//		PUR_ADDRESS	VARCHAR2(100 BYTE)
//		PUR_TYPE	NUMBER
//		CARD_NO	VARCHAR2(20 BYTE)
//		CARD_AGENCY	VARCHAR2(50 BYTE)
//		CARD_DATE	VARCHAR2(10 BYTE)
//		CP_USE	VARCHAR2(20 BYTE)
//		MONEY_USE	VARCHAR2(20 BYTE)
//		PUR_INFO	VARCHAR2(1000 BYTE)
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			pstmt.setInt(2, cardPur.getPur_Price());
			pstmt.setString(3, cardPur.getPur_Address());
			pstmt.setInt(4, cardPur.getPur_Type());
			pstmt.setString(5, cardPur.getCard_No());
			pstmt.setString(6, cardPur.getCard_Agency());
			pstmt.setString(7, cardPur.getCard_Date());
			pstmt.setString(8, cardPur.getCp_Use());
			pstmt.setString(9, cardPur.getMoney_Use());
			pstmt.setString(10, cardPur.getPur_Info());
		
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Purchase selectPurNo (Connection conn, int no) {
		Purchase purNo = new Purchase();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPurNo");
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
//			selectPurNo=SELECT MAX(PUR_NO) AS MAX_NUM FROM PURCHASE WHERE USER_NO = ?
			while(rset.next()) {
				purNo = new Purchase(rset.getInt("MAX_NUM"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Purchase 테이블  selectPurNo 오류메세지 : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return purNo;
	}

	public int updateCMoney(Connection conn, int no, int resultMoney) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateCMoney");
		
//		updateCMoney=UPDATE CONSUMER SET MONEY =? WHERE USER_NO =?
		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, resultMoney);
			pstmt.setInt(2, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("CONSUMER 테이블  updateCMoney : " + e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}
	
}
