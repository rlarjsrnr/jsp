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

	// DB연결함수

	private Connection getConnection() {

		Connection con = null;

		try {

			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mydb");
			con = ds.getConnection();

		} catch (Exception e) {
			System.out.println("커넥션 실패");
		}

		return con;

	}

	// 아이디 체크함수
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

	// 우편번호를 db에서 검색해서 Vector에 담아서 리턴해주는 기능 DAO에
	// 추가한다.

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

	}// DB연결

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

	}// DB연결

	// DBptj id password를 비교하여 그결과를 정수형으로 리턴해주는 메소드를 구현함

	// (1: 로그인성공, 0:비밀번호오류 -1:아이디 존재하지않음)
	public int logunCheck(String id, String pass) {

		// 커넥션, 결과집합, 동적 쿼리생성

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int Check = -1;

		try {
			con = getConnection();

			String srtQuery = "select pass from student where id=?";// 아이디가 있는상태로 패스워드를 찾음

			pstmt = con.prepareStatement(srtQuery);
			pstmt.setNString(1, id);

			rs = pstmt.executeQuery();// select 일경우 이것을 사용 executeQuery

			if (rs.next()) {
				String dbPass = rs.getString("pass");

				if (pass.equals(dbPass))
					Check = 1; // 이게 Check=1 같으면 성공
				else
					Check = 0; // 안되면 Check=0 이다.

			}

		} catch (Exception ex) {// DB연결
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

	}// DB연결

	/*
	 * 정보수정을 클릭하면 현재 로그인한 회원을 정보 수정할수 있도록 미리 호ㅘ면에 보여줘야함
	 * 
	 * 세션에 저장된 아이디를 가지고 회원정보를 얻어올 메소드가 필요함 StudentDAO에 아이디를 가지고 회원정보를 얻어올 메소드를 추가하면
	 * 됨
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

		} catch (Exception ex) {// DB연결
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

	// 정보수정 버튼을 클릭시 데이터베이스에 update를 스행해야함
	// 정보수정을 처리해줄 메소드추가

	public void updateMember(StudentVO vo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = getConnection();

			String strQuery = "update student set pass=?, phone1=?, phone2=?, phone3=?, email=?, zipcode=?, address1=?, address2=? where id=?"; // 쿼리문

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

		} catch (Exception ex) {// DB연결
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

	// 타이틀 버튼을 클릭하면 실제로 데이터 베이스에서 회원데이터가 삭제되어야함.
	// db에서 회원삭제를 처리해줄 메소드 추가

	public int deletMember(String id, String pass) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbPass = "";// 실제데이터 베이스에 저장된 비밀번호

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
		} catch (Exception ex) {// DB연결
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
