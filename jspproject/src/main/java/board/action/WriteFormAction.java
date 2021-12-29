package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		// 제목글과 답변글의 구분
		int num = 0, ref = 1, step = 0, depth = 0;

		try {
			if (request.getParameter("num") != null) {

				num = Integer.parseInt(request.getParameter("num"));
				ref = Integer.parseInt(request.getParameter("ref"));
				step = Integer.parseInt(request.getParameter("step"));
				depth = Integer.parseInt(request.getParameter("depth"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 헤당뷰 에서 사용할 속성을 저장
		request.setAttribute("num", num);
		request.setAttribute("ref", ref);
		request.setAttribute("step", step);
		request.setAttribute("depth", depth);

		return "/board/writeForm.jsp";// 해당뷰로 속성 값을 넘겨줌
	}

}
