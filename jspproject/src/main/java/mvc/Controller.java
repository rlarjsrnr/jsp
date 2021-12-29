package mvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 명령어와 명령어 처리 클래스를 쌍으로 저장함
	private Map<String, Object> commandMap = 
			new HashMap<String, Object>();
	
	/* 명령어와 처리 클래스가 매핑되어 있는 properties 파일을 읽어서  commandMap 에저장
	 *  매핑파일은 Command.properties 파일
	 * 
	 *   web.xml에서 init-param에 해당하는 값을 읽어옴
	 */
	
	public void init(ServletConfig config) throws ServletException {
	  String props = config.getInitParameter("propertyConfig");	
		

	  // 명령어와 처리클래스의 매핑정보를 저장할 properties 객체를 생성함
	  Properties pro = new Properties();
	  String path = config.getServletContext().getRealPath("/WEB-INF");
	  
	  FileInputStream f = null;
	
	  try {
		  
		  //Command.properties 파일의 내용을 불러옴
		  f = new FileInputStream(new File(path, props ));
		  
		  //Command.properties 파일에 있는 매핑정보를 Properties 객체에 저장함
		  pro.load(f);
		  
	  }catch(IOException e) {
		  throw new ServletException(e);
	  }finally {
		  if(f != null) try {f.close();}catch(IOException e) {}
	  }
	  
	  //Iterator 객체 생성
	  Iterator<Object> keyIter = pro.keySet().iterator();
	  
	  // 객체를 하나씩 꺼내서 그 객체명으로 properties 객체에 저장된 객체 접근함
	  while(keyIter.hasNext()) {
		  
		 String command =(String)keyIter.next();
		  String className =pro.getProperty(command);
		  
		  try {
			  // 해당 문자열을 그대로 클래스로 만듬
			  Class commandClass = Class.forName(className);
			  
			  // 해당 클래스의 객체를 생성함
			  Object commandInstance = commandClass.newInstance();
			  
			  //Map 객체인 commandMap에 객체를 저장함
			  commandMap.put(command, commandInstance);
		  }catch(ClassNotFoundException ne) {
			  throw new ServletException(ne);
		  }catch(InstantiationException ie) {
			  throw new ServletException(ie);
		  }catch(IllegalAccessException e) {
			  throw new ServletException(e);
		  }
		   
	  }
	 	
	}

	// 사용자의 요청을 분석해서 해당 작업을 처리하는 메소드
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view = null;
		CommandProcess com = null;
		
		try {
			String command = request.getRequestURI();
			if(command.indexOf(request.getContextPath()) == 0) {
				command = command.substring(request.getContextPath().length());
			}
			com = (CommandProcess)commandMap.get(command);
			view = com.requestPro(request, response);
		}catch(Throwable e) {
			throw new ServletException(e);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
