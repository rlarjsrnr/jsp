package logon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LogonDBBean {

	private static LogonDBBean instance = new LogonDBBean();

	public LogonDBBean() {
	}

	public static LogonDBBean getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {

		// InitialContext ctx = new InitialContext();

		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/mydb");

		return ds.getConnection();

	}

	public int userCheck(String id, String passwd) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 1;

		String dbpasswd = "";

		try {
			con = getConnection();
			pstmt = con.prepareStatement("select pass from tempmember where id=?");

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpasswd = rs.getString("passwd");
				if (dbpasswd.equals(passwd))
					x = 1;
				else
					x = 0; // 안에있는 if문
			} else
				x = 1; // 밖에있는 if문

		} catch (Exception e) {
			System.out.println("Exception" + e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException se) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException se) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException se) {
				}
		}
		return x;
	}

}
