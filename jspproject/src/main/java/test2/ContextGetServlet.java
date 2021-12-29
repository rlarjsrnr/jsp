package test2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/ContextGet")
public class ContextGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ����� �Ӽ� �� ��������
		String name= (String)getServletContext().getAttribute("name");
		int age =(Integer)getServletContext().getAttribute("age");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("�̸� :" + name + "<br>");
		out.println("���� :" + age + "<br>");
		out.println("</body></html>");

		
		
	}

}
