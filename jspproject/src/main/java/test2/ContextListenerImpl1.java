package test2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListenerImpl1 implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("�� ���ø� ����.....");//���������� ������Ű��

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("�� ���ø� �ʱ�ȭ.....");

	}

}
