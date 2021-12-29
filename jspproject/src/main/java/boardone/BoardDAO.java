package boardone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	private static BoardDAO instance = null;
	// private ArrayList<BoardVO> articleList;

	public BoardDAO() {
	}

	public static BoardDAO getInstance() {

		if (instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	}

	// 이곳에 게시판 작업의 기능들을 하나하나 메소드로 추가 하면됨

	public void insertArticle(BoardVO article) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int num = article.getNum();
		int ref = article.getRef(); // 새글
		int step = article.getStep();
		int depth = article.getDepth();

		int number = 0;

		String sql = "";

		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select max(num) from board");
			rs = pstmt.executeQuery();

			if (rs.next())
				number = rs.getInt(1) + 1;
			else
				number = 1; // 새글이 아닐경우

			if (num != 0) {// 답변글
				sql = "update board set step=step+1 where ref=? and step > ?";
				pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, ref);
				pstmt.setInt(2, step);

				pstmt.executeUpdate();

				step = step + 1;
				depth = depth + 1;

			} else {
				ref = number;
				step = 0;
				depth = 0;
			}

			sql = "insert into board(num, writer, email, subject, pass, regdate, ref, step, depth, content, ip) "
					+ "values(board_seq.nextval,?,?,?,?,?,?,?,?,?,?) ";

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
	}

	// 전체 글개수를 가져올 메소드

	public int getArticleCount() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {

			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select count(*)from board");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}

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
		return x;
	}

	// board table 에서 가져올 메소드 구현 (List로 구현)
	public List<BoardVO> getArticles(int start, int end) { // 수정 1

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> articleList = null;

		try {

			con = ConnUtil.getConnection();
			// 수정2
			// pstmt = con.prepareStatement("select * from board order by num desc");
			pstmt = con.prepareStatement("select * from(select rownum rnum, num, writer, email, subject, pass, "
					+ "regdate, readcount, ref, step, depth, content, ip from "
					+ "(select * from board order by ref desc, step asc)) where rnum >= ? and rnum <=?");

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList<BoardVO>(end - start + 1); // 수정4

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

		return articleList;

	}

	/*
	 * 글제목을 누르면 글 내용을 볼수있도록 해야함 우리는 글 num 을 매개변수로 해서 하나의 글에 대한 세부정보를 데이터베이스에서 가져와야함
	 * 데이터베이스에서 글하나의 정보를 가져올 메소드르 구현
	 */

	public BoardVO getArticle(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;
		try {

			con = ConnUtil.getConnection();

			pstmt = con.prepareStatement("update board set readcount = readcount+1 where num=?");

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
		return article;
	}

	/*
	 * 글 상세보기 화면에서 글 수정 버튼을 누를 경우 updateForm.jsp로 이동하도록 링크를 걸었으므로 글 수정화면을 설계해야함
	 *
	 * 글 수정시에는 글 목록 보기와 다르게 조회수를 증가시킬 필요가 없음
	 * 
	 * 조회수를 증가 시키는 부분을 제회하고 num에 해당되는 글을 가져오는 메소드를 구현
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
		return article;
	}

	/*
	 * 데이터베이스에서 실제 수정처리가 되어야함
	 * 
	 * 글을 수정처리 할 메소드 구현 글이 없을때 -1, 술수정 성공 1, 글 수정실패: 0
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
					// 비밀번호가 일치하면 수정쿼리실행
					sql = "update board set writer=?, email=?, subject=?, content=? where num=?";

					pstmt = con.prepareStatement(sql); // 실행

					pstmt.setString(1, article.getWriter());
					pstmt.setString(2, article.getEmail());
					pstmt.setString(3, article.getSubject());
					pstmt.setString(4, article.getContent());
					pstmt.setInt(5, article.getNum());

					pstmt.executeUpdate();
					result = 1;// 수정성공

				} else {
					result = 0; // 그렇지않을경우
				}

			}

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
		return result;
	}
	/*
	 * 글삭제 처리 데이터베이스에서 비밀 번호를 비교하여 실제로 삭제를 수행해줄 메소드를 구현함
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
					// 비밀번호가 일치하면 수정쿼리실행
					sql = "delete from board where num=?";

					pstmt = con.prepareStatement(sql); // 실행

					pstmt.setInt(1, num);

					pstmt.executeUpdate();
					result = 1;// 삭제성공

				} else {
					result = 0; // 그렇지않을경우
				}

			}

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
		return result;
	}

	// 검색기능
	/*
	 * public ArrayList<BoardDAO> getBoddSearch(int pageNum, int pagelist, String
	 * keyWord, String search) { Connection con = null; PreparedStatement pstmt =
	 * null; ResultSet rs = null; BoardVO article = null;
	 * 
	 * 
	 * try { con = ConnUtil.getConnection();
	 * 
	 * 
	 * PreparedStatement pstmt = con.prepareStatement(SQL); rs =
	 * pstmt.executeQuery();// select
	 * 
	 * }
	 * 
	 * 
	 * if (rs.next()) { article = new BoardVO(); article.getNum(rs.getInt("num"));
	 * article.getWriter(rs.getString("writer"));
	 * article.getEmail(rs.getString("email"));
	 * article.getSubject(rs.getString("subject"));
	 * article.getPass(rs.getString("pass"));
	 * article.getRegdate(rs.getTimestamp("regdate"));
	 * article.getReadcount(rs.getInt("readcount"));
	 * article.getRef(rs.getInt("ref")); article.setStep(rs.getInt("step"));
	 * article.setDepth(rs.getInt("depth"));
	 * article.setContent(rs.getString("content"));
	 * article.setIp(rs.getString("ip"));
	 * 
	 * }
	 * 
	 * }catch(
	 * 
	 * Exception e) { e.printStackTrace(); }finally { JDBC }return boards;
	 * 
	 * }
	 */

}
