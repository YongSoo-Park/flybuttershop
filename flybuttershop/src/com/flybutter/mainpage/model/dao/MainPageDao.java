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
import com.flybutter.mainpage.model.vo.Mainpage;
import com.flybutter.product.model.vo.Product;

public class MainPageDao {

	private Properties prop = new Properties();

	public MainPageDao() {

		String fileName = MainPageDao.class.getResource("/sql/mainpage/main-query.properties").getPath();
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
		HashMap<String, Product> list = new HashMap<String, Product>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		temp = rec_PNO.split("/");

		String sql = prop.getProperty("itemsListSelect");
		try {
			for (int i = 0; i < temp.length; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, temp[i]);

				rset = pstmt.executeQuery();

				if (rset.next()) {
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

	public ArrayList<Mainpage> saleList(Connection conn) {
		String temp = tempList(conn);
		String[] arrTemp = temp.split("/");
		ArrayList<Mainpage> saleList = new ArrayList<Mainpage>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("itemsListSelect");
		try {
			for (int i = 0; i < arrTemp.length; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, arrTemp[i]);

				rset = pstmt.executeQuery();

				if (rset.next()) {
					saleList.add(
							new Mainpage(30, arrTemp[i], rset.getString("PNAME"), rset.getString("PIMAGE_ORIGIN")));
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(rset);
			close(pstmt);
		}
		return saleList;
	}

	private String tempList(Connection conn) {
		String temp = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("tempList");
		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				temp = rset.getString("PCODE");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(rset);
			close(pstmt);
		}
		return temp;
	}

	public ArrayList<ArrayList<Mainpage>> saleTotalList(Connection conn) {
		ArrayList<ArrayList<Mainpage>> saleTotalList = new ArrayList<ArrayList<Mainpage>>();
		ArrayList<Mainpage> total = new ArrayList<Mainpage>();
		ArrayList<Mainpage> temp = new ArrayList<Mainpage>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("saleList");
		try {
			for (int i = 1; i < 9; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, i);
				rset = pstmt.executeQuery();
				temp = new ArrayList<Mainpage>();
				while (true) {
					if (rset.next()) {
						temp.add(new Mainpage(rset.getString("PCODE"), rset.getString("PIMAGE_ORIGIN"),
								rset.getString("PNAME"), rset.getInt("PRICE")));
						continue;
					} else {
						break;
					}
				}
				if (i < 5) {
					if (temp.size() >= 2) {
						total.add(temp.get(0));
						total.add(temp.get(1));
					} else if (temp.size() == 1) {
						total.add(temp.get(0));
					}
				} else {
					if (temp.size() >= 1) {
						total.add(temp.get(0));
					}
				}
				saleTotalList.add(temp);
			}
			saleTotalList.add(0, total);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(rset);
			close(pstmt);
		}

		return saleTotalList;
	}

	public ArrayList<Mainpage> newList(Connection conn) {
		ArrayList<Mainpage> newList = new ArrayList<Mainpage>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("newList");
		try {
			for (int i = 1; i < 9; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, i);
				rset = pstmt.executeQuery();

				if (rset.next()) {
					newList.add(new Mainpage(rset.getString("PCODE"), rset.getString("PIMAGE_ORIGIN"),
							rset.getString("PNAME"), rset.getInt("PRICE")));
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(rset);
			close(pstmt);
		}
		return newList;
	}

	public ArrayList<Mainpage> bestList(Connection conn) {
		ArrayList<Mainpage> bestList = new ArrayList<Mainpage>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("bestList");
		try {
			for (int i = 1; i < 9; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, i);
				rset = pstmt.executeQuery();
				while (true) {
					if (rset.next()) {
						bestList.add(new Mainpage(rset.getString("PCODE"), rset.getString("PIMAGE_ORIGIN"),
								rset.getString("PNAME"), rset.getInt("PRICE")));

						continue;
					} else {
						break;
					}
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(rset);
			close(pstmt);
		}
		return bestList;
	}

}
