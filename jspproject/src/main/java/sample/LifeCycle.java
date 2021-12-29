package sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//생성자 
    public LifeCycle() {
        System.out.println("LifeServlet 의 생성자 호출됨...");
    }
    /*
     * LifeServlet의 초기화 작업을 담당
     * servlet 객체생성시 단 한번만수행됨
     */
    
	
	public void init() throws ServletException {
        System.out.println("inint() 호출됨....ㅣ");

	}
	
	//클라이언트의 요청이 있을대마다 호출
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws
	ServletException, IOException {
        System.out.println("service() 호출됨....ㅣ");


	}
	
	//
	public void destroy() {
        System.out.println("destroy() 호출됨....ㅣ");

	}

	

}
