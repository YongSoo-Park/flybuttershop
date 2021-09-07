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

	public ArrayList<Basket> selectBasketList(Connection conn) {
		ArrayList<Basket> list = new ArrayList<Basket>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBasketList");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Basket(
								rset.getString("PCODE"),
								rset.getInt("BASKET_NO"),
								rset.getString("BOPTION"),
								rset.getInt("BAMOUNT"),
								rset.getInt("PRICE"),
								rset.getDate("BASKET_DATE"),
								rset.getInt("USER_NO")
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

}
