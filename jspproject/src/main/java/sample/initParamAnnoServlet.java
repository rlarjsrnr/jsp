package sample;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(name="initParamAnnoServlet",
//urlPatterns= {"/initParamAnno"},
//initParams = {
//@WebInitParam(name="tel", value = "010-0000-0000"),
//@WebInitParam(name="email", value = "kimasd@naver.com")
//}
//)

public class initParamAnnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(getInitParameter("tel"));
		System.out.println(getInitParameter("email"));
		
		
		
		
	}

	

}
