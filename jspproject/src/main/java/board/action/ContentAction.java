package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;

public class ContentAction implements CommandAction { // 글 상세보기 처리

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int num = Integer.parseInt(request.getParameter("num")); // 해당 글 번호
		String pageNum = request.getParameter("pageNum"); // 해당 페이지 번호

		BoardDAO dbPro = BoardDAO.getinstance();

		BoardVO article = dbPro.getArticle(num);

		request.setAttribute("num", num); // 해당 뷰에서 사용할 속성 저장
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);

		return "/board/content.jsp";
	}

}
