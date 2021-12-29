package test2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListenerImpl1 implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("웹 어플리 제거.....");//서버에들어가서 정지시키기

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("웹 어플리 초기화.....");

	}

}
