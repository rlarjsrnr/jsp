package sample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Source extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Source Start....");

		/* �������̵�
		//�޼ҵ� ȣ���� ���ؼ� �������� �̿��Ҽ� �ִ� ���
		//1.forward ��������̵�
		// - url : url�� �ٲ����ʴ´�.
		// ��û��ü�� ���䰴ü : �����Ѵ�.
		// �ӵ� : ����
		// �Ҽ� : ��û��ü
		 */

//		RequestDispatcher view = request.getRequestDispatcher("Destination");// ù��°���
//		view.forward(request, response);


		/*2. redirect ��������̵�
		// - url : url�� �ٲ��.
		// ��û��ü�� ���䰴ü : �������Ѵ�
		// �ӵ� : ����
		// �Ҽ� : ���䰴ü
		 */

		response.sendRedirect("Destination");
		

	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

	}

}
