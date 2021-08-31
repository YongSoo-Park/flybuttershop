package common;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

public class Exprint {
	final static String directoryName = System.getProperty("user.dir").replaceAll("\\\\","/");
	final static String DB_URL = "jdbc:oracle:thin:@fbshop_medium?TNS_ADMIN="+directoryName+"/src/common/Wallet_fbshop";
	final static String DB_USER = "admin";
	final static String DB_PASSWORD = "Flybuttershop0";

	public static void main(String[] args) {
		Connection conn = getConnection();
		try {
			exprint(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

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

	public static void exprint(Connection conn) throws SQLException {
		try (Statement statement = conn.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery("select * from MAINPAGE")) {

				while (resultSet.next()) {
					System.out.println("KIND_VIEW : " + resultSet.getString(1) + "  " + "EVENT_IMG_ORI : "
							+ resultSet.getString(2) + "  " + "EVENT_IMG_SYS : " + resultSet.getString(3) + "  "
							+ "DISCOUNT_RATE : " + resultSet.getString(4) + "  " + "SALE_P_WORD : "
							+ resultSet.getString(5) + "  " + "NEW_P_WORD : " + resultSet.getString(6) + "  "
							+ "PCODE : " + resultSet.getString(7));
				System.out.println("---------------------");
				}
			}
		}
	}

}
