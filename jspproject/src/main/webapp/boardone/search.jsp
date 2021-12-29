<%-- <%@page import="boardone.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="boardone.BoardVO" %>
<%@ page import="boardone.BoardDAO" %>
    
    
    <%
request.setCharacterEncoding("UTF-8");

//페이지 번호
int pageNum = 0;
if(request.getParameter("page") == null){
	pageNum = 1;
}else{
	pageNum = Integer.parseInt(request.getParameter("page"));
}
//한 페이지에 나타낼 리스트 변수 선언
int pageList = 4;

//검색어
String keyWord = request.getParameter("keyWord");
String searchWord = request.getParameter("searchWord");

//글 목록 전체 가져오기
BoardDao dao = BoardDao.getInstance(); // Dao 정보 가져오기
ArrayList<BoardDto> boards = dao.getBoardSearch(pageNum, pageList, keyWord, searchWord);

//검색 전체  list count
int count = dao.getCount(keyWord, searchWord);

//page count
int pageCount = (int)Math.ceil((double)count / pageList); //ceil은 올림함수

%>	
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<tr>
		<td><%=list.get(i).getBbsID()%></td>
		현재 게시글에 대한 정보
		<td><a href="view.jsp?bbsID=<%=list.get(i).getBbsID()%>">
		<%=list.get(i).getBbsTitle().replaceAll(" ", "&nbsp;").
		replaceAll("<", "&lt;")
	 	.replaceAll(">", "&gt;").replaceAll("\n", "<br>")%></a></td>
		<td><%=list.get(i).getUserID()%></td>
		<td><%=list.get(i).getBbsDate().substring(0, 11) + 
		list.get(i).getBbsDate().substring(11, 13) + "시"
		+ list.get(i).getBbsDate().substring(14, 16) + "분"%></td>
		<td><%=list.get(i).getBbsCount()%></td>
		<td><%=list.get(i).getLikeCount()%></td>
		</tr>
		<%}%>


</body>
</html> --%>