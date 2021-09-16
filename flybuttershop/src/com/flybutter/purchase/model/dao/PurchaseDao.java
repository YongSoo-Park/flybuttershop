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
import java.util.Properties;

import com.flybutter.basket.model.dao.BasketDao;
import com.flybutter.basket.model.vo.Basket;
import com.flybutter.member.model.vo.Member;
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
	
	public int insertPurInfo(Connection conn, Purchase p) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMember");
		
//		insertPurInfo=INSERT INTO PURCHASE (USER_NO, PCODE, PUR_NO, PUR_IMAGE, PUR_PNAME, PUR_POPTION, PUR_PRICE, PUR_AMOUNT, PUR_SNAME) VALUES(?,?,PUR_NO_SQ,?,?,?,?,?,?)
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, p.getUser_No());
			pstmt.setString(2, p.getpCode());
			pstmt.setString(3, p.getPur_Image());
			pstmt.setString(4, p.getPur_Pname());
			pstmt.setString(5, p.getPur_POption());
			pstmt.setInt(6, p.getPur_Price());
			pstmt.setInt(7, p.getPur_Amount());
			pstmt.setString(8, p.getPur_SName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Purchase> selectPurInfo(Connection conn, int no, int pNo) {

		ArrayList<Purchase> list = new ArrayList<Purchase>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPurInfo");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			pstmt.setInt(1, no);
			pstmt.setInt(2, pNo);
			
//			selectPurInfo=SELECT USER_NO, PCODE, PUR_NO, PUR_IMAGE, PUR_PNAME, PUR_POPTION, PUR_PRICE, PUR_AMOUNT, PUR_SNAME FROM PURCHASE WHERE USER_NO = ? AND PUR_NO = ?
					
//			while(rset.next()) {
//				list.add(new Purchase(
//								
//								rset.getInt("USER_NO"),
//								rset.getString("PCODE"),
//								rset.getInt("PUR_NO"),
//								rset.getString("PUR_IMAGE"),
//								rset.getString("PUR_PNAME"),
//								rset.getString("PUR_POPTION"),
//								rset.getInt("PUR_PRICE"),
//								rset.getInt("PUR_AMOUNT"),	
//								rset.getString("PUR_SNAME")
//								
//						));
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Basket 테이블  selectBasketList 오류메세지 : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public Member selectMember(Connection conn, int no) {
	
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
//		selectMember=SELECT MEM_USER_NAME, MEM_PHONE, MEM_ADDRESS, MEM_EMAIL FROM MEMBER WHERE MEM_USER_NO = ?
		
		String sql = prop.getProperty("selectMember");
		try {

			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			pstmt.setInt(1, no);
			
					
			while(rset.next()) {
				
				m = new Member(rset.getString("MEM_USER_NAME"),
						rset.getString("MEM_PHONE"), rset.getString("MEM_ADDRESS"), rset.getString("MEM_EMAIL"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Basket 테이블  selectBasketList 오류메세지 : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}

}
