package sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//������ 
    public LifeCycle() {
        System.out.println("LifeServlet �� ������ ȣ���...");
    }
    /*
     * LifeServlet�� �ʱ�ȭ �۾��� ���
     * servlet ��ü������ �� �ѹ��������
     */
    
	
	public void init() throws ServletException {
        System.out.println("inint() ȣ���....��");

	}
	
	//Ŭ���̾�Ʈ�� ��û�� �����븶�� ȣ��
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws
	ServletException, IOException {
        System.out.println("service() ȣ���....��");


	}
	
	//
	public void destroy() {
        System.out.println("destroy() ȣ���....��");

	}

	

}
