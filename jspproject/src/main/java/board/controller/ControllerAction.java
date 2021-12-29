package board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.CommandAction;

public class ControllerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ��ɾ�� ��ɾ� ó�� Ŭ������ ������ ������
	private Map<String, Object> commandMap = new HashMap<String, Object>();

	/*
	 * ��ɾ�� ó�� Ŭ������ ���εǾ� �ִ� properties ������ �о commandMap ������ ����������
	 * Command.properties ����
	 * 
	 * web.xml���� init-param�� �ش��ϴ� ���� �о��
	 */

	public void init(ServletConfig config) throws ServletException {
		String props = config.getInitParameter("propertyConfig");

		// ��ɾ�� ó��Ŭ������ ���������� ������ properties ��ü�� ������
		Properties pro = new Properties();
		String path = config.getServletContext().getRealPath("/WEB-INF");

		FileInputStream f = null;

		try {

			// Command.properties ������ ������ �ҷ���
			f = new FileInputStream(new File(path, props));

			// Command.properties ���Ͽ� �ִ� ���������� Properties ��ü�� ������
			pro.load(f);

		} catch (IOException e) {
			throw new ServletException(e);
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException e) {
				}
		}

		// Iterator ��ü ����
		Iterator<Object> keyIter = pro.keySet().iterator();

		// ��ü�� �ϳ��� ������ �� ��ü������ properties ��ü�� ����� ��ü ������
		while (keyIter.hasNext()) {

			String command = (String) keyIter.next();
			String className = pro.getProperty(command);

			try {
				// �ش� ���ڿ��� �״�� Ŭ������ ����
				Class commandClass = Class.forName(className);

				// �ش� Ŭ������ ��ü�� ������
				Object commandInstance = commandClass.newInstance();

				// Map ��ü�� commandMap�� ��ü�� ������
				commandMap.put(command, commandInstance);
			} catch (ClassNotFoundException ne) {
				throw new ServletException(ne);
			} catch (InstantiationException ie) {
				throw new ServletException(ie);
			} catch (IllegalAccessException e) {
				throw new ServletException(e);
			}

		}

	}

	protected void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String view = null;
		CommandAction com = null;

		try {

			String command = request.getRequestURI();
			if (command.indexOf(request.getContextPath()) == 0) {
				command = command.substring(request.getContextPath().length());
			}
			com = (CommandAction) commandMap.get(command);
			view = com.requestPro(request, response);

		} catch (Throwable e) {
			throw new ServletException(e);

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestPro(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestPro(request, response);
	}

}
