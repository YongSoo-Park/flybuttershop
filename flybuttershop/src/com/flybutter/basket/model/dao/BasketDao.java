package com.flybutter.basket.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.common.JDBCTemplate.*;
import com.flybutter.basket.model.vo.Basket;
import com.flybutter.product.model.vo.Product;
 
public class BasketDao {

	private Properties prop = new Properties();
	
	public BasketDao() {
		String fileName = BasketDao.class.getResource("/sql/basket/basket-query.properties").getPath();
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

	public ArrayList<Basket> selectBasketList(Connection conn, int no) {
		
//		selectBasketList=SELECT * FROM BASKET WHERE USER_NO = ?
		ArrayList<Basket> list = new ArrayList<Basket>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBasketList");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
//			PCODE
//			BASKET_NO
//			BOPTION
//			BAMOUNT
//			PRICE
//			BASKET_DATE
//			USER_NO
//			BASKET_PIMAGE
//			BASKET_PNAME
//			BASKET_SNAME
			
			while(rset.next()) {
				list.add(new Basket(
								rset.getString("PCODE"),
								rset.getInt("BASKET_NO"),
								rset.getString("BOPTION"),
								rset.getInt("BAMOUNT"),
								rset.getInt("PRICE"),
								rset.getDate("BASKET_DATE"),
								rset.getInt("USER_NO"),	
								rset.getString("BASKET_PIMAGE"),
								rset.getString("BASKET_PNAME"),
								rset.getString("BASKET_SNAME")
						));
			}
			
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

	public int insertBasket(Connection conn, Basket b) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertBasket");
		
//		insertBasket=INSERT INTO BASKET VALUES(?,BASKET_NO_SQ,?,?,?,DEFAULT,?,?,?,?)
		
//		BASKET_NO
//		BOPTION
//		BAMOUNT
//		PRICE
//		BASKET_DATE
//		USER_NO
//		BASKET_PIMAGE
//		BASKET_PNAME
//		BASKET_SNAME
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getpCode());
			pstmt.setString(2, b.getbOption());
			pstmt.setInt(3, b.getbAmount());
			pstmt.setInt(4, b.getPrice());
			pstmt.setInt(5, b.getUser_No());
			pstmt.setString(6, b.getBasket_PImg());
			pstmt.setString(7, b.getBasket_Pname());
			pstmt.setString(8, b.getBasket_Sname());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteBasket(Connection conn, String ck) {
		System.out.println("deleteBasketDao");
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteBasket");
//		deleteBasket=DELETE FROM BASKET WHERE PCODE = ?
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, ck);
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Basket 테이블  deleteBasket 오류메세지 : " + e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Basket> selectCheck(Connection conn, int no, String pCode) {
		ArrayList<Basket> list = new ArrayList<Basket>();
		
//		selectCheck=SELECT * FROM BASKET WHERE PCODE = ?
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCheck");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, pCode);
			
			rset = pstmt.executeQuery();
			
//			PCODE
//			BASKET_NO
//			BOPTION
//			BAMOUNT
//			PRICE
//			BASKET_DATE
//			USER_NO
//			BASKET_PIMAGE
//			BASKET_PNAME
//			BASKET_SNAME
			
			while(rset.next()) {
				list.add(new Basket(
								rset.getString("PCODE"),
								rset.getInt("BASKET_NO"),
								rset.getString("BOPTION"),
								rset.getInt("BAMOUNT"),
								rset.getInt("PRICE"),
								rset.getDate("BASKET_DATE"),
								rset.getInt("USER_NO"),	
								rset.getString("BASKET_PIMAGE"),
								rset.getString("BASKET_PNAME"),
								rset.getString("BASKET_SNAME")
						));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Basket 테이블  selectCheck 오류메세지 : " + e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int updateAmount(Connection conn, int plusAmount, String pCode) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateAmount");
		
//		updateAmount=UPDATE BASKET SET BAMOUNT = ? WHERE PCODE = ?
		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,plusAmount);
			pstmt.setString(2,pCode);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("BASKET 테이블  updateAmount : " + e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;

	}

	public Basket selectInBasket(Connection conn, String pCode, int no) {
		Basket b = new Basket();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
//		selectInBasket=SELECT * FROM BASKET WHERE USER_NO = ? AND PCODE = ?
		String sql = prop.getProperty("selectInBasket");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, pCode);
			
//			PCODE	VARCHAR2(50 BYTE)
//			BASKET_NO	NUMBER
//			BOPTION	VARCHAR2(100 BYTE)
//			BAMOUNT	NUMBER
//			PRICE	NUMBER
//			BASKET_DATE	DATE
//			USER_NO	NUMBER
//			BASKET_PIMAGE	VARCHAR2(1000 BYTE)
//			BASKET_PNAME	VARCHAR2(1000 BYTE)
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Basket(rset.getString("PCODE"),
								rset.getInt("BASKET_NO"),
								rset.getString("BOPTION"),
								rset.getInt("BAMOUNT"),
								rset.getInt("PRICE"),
								rset.getDate("BASKET_DATE"),
								rset.getInt("USER_NO"),
								rset.getString("BASKET_PIMAGE"),
								rset.getString("BASKET_PNAME"),
								rset.getString("BASKET_SNAME")
								);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
	}

	public int updatePrice(Connection conn, int newPrice, String pCode) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updatePrice");
		
//		updatePrice=UPDATE BASKET SET PRICE = ? WHERE PCODE = ?
		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,newPrice);
			pstmt.setString(2,pCode);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("BASKET 테이블  updatePrice : " + e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}

}
