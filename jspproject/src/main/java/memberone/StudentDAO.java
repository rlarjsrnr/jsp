package memberone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class StudentDAO {

	private Object dbPass;
	private int result;

	// DB�����Լ�

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

	// ���̵� üũ�Լ�
	public boolean idCheck(String id) {

		boolean result = true;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = getConnection();

			pstmt = con.prepareStatement("select* from student where id=?");

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (!rs.next())
				result = false;

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s1) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException s1) {
				}

		}
		return result;
	}

	// �����ȣ�� db���� �˻��ؼ� Vector�� ��Ƽ� �������ִ� ��� DAO��
	// �߰��Ѵ�.

	public Vector<ZipcodeVO> zipcodeRead(String dong) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Vector<ZipcodeVO> vecList = new Vector<ZipcodeVO>();

		try {

			con = getConnection();
			String strQuery = "select * from zipcode where dong like'" + dong + "%'";

			pstmt = con.prepareStatement(strQuery);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ZipcodeVO tempZipcode = new ZipcodeVO();
				tempZipcode.setZipcode(rs.getString("zipcode"));
				tempZipcode.setSido(rs.getString("sido"));
				tempZipcode.setGugun(rs.getString("gugun"));
				tempZipcode.setDong(rs.getString("dong"));
				tempZipcode.setRi(rs.getString("ri"));
				tempZipcode.setBunji(rs.getString("bunji"));

				vecList.addElement(tempZipcode);

			}
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
		return vecList;

	}// DB����

	public boolean memberInsert(StudentVO vo) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;

		try {

			con = getConnection();
			String strQuery = "insert into student values(?,?,?,?,?,?,?,?,?,?)";

			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone1());
			pstmt.setString(5, vo.getPhone2());
			pstmt.setString(6, vo.getPhone3());
			pstmt.setString(7, vo.getEmail());
			pstmt.setString(8, vo.getZipcode());
			pstmt.setString(9, vo.getAddress1());
			pstmt.setString(10, vo.getAddress2());

			int count = pstmt.executeUpdate();
			if (count > 0)
				flag = true;

		} catch (Exception ex) {
			System.out.println("Exception" + ex);
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
		return flag;

	}// DB����

	// DBptj id password�� ���Ͽ� �װ���� ���������� �������ִ� �޼ҵ带 ������

	// (1: �α��μ���, 0:��й�ȣ���� -1:���̵� ������������)
	public int logunCheck(String id, String pass) {

		// Ŀ�ؼ�, �������, ���� ��������

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int Check = -1;

		try {
			con = getConnection();

			String srtQuery = "select pass from student where id=?";// ���̵� �ִ»��·� �н����带 ã��

			pstmt = con.prepareStatement(srtQuery);
			pstmt.setNString(1, id);

			rs = pstmt.executeQuery();// select �ϰ�� �̰��� ��� executeQuery

			if (rs.next()) {
				String dbPass = rs.getString("pass");

				if (pass.equals(dbPass))
					Check = 1; // �̰� Check=1 ������ ����
				else
					Check = 0; // �ȵǸ� Check=0 �̴�.

			}

		} catch (Exception ex) {// DB����
			System.out.println("Exception" + ex);
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
		return Check;

	}// DB����

	/*
	 * ���������� Ŭ���ϸ� ���� �α����� ȸ���� ���� �����Ҽ� �ֵ��� �̸� ȣ�ȸ鿡 ���������
	 * 
	 * ���ǿ� ����� ���̵� ������ ȸ�������� ���� �޼ҵ尡 �ʿ��� StudentDAO�� ���̵� ������ ȸ�������� ���� �޼ҵ带 �߰��ϸ�
	 * ��
	 * 
	 */

	public StudentVO getMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StudentVO vo = null;

		try {

			con = getConnection();

			String strQuery = "select * from student where id=?";

			pstmt = con.prepareStatement(strQuery);
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new StudentVO();
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setPhone1(rs.getString("phone1"));
				vo.setPhone2(rs.getString("phone2"));
				vo.setPhone3(rs.getString("phone3"));
				vo.setEmail(rs.getString("email"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress1(rs.getString("address1"));
				vo.setAddress2(rs.getString("address2"));
			}

		} catch (Exception ex) {// DB����
			System.out.println("Exception" + ex);
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
		return vo;

	}

	// �������� ��ư�� Ŭ���� �����ͺ��̽��� update�� �����ؾ���
	// ���������� ó������ �޼ҵ��߰�

	public void updateMember(StudentVO vo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = getConnection();

			String strQuery = "update student set pass=?, phone1=?, phone2=?, phone3=?, email=?, zipcode=?, address1=?, address2=? where id=?"; // ������

			pstmt = con.prepareStatement(strQuery);

			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getPhone1());
			pstmt.setString(3, vo.getPhone2());
			pstmt.setString(4, vo.getPhone3());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getZipcode());
			pstmt.setString(7, vo.getAddress1());
			pstmt.setString(8, vo.getAddress2());
			pstmt.setString(9, vo.getId());

			pstmt.executeUpdate();

		} catch (Exception ex) {// DB����
			System.out.println("Exception" + ex);
		} finally {

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

	}

	// Ÿ��Ʋ ��ư�� Ŭ���ϸ� ������ ������ ���̽����� ȸ�������Ͱ� �����Ǿ����.
	// db���� ȸ�������� ó������ �޼ҵ� �߰�

	public int deletMember(String id, String pass) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbPass = "";// ���������� ���̽��� ����� ��й�ȣ

		int result = -1;

		try {
			con = getConnection();
			String strQuery = "select * from student where id=?";
			pstmt = con.prepareStatement(strQuery);

			pstmt.setNString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbPass = rs.getString("pass");
				if (dbPass.equals(pass)) {
					pstmt = con.prepareStatement("delete from student where id=?");
					pstmt.setNString(1, id);
					pstmt.executeUpdate();

					result = 1;

				} else {
					result = 0;
				}
			}
		} catch (Exception ex) {// DB����
			System.out.println("Exception" + ex);
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
		return result;

	}

}
