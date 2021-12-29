<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="view/color.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="${bodyback_c} ">
<div align="center">
	<b>글 상세보기</b><br><br>
	<form action="">
		<table width="500" border="1" cellpadding="0" cellspacing="0" align="center" bgcolor="${bodyback_c}">
			<tr height="30">
				<td align="center" width="125" bgcolor="${value_c }">글번호</td>
				<td align="center" width="125" bgcolor="${bodyback_c}">${article.num }</td>
				<td align="center" width="125" bgcolor="${value_c }">조회수</td>
				<td align="center" width="125" bgcolor="${bodyback_c}">${article.readcount }</td>
			</tr>
			<tr height="30">
				<td align="center" width="125" bgcolor="${value_c }">작성자</td>
				<td align="center" width="125" bgcolor="${bodyback_c}">${article.writer }</td>
				<td align="center" width="125" bgcolor="${value_c }">작성일</td>
				<td align="center" width="125" bgcolor="${bodyback_c}">${article.regdate }</td>
			</tr>
			<tr height="30">
				<td align="center" width="125" bgcolor="${value_c }">글제목</td>
				<td align="center" width="375" bgcolor="${bodyback_c }">${article.subject }</td>
			</tr>
			<tr height="30">
				<td align="center" width="125" bgcolor="${value_c }">글내용</td>
				<td align="center" width="375" colspan="3"><pre>${article.content }</pre></td>
			</tr>
			<tr height="30">
				<td colspan="4" bgcolor="${value_c }" align="right">
					<input type="button" value="수정하기" onClick="document.location.href='/jspproject/board/updateForm.de?num=${article.num }&pageNum=${pageNum }'">
					&nbsp;&nbsp;&nbsp;&nbsp;
					
					<input type="button" value="삭제하기" onClick="document.location.href='/jspproject/board/deleteForm.de?num=${article.num }&pageNum=${pageNum }'">
					&nbsp;&nbsp;&nbsp;&nbsp;

					<input type="button" value="답글쓰기" onClick="document.location.href='/jspproject/board/writeForm.de?num=${article.num }&ref=${article.ref }&step=${article.step }&depth=${article.depth }'">
					&nbsp;&nbsp;&nbsp;&nbsp;

					<input type="button" value="글목록" onClick="document.location.href='/jspproject/board/list.de?pageNum=${pageNum}'">
				</td>
				
			</tr>
		</table>
		</form>
</div>
</body>
</html>