package test2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/ContextSet")
public class ContextSetSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ¼Ó¼º °ª ¼³Á¤

		String name= "±è¾¾";
		int age =20;

		getServletContext().setAttribute("name", name);
		getServletContext().setAttribute("age", age);
		
		
		




	}

}
