package test2;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter(urlPatterns = {"*.go"})// /*
public class MyFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("MyFilter ����");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MyFilter ��û���� �ڵ� �۾�");
		request.setCharacterEncoding("utf-8");
		
		System.out.println("MyFilter �������� �ڵ� �۾�");

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyFilter �ʱ�ȭ");	
		
		
		
	}

}
