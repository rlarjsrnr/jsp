package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;

public class ContentAction implements CommandAction { // �� �󼼺��� ó��

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int num = Integer.parseInt(request.getParameter("num")); // �ش� �� ��ȣ
		String pageNum = request.getParameter("pageNum"); // �ش� ������ ��ȣ

		BoardDAO dbPro = BoardDAO.getinstance();

		BoardVO article = dbPro.getArticle(num);

		request.setAttribute("num", num); // �ش� �信�� ����� �Ӽ� ����
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);

		return "/board/content.jsp";
	}

}
