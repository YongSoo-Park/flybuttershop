package com.flybutter.admin.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import com.flybutter.admin.model.vo.Admin;

public class AdminDao {

	private Properties prop = new Properties();

	public AdminDao() {

		String fileName = AdminDao.class.getResource("/sql/admin/admin-query.properties").getPath();
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

	public ArrayList<Admin> memberList(Connection conn) {

		ArrayList<Admin> memberList = new ArrayList<Admin>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("memberList");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				memberList.add(new Admin(rset.getInt("MEM_LEV"), rset.getString("MEM_USER_ID"),
						rset.getString("MEM_USER_NAME"), rset.getString("MEM_EMAIL"), rset.getString("USER_CEL"),
						rset.getInt("MEM_USER_NO"), rset.getInt("MEM_CATEGORY")));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return memberList;
	}

	public ArrayList<Admin> sellerList(Connection conn) {

		ArrayList<Admin> sellerList = new ArrayList<Admin>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("sellerList");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				sellerList.add(new Admin(rset.getInt("STORE_LEV"), rset.getString("SELLER_NO"),
						rset.getString("STORE_NAME"), rset.getString("CEO"), rset.getString("EMAIL"),
						rset.getInt("TOTALSALES"), rset.getInt("USER_NO"), rset.getInt("STORE_NO")));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return sellerList;

	}

	public int memberListCount(Connection conn) {
		int memberListCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("memberListCount");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				memberListCount = rset.getInt("COUNT");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return memberListCount;
	}

	public int sellerListCount(Connection conn) {
		int sellerListCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("sellerListCount");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				sellerListCount = rset.getInt("COUNT");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return sellerListCount;
	}

	public int memberListNextCount(Connection conn, String sWord, int sKind) {
		int memberListCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("memberListSearchCount");

		try {

			pstmt = conn.prepareStatement(sql);
			if (sKind == 1) {
				pstmt.setString(1, "%" + sWord + "%");
				pstmt.setString(2, "%%");
			} else if (sKind == 2) {
				pstmt.setString(1, "%%");
				pstmt.setString(2, "%" + sWord + "%");
			} else {
				pstmt.setString(1, "%%");
				pstmt.setString(2, "%%");
			}

			rset = pstmt.executeQuery();

			if (rset.next()) {
				memberListCount = rset.getInt("COUNT");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return memberListCount;
	}

	public ArrayList<Admin> memberListNext(Connection conn, String sWord, int sKind, int start, int end) {
		ArrayList<Admin> memberListNext = new ArrayList<Admin>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("memberListNext");

		try {
			pstmt = conn.prepareStatement(sql);
			if (sKind == 1) {
				pstmt.setString(1, "%" + sWord + "%");
				pstmt.setString(2, "%%");
				pstmt.setInt(3, end);
				pstmt.setInt(4, start);
			} else if (sKind == 2) {
				pstmt.setString(1, "%%");
				pstmt.setString(2, "%" + sWord + "%");
				pstmt.setInt(3, end);
				pstmt.setInt(4, start);
			} else {
				pstmt.setString(1, "%%");
				pstmt.setString(2, "%%");
				pstmt.setInt(3, end);
				pstmt.setInt(4, start);
			}

			rset = pstmt.executeQuery();

			while (rset.next()) {
				memberListNext.add(new Admin(rset.getInt("MEM_LEV"), rset.getString("MEM_USER_ID"),
						rset.getString("MEM_USER_NAME"), rset.getString("MEM_EMAIL"), rset.getString("USER_CEL"),
						rset.getInt("MEM_USER_NO"), rset.getInt("MEM_CATEGORY")));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return memberListNext;
	}

	public int sellerListNextCount(Connection conn, String sWord, int sKind) {
		int sellerListCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("sellerListSearchCount");

		try {

			pstmt = conn.prepareStatement(sql);
			if (sKind == 1) {
				pstmt.setString(1, "%" + sWord + "%");
				pstmt.setString(2, "%%");
			} else if (sKind == 2) {
				pstmt.setString(1, "%%");
				pstmt.setString(2, "%" + sWord + "%");
			} else {
				pstmt.setString(1, "%%");
				pstmt.setString(2, "%%");
			}

			rset = pstmt.executeQuery();

			if (rset.next()) {
				sellerListCount = rset.getInt("COUNT");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return sellerListCount;
	}

	public ArrayList<Admin> sellerNextList(Connection conn, String sWord, int sKind, int start, int end) {
		ArrayList<Admin> sellerNextList = new ArrayList<Admin>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("sellerListNext");

		try {
			pstmt = conn.prepareStatement(sql);
			if (sKind == 1) {
				pstmt.setString(1, "%" + sWord + "%");
				pstmt.setString(2, "%%");
				pstmt.setInt(3, end);
				pstmt.setInt(4, start);
			} else if (sKind == 2) {
				pstmt.setString(1, "%%");
				pstmt.setString(2, "%" + sWord + "%");
				pstmt.setInt(3, end);
				pstmt.setInt(4, start);
			} else {
				pstmt.setString(1, "%%");
				pstmt.setString(2, "%%");
				pstmt.setInt(3, end);
				pstmt.setInt(4, start);
			}
			rset = pstmt.executeQuery();

			while (rset.next()) {
				sellerNextList.add(new Admin(rset.getInt("STORE_LEV"), rset.getString("SELLER_NO"),
						rset.getString("STORE_NAME"), rset.getString("CEO"), rset.getString("EMAIL"),
						rset.getInt("TOTALSALES"), rset.getInt("USER_NO"), rset.getInt("STORE_NO")));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return sellerNextList;
	}

	public int sellerFListCount(Connection conn) {
		int sellerFListCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("sellerFListCount");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				sellerFListCount = rset.getInt("COUNT");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return sellerFListCount;
	}

	public ArrayList<Admin> sellerFList(Connection conn) {
		ArrayList<Admin> sellerFList = new ArrayList<Admin>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("sellerFList");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				sellerFList.add(new Admin(rset.getString("SELLER_NO"), rset.getString("STORE_NAME"),
						rset.getString("STORE_EXP"), rset.getString("CEO"), rset.getString("EMAIL"),
						rset.getInt("STORE_NO"), rset.getInt("MEM_USER_NO")));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return sellerFList;
	}

	public int sellerFListNextCount(Connection conn, int sKind, String sWord) {
		int sellerFListNextCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("sellerFListSearchCount");

		try {

			pstmt = conn.prepareStatement(sql);
			if (sKind == 1) {
				pstmt.setString(1, "%" + sWord + "%");
				pstmt.setString(2, "%%");
			} else if (sKind == 2) {
				pstmt.setString(1, "%%");
				pstmt.setString(2, "%" + sWord + "%");
			} else {
				pstmt.setString(1, "%%");
				pstmt.setString(2, "%%");
			}

			rset = pstmt.executeQuery();

			if (rset.next()) {
				sellerFListNextCount = rset.getInt("COUNT");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return sellerFListNextCount;
	}

	public ArrayList<Admin> sellerFListNext(Connection conn, int sKind, String sWord, int start, int end) {
		ArrayList<Admin> sellerFListNext = new ArrayList<Admin>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("sellerFListNext");

		try {
			pstmt = conn.prepareStatement(sql);
			if (sKind == 1) {
				pstmt.setString(1, "%" + sWord + "%");
				pstmt.setString(2, "%%");
				pstmt.setInt(3, end);
				pstmt.setInt(4, start);
			} else if (sKind == 2) {
				pstmt.setString(1, "%%");
				pstmt.setString(2, "%" + sWord + "%");
				pstmt.setInt(3, end);
				pstmt.setInt(4, start);
			} else {
				pstmt.setString(1, "%%");
				pstmt.setString(2, "%%");
				pstmt.setInt(3, end);
				pstmt.setInt(4, start);
			}
			rset = pstmt.executeQuery();

			while (rset.next()) {
				sellerFListNext.add(new Admin(rset.getString("SELLER_NO"), rset.getString("STORE_NAME"),
						rset.getString("STORE_EXP"), rset.getString("CEO"), rset.getString("EMAIL"),
						rset.getInt("STORE_NO"), rset.getInt("MEM_USER_NO")));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return sellerFListNext;
	}

	public int memberDel(Connection conn, int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("memberDel");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int sellerMemberDel(Connection conn, int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("sellerMemberDel");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int changeToNomalMember(Connection conn, int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("changeToNomalMember");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int changeToSellerMember(Connection conn, int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("changeToSellerMember");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int storeConfirm(Connection conn, int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("storeConfirm");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public Admin mainPageList(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Admin mainPageList = null;
		String sql = prop.getProperty("mainPageList");
		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				mainPageList = new Admin(rset.getString("F_EVENT_IMG_ORI"), rset.getString("F_EVENT_IMG_SYS"),
						rset.getString("S_EVENT_IMG_ORI"), rset.getString("S_EVENT_IMG_SYS"),
						rset.getInt("DISCOUNT_RATE"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return mainPageList;
	}

	public int eventImgSet(Connection conn, ArrayList<String> fileNameList, int judgeDBUpdate) {
		
		System.out.println(fileNameList);
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "";
		if (judgeDBUpdate != 3) {
			if (judgeDBUpdate == 1) {
				sql = prop.getProperty("eventFImgSet");
			} else {
				sql = prop.getProperty("eventSImgSet");
			}
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, fileNameList.get(0));
				pstmt.setString(2, fileNameList.get(1));

				result = pstmt.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		} else {
			sql = prop.getProperty("eventAllImgSet");

			try {
				pstmt = conn.prepareStatement(sql);
				for (int i = 0; i < 4; i++) {
					pstmt.setString(i + 1, fileNameList.get(i));
				}

				result = pstmt.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		}
		return result;
	}

	public int newSaleRate(Connection conn, int newSaleRate) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("newSaleRate");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newSaleRate);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}

}
