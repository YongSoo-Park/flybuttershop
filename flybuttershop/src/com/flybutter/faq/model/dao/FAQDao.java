package com.flybutter.faq.model.dao;

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
import com.flybutter.faq.model.vo.FAQ;



public class FAQDao {
	private Properties prop = new Properties();
	public FAQDao() {
		String fileName = FAQDao.class.getResource("/sql/faq/faq-query.properties").getPath();
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
	
	public ArrayList<FAQ> deliverySelectList(Connection conn) {
		ArrayList<FAQ> list = new ArrayList<FAQ>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("deliverySelectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new FAQ(rset.getInt("FAQ_NO"),
									rset.getInt("FAQ_CATEGORY"),
									rset.getString("FAQ_TITLE")));
			}
			System.out.println("dao list : " + list);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt); 
		
		}
	
		return list;
	}

}
