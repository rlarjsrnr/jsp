package sample;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/initParam")
public class InitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String company;
	private String manager;
	private String tel;
	private String email;

	public void init() throws ServletException {			
		
		company = getServletContext().getInitParameter("company");			// ServletContext�� �ʱ� �Ķ���� ���� �о��
		manager = getServletContext().getInitParameter("manager");
		
		tel = getServletConfig().getInitParameter("tel");					// ServletConfig�� �ʱ� �Ķ���� ���� �о��
		email = getServletConfig().getInitParameter("email");
	}

	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8");					// jsp ������ Ÿ���� �����ϴ� �ڵ�
		
		PrintWriter out = response.getWriter();	
		
		try {
			
			out.println("<html>");
			out.println("<body>");
			out.println("<ul>");
			out.println("<li>ȸ��� : " + company + "</li>");
			out.println("<li>����� : " + manager + "</li>");
			out.println("<li>��ȭ��ȣ : " + tel + "</li>");
			out.println("<li>�̸��� : " + email + "</li>");
			out.println("</ul>");
			out.println("</body>");
			out.println("</html>");
			
			
		}finally {
			out.close();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}