package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.sql.DataSource;

// Ŀ�ؼ��� �ٵȴ����� Ŀ�ؼ�
public class tempMemberDAO {

	private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String USER = "scott";
	private final String PASS = "tiger";

	public tempMemberDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			System.out.println("Erro : JDBC ����̹� �ε�����");
		}
	}

	private Connection getConnection() {

		Connection con = null;

		try {

			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mydb");
			con = ds.getConnection();

		} catch (Exception e) {
			System.out.println("Ŀ�ؼ� ����");
		}

		return con;

	}

	public Vector<tempMemberVO> getMemberList() {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		Vector<tempMemberVO> vecList = new Vector<tempMemberVO>();

		try {

			// con = DriverManager.getConnection(JDBC_URL, USER, PASS);
			con = getConnection();

			String strQuery = "select * from tempmember";

			stmt = con.createStatement();

			rs = stmt.executeQuery(strQuery);

			while (rs.next()) {

				tempMemberVO vo = new tempMemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setMem_num1(rs.getString("mem_num1"));
				vo.setMen_num2(rs.getString("men_num2"));
				vo.setE_mail(rs.getString("e_mail"));
				vo.setPhone(rs.getString("phone"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress(rs.getString("address"));
				vo.setJob(rs.getString("job"));
				// ����Ʈ �߱�
				vecList.add(vo);

			} // �ϳ��� ������

		} catch (SQLException sq) {
			sq.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException se) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException se) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException se) {
				}
		}
		return vecList;

	}// DB����

}
