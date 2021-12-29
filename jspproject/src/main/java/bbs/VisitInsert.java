package bbs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class VisitInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청할때
		request.setCharacterEncoding("utf-8");
		
		// 클라이언트가 http 요청으로 전송한 값을 읽어줌
		String writer = request.getParameter("writer");
		String memo = request.getParameter("memo");
		
		System.out.println("작성자 :"+writer);
		System.out.println("내용 :"+memo);
		
		StringBuffer sql = new StringBuffer();
		sql.append("insert into visit(no, writer, memo, regdate) ");
		sql.append("values(visit_seq.nextval,?,?,sysdate)");
		
		Connection con = null;
		PreparedStatement pstmt = null;
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl",
					"scott", "tiger");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, writer);
			pstmt.setString(2, memo);
			
			pstmt.executeUpdate();
			
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			try {if(pstmt != null) pstmt.close();}catch(SQLException s) {}
			try {if(con != null) con.close();}catch(SQLException s) {}
		}
		
		//리스트 페이지이동
		response.sendRedirect("VisitList");
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

	}

}
