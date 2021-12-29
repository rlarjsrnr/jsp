package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	private static BoardDAO instance = null;

	public BoardDAO() {
	}

	public static BoardDAO getinstance() {

		if (instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	}

	// �̰��� �Խ��� �۾��� ��ɵ��� �ϳ��ϳ� �߰��ϴ� �޼ҵ带 �ۼ�

	// ��ü ���� ������ ������ �޼ҵ� ����
	public int getArticleCount() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}

		} catch (Exception se) {
			System.out.println("Exception" + se);
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException s2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s3) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
		}

		return x;
	}

	public int getArticleCount(String find, String find_box) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			con = ConnUtil.getConnection();

			if (find.equals("writer")) {
				pstmt = con.prepareStatement("select count(*) from board where writer=?");
				pstmt.setString(1, find_box);
			} else if (find.equals("subject")) {
				pstmt = con.prepareStatement("select count(*) from board where subject like '%" + find_box + "%'");
			} else if (find.equals("content")) {
				pstmt = con.prepareStatement("select count(*) from board where content like '%" + find_box + "%'");

			} else {
				pstmt = con.prepareStatement("select count(*) from board");

			}

			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}

		} catch (Exception se) {
			System.out.println("Exception" + se);
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException s2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s3) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
		}

		return x;
	}

	public List<BoardVO> getArticles(int start, int end) {// ���� 1

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> articleList = null;

		try {

			con = ConnUtil.getConnection();
			// ����2
			// pstmt = con.prepareStatement("select * from board order by num desc");
			pstmt = con.prepareStatement("select * from (select rownum rnum, num, writer, email, subject, pass, "
					+ "regdate, readcount, ref, step, depth, content, ip from "
					+ "(select * from board order by ref desc, step asc)) " + "where rnum >= ? and rnum <=?");

			// ���� 3
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				articleList = new ArrayList<BoardVO>(5);// ���� 4

				do {
					BoardVO article = new BoardVO();

					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPass(rs.getString("pass"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));

					articleList.add(article);

				} while (rs.next());
			}
		} catch (Exception se) {
			System.out.println("Exception" + se);
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException s2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s3) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
		}
		return articleList;

	}

	public List<BoardVO> getArticles(String find, String find_box, int start, int end) {// ���� 1

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> articleList = null;

		try {

			con = ConnUtil.getConnection();
			// ����2
			// pstmt = con.prepareStatement("select * from board order by num desc");

			StringBuffer sql = new StringBuffer();
			sql.append("select*form ");
			sql.append(
					"(select rownum rnum, num, writer, email, subject, pass, regdate, readcount, ref, step, depth, content, ip from");

			if (find.equals("writer")) {
				sql.append("(select * from where writer=? order by ref desc, step asc))where rnum >= ? and rnum <=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, find_box);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);

			} else if (find.equals("subjet")) {
				sql.append("(select * from board where subject like'%" + find_box
						+ "' order by ref desc, step asc))where rnum >= ? and rnum <=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			} else if (find.equals("content")) {
				sql.append("(select * from board where content like'%" + find_box
						+ "' order by ref desc, step asc))where rnum >= ? and rnum <=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			} else {
				sql.append("(select * from board where content like'%" + find_box
						+ "' order by ref desc, step asc))where rnum >= ? and rnum <=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}

			rs = pstmt.executeQuery();

			if (rs.next()) {

				articleList = new ArrayList<BoardVO>(5);// ���� 4

				do {
					BoardVO article = new BoardVO();

					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPass(rs.getString("pass"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));

					articleList.add(article);

				} while (rs.next());
			}
		} catch (Exception se) {
			System.out.println("Exception" + se);
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException s2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s3) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
		}
		return articleList;

	}

	// �� ������ ó������ �޼ҵ� ����(insertArticle)
	public void insertArticle(BoardVO article) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int num = article.getNum();
		int ref = article.getRef();
		int step = article.getStep();
		int depth = article.getDepth();

		int number = 0;

		String sql = "";

		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select max(num) from board");
			rs = pstmt.executeQuery();
			if (rs.next())
				number = rs.getInt(1) + 1; // ����
			else
				number = 1; // ������ �ƴѰ��

			if (num != 0) {// �亯��
				sql = "update board set step=step+1 where ref=? and step > ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, step);

				pstmt.executeUpdate();

				step = step + 1;
				depth = depth + 1;
			} else { // ������ ���
				ref = number;
				step = 0;
				depth = 0;
			}
			// ������ �߰��ϴ� ���� �ۼ�
			sql = "insert into board(num, writer, email, subject, pass, regdate, ref, step, depth, content, ip) values(board_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getEmail());
			pstmt.setString(3, article.getSubject());
			pstmt.setString(4, article.getPass());
			pstmt.setTimestamp(5, article.getRegdate());
			pstmt.setInt(6, ref);
			pstmt.setInt(7, step);
			pstmt.setInt(8, depth);
			pstmt.setString(9, article.getContent());
			pstmt.setString(10, article.getIp());

			pstmt.executeUpdate();

		} catch (Exception se) {
			System.out.println("Exception" + se);
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException s2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s3) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
		}

	}

	/*
	 * �� ������ ������ �� ������ ���� �ֵ��� �ؾ���
	 * 
	 * �츮�� �� num�� �Ű������� �ؼ� �ϳ��� �ۿ� ���� ���������� �����ͺ��̽��� �����;��� �����ͺ��̽����� �� �ϳ��� ������ ������ �޼ҵ�
	 * ����
	 */

	public BoardVO getArticle(int num) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;

		try {

			con = ConnUtil.getConnection();

			pstmt = con.prepareStatement("update board set readcount =readcount+1 where num=?");

			pstmt.setInt(1, num);
			pstmt.executeUpdate();

			pstmt = con.prepareStatement("select * from board where num=?");

			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new BoardVO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPass(rs.getString("pass"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setStep(rs.getInt("step"));
				article.setDepth(rs.getInt("depth"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
			}
		} catch (Exception se) {
			System.out.println("Exception" + se);
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException s2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s3) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
		}

		return article;

	}

	/*
	 * �� �󼼺��� ȭ�鿡�� [�ۼ���] ��ư�� ���� ��� updateForm.jsp�� �̵��ϵ��� ��ũ�� �ɾ����Ƿ� �� ���� ȭ���� �����ؾ���
	 * 
	 * �� ���� �ÿ��� �� ��� ����� �ٸ��� ��ȸ���� ������ų �ʿ䰡 ����
	 * 
	 * ��ȸ���� ���� ��Ű�� �κ��� �����ϰ� num�� �ش��ϴ� ���� �������� �޼ҵ� ����
	 */

	public BoardVO updateGetArticle(int num) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;

		try {

			con = ConnUtil.getConnection();

			pstmt = con.prepareStatement("select * from board where num=?");

			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new BoardVO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPass(rs.getString("pass"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setStep(rs.getInt("step"));
				article.setDepth(rs.getInt("depth"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
			}
		} catch (Exception se) {
			System.out.println("Exception" + se);
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException s2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s3) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
		}

		return article;
	}

	/*
	 * �����ͺ��̽����� ���� ���� ó���� �Ǿ����
	 * 
	 * ���� ����ó�� �� �޼ҵ� ���� ���� ���� �� -1, �� ���� ���� 1, �� ���� ���� : 0
	 */
	public int updateArticle(BoardVO article) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbpasswd = "";
		String sql = "";

		int result = -1;

		try {

			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select pass from board where num=?");

			pstmt.setInt(1, article.getNum());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpasswd = rs.getString("pass");
				if (dbpasswd.equals(article.getPass())) {
					// ��й�ȣ�� ��ġ�ϸ� ������������
					sql = "update board set writer=?, email=?, subject=?, content=? where num=?";

					pstmt = con.prepareStatement(sql);

					pstmt.setString(1, article.getWriter());
					pstmt.setString(2, article.getEmail());
					pstmt.setString(3, article.getSubject());
					pstmt.setString(4, article.getContent());
					pstmt.setInt(5, article.getNum());

					pstmt.executeUpdate();
					result = 1; // ���� ����

				} else {
					result = 0;
				}
			}
		} catch (Exception se) {
			System.out.println("Exception" + se);
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException s2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s3) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
		}

		return result;
	}

	/*
	 * �� ���� ó��
	 * 
	 * �����ͺ��̽����� ��й�ȣ�� ���Ͽ� ������ ������ �������� �޼ҵ带 ������
	 */

	public int deleteArticle(int num, String pass) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbpasswd = "";
		String sql = "";

		int result = -1;

		try {

			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select pass from board where num=?");

			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpasswd = rs.getString("pass");
				if (dbpasswd.equals(pass)) {
					// ��й�ȣ�� ��ġ�ϸ� ������������
					sql = "delete from board where num=?";

					pstmt = con.prepareStatement(sql);

					pstmt.setInt(1, num);

					pstmt.executeUpdate();
					result = 1; // ���� ����

				} else {
					result = 0;// ��й�ȣ Ʋ��
				}
			}
		} catch (Exception se) {
			System.out.println("Exception" + se);
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException s2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException s3) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException s1) {
				}
		}

		return result;
	}

}