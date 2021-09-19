package com.flybutter.faq.model.dao;


import static com.common.JDBCTemplate.*;
import static com.common.JDBCTemplate.close;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import com.flybutter.faq.model.vo.FAQ;
import com.flybutter.faq.model.vo.PageInfo;
import com.flybutter.search.model.vo.Search;


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
	
	public ArrayList<FAQ> deliverySelectList(Connection conn, PageInfo pi) {
		ArrayList<FAQ> list = new ArrayList<FAQ>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("deliverySelectList");

		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
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

	public int insertFAQ(Connection conn, FAQ f) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertFAQ");
		
		try {
			pstmt = conn.prepareStatement(sql);
			//insertFAQ=INSERT INTO FAQ VALUES(FAQ_NO.NEXTVAL, ?, ?, ?)
			pstmt.setInt(1,f.getFaq_Category());
			pstmt.setString(2, f.getFaq_Title());
			pstmt.setString(3, f.getFaq_Content());
			
			result = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
		return result;
	}

	public FAQ selectFAQ(Connection conn, int no) {
		FAQ f = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFAQ");
	//	selectFAQ=SELECT FAQ_NO, FAQ_CATEGORY, FAQ_TITLE, FAQ_CONTENT FROM FAQ WHERE FAQ_NO=?
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				f = new FAQ(
						rset.getInt("FAQ_NO"),
						rset.getInt("FAQ_CATEGORY"),
						rset.getString("FAQ_TITLE"),
						rset.getString("FAQ_CONTENT")						
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		
		}
		
		
		return f;
	}

	public int updateFAQ(Connection conn, FAQ f) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateFAQ");

		//updateFAQ=UPDATE FAQ SET FAQ_CATEGORY=?, FAQ_TITLE=?, FAQ_CONTENT=? WHERE FAQ_NO=?
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, f.getFaq_Category());
			pstmt.setString(2, f.getFaq_Title());
			pstmt.setString(3, f.getFaq_Content());
			pstmt.setInt(4, f.getFaq_No());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
				
		return result;
		
		
	}

	public int deleteFAQ(Connection conn, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteFAQ");
		//deleteFAQ=DELETE FAQ WHERE FAQ_NO=?
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<FAQ> refundSelectList(Connection conn, PageInfo pi) {
		ArrayList<FAQ> list = new ArrayList<FAQ>();
	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("refundSelectList");

		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
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

	public ArrayList<FAQ> orderSelectList(Connection conn, PageInfo pi) {
		ArrayList<FAQ> list = new ArrayList<FAQ>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("orderSelectList");

		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
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

	public ArrayList<FAQ> sellerSelectList(Connection conn, PageInfo pi) {
		ArrayList<FAQ> list = new ArrayList<FAQ>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("sellerSelectList");

		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
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

	public ArrayList<FAQ> memberSelectList(Connection conn, PageInfo pi) {
		ArrayList<FAQ> list = new ArrayList<FAQ>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("memberSelectList");

		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
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

	public int getDeliveryListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getDeliveryListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);//count
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		
		return listCount;
	}

	public int getMemberListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getMemberListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);//count
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		
		return listCount;
	}

	public int getOrderListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getOrderListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);//count
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		
		return listCount;
	}

	public int getRefundListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getRefundListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);//count
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		
		return listCount;
	}

	public int getSellerListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getSellerListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);//count
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		
		return listCount;
	}

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);//count
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		
		return listCount;
	}

	public ArrayList<FAQ> selectFAQList(Connection conn, PageInfo pi) {
		ArrayList<FAQ> list = new ArrayList<FAQ>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFAQList");
//selectFAQList=
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit()-1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
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

	public ArrayList<FAQ> searchList(Connection conn, String sWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		System.out.println("searchList dao 1");
		ArrayList<FAQ> searchList = new ArrayList<FAQ>();
		String sql = prop.getProperty("searchList");
		//searchList=SELECT * FROM(SELECT * FROM FAQ WHERE FAQ_CATEGORY LIKE ? OR FAQ_TITLE LIKE ? OR FAQ_CONTENT LIKE ? ORDER BY FAQ_NO DESC) WHERE ROWNUM < 11
		System.out.println("searchList dao 2 sql : " + sql);
		System.out.println("searchList sWord  : " + sWord);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + sWord + "%");
			pstmt.setString(2, "%" + sWord + "%");
			pstmt.setString(3, "%" + sWord + "%");
			rset = pstmt.executeQuery();
			while (true) {
				if (rset.next()) {
					System.out.println("searchList dao if 안");
					searchList.add(new FAQ(rset.getInt("FAQ_NO"),
							rset.getInt("FAQ_CATEGORY"),
							rset.getString("FAQ_TITLE"),
							rset.getString("FAQ_CONTENT")		
							));
					continue;
				} else {
					System.out.println("searchList dao in else");
					break;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(rset);
			close(pstmt);
		}
		return searchList;
	}

	public int searchListCount(Connection conn, String sWord) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchListCount");
		//searchListCount=SELECT COUNT(*) TOTAL FROM FAQ WHERE FAQ_CATEGORY LIKE ? OR FAQ_TITLE LIKE ? OR FAQ_CONTENT LIKE ?
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + sWord + "%");
			rset = pstmt.executeQuery();

			if (rset.next()) {
				count = rset.getInt("TOTAL");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(rset);
			close(pstmt);
		}
		return count;
	}

	public ArrayList<FAQ> searchListNext(Connection conn, String sWord, int start, int end) {
		
		System.out.println("faq @@@@@@@@ 1");
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FAQ> searchList = new ArrayList<FAQ>();
		String sql = prop.getProperty("searchListNext");
		//searchListNext=SELECT * FROM ( SELECT FIRST.*, ROWNUM RNUM FROM (SELECT * FROM FAQ WHERE FAQ_CATEGORY LIKE ? OR FAQ_TITLE LIKE ? OR FAQ_CONTENT LIKE ? ORDER BY FAQ_NO DESC) FIRST WHERE ROWNUM <= ?) SECOND WHERE RNUM >= ?
		System.out.println("faq @@@@@@@@ 2");
		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "%" + sWord + "%");
			pstmt.setInt(1, end);
			pstmt.setInt(2, start);
			rset = pstmt.executeQuery();
			System.out.println("faq @@@@@@@@ 3");
			while (true) {
				if (rset.next()) {
					FAQ faq = new FAQ(rset.getInt("FAQ_NO"),
							rset.getInt("FAQ_CATEGORY"),
							rset.getString("FAQ_TITLE"),
							rset.getString("FAQ_CONTENT")	
							);
					System.out.println(faq.toString());
					searchList.add(faq);
					continue;
				} else {
					System.out.println("faq @@@@@@@@ 4");
					break;
				}
			}
			
			System.out.println("faq @@@@@@@@ 5");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(rset);
			close(pstmt);
		}
		return searchList;
	}

	
}
