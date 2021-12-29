package mvcmem.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcmem.control.ActionForward;

// 액션 클래스의 슈퍼 인터페이스

public interface Action {

	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws IOException;
	
}
