package board.action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;

public class ListAction implements CommandAction {

	// �۸��ó��
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String pageNum = request.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1";
		}

		int pagesize = 5;
		int currentPage = Integer.parseInt(pageNum);

		int startRow = (currentPage - 1) * pagesize + 1;
		int endRow = currentPage * pagesize;

		int count = 0;
		int number = 0;

		// �˻�
		String find = null;
		String find_box = null;

		find = request.getParameter("find");
		find_box = request.getParameter("find_box");

		if (find == null) {
			find = "no";
		}

		if (find_box == null) {
			find_box = "no";
		}

		List<BoardVO> articeList = null;

		// �����ͺ��̽� ����
		BoardDAO dbPro = BoardDAO.getinstance();

		/*
		 * count = dbPro.getArticleCount();
		 * 
		 * if (count > 0) { articeList = dbPro.getArticles(startRow, endRow); } else {
		 * articeList = Collections.emptyList(); }
		 */

		count = dbPro.getArticleCount(find, find_box);
		if (count > 0) {
			articeList = dbPro.getArticles(find, find_box, startRow, endRow);
		} else {
			articeList = Collections.emptyList();
		}

		number = count - (currentPage - 1) * pagesize; // �� ��Ͽ� ǥ���� �� ��ȣ

		request.setAttribute("currentPage", currentPage);// �ش� ��(list.jsp)���� ����� �Ӽ��� ����
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("count", count);
		request.setAttribute("pageSize", pagesize);
		request.setAttribute("number", number);
		request.setAttribute("articleList", articeList);
		request.setAttribute("find", new String(find));
		request.setAttribute("find_box", new String(find_box));

		return "/board/list.jsp";
	}

}
