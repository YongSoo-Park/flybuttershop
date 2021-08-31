package common;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

public class JDBCTemplate {
	//C:/Wallet_fbshop/ 이부분은 전자지갑 편한곳에 압출풀어서 본인 폴더경로
	final static String DB_URL = "jdbc:oracle:thin:@fbshop_medium?TNS_ADMIN=C:/Wallet_fbshop/";
	final static String DB_USER = "admin";
	final static String DB_PASSWORD = "Flybuttershop0";



	public static Connection getConnection() {
		OracleConnection conn = null;
		Properties info = new Properties();
		info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, DB_USER);
		info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, DB_PASSWORD);
		info.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");

		try {
			OracleDataSource ods = new OracleDataSource();
			ods.setURL(DB_URL);
			ods.setConnectionProperties(info);
			conn = (OracleConnection) ods.getConnection();
			conn.setAutoCommit(false);

		} catch (Exception e) {
			e.getStackTrace();
		}

		return conn;

	}

	public static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null && !rs.isAfterLast())
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection conn) {
		try {
			if (conn != null && !conn.isClosed())
				conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection conn) {
		try {
			if (conn != null && !conn.isClosed())
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
