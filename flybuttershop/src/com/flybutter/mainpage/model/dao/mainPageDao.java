package com.flybutter.mainpage.model.dao;
import static com.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.flybutter.dummy.model.vo.Member;
import com.flybutter.product.model.vo.Product;


public class mainPageDao {

	private Properties prop = new Properties();
	public mainPageDao() {
		
		
		String fileName = mainPageDao.class.getResource("/sql/mainpage/main-query.properties").getPath();
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
	public HashMap<String, Product> RVItemsList(Connection conn, String rec_PNO) {
		String[] temp = null;
		HashMap<String,Product> list = new HashMap<String, Product>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		temp = rec_PNO.split("/");

		System.out.println(temp.length);
		String sql = prop.getProperty("RVItemsSelect");
		try {
			for(int i = 0 ; i < temp.length ; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, temp[i]);
	
				rset = pstmt.executeQuery();
	
				if(rset.next()) {
					list.put(temp[i], new Product(rset.getString("PNAME"), rset.getString("PIMAGE_ORIGIN")));
				}
			
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(rset);
			close(pstmt);
		}

		return list;
	}

	
	
	
}
