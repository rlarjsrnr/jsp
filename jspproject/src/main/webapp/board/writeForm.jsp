<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="view/color.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor="${bodyback_c }">
<div align="center"><b>글쓰기</b></div><br><br>
<form action="/jspproject/board/writePro.de" name="writeForm" method="post" onsubmit="return writeSave()">
<input type="hidden" name="num" value="${num }">
<input type="hidden" name="ref" value="${ref }">
<input type="hidden" name="step" value="${step }">
<input type="hidden" name="depth" value="${depth }">
<table width="400" border="1" cellpadding="0" cellspacing="0" align="center" bgcolor="${bodyback_c }">
	<tr>
		<td align="right" colspan="2" bgcolor="${value_c }"><a href="/jspproject/board/list.de">글목록</a></td>
	</tr>
	<tr>
		<td width="70" bgcolor="${value_c }" align="center">이름</td>
		<td width="330"><input type="text" size="12" maxlength="12" name="writer"></td>
	</tr>
	<tr>
		<td width="70" bgcolor="${value_c }" align="center">이메일</td>
		<td width="330"><input type="text" size="30" maxlength="30" name="email"></td>
	</tr>
	<tr>
		<td width="70" bgcolor="${value_c }" align="center">제목</td>
		<td width="330">
			<c:if test="${num == 0}">
			<input type="text" size="50" maxlength="50" name="subject">				<!-- 새글일 경우 -->
			</c:if>
			<c:if test="${num != 0}">
			<input type="text" size="50" maxlength="50" value="[답변]" name="subject">	<!-- 답변글일 경우 -->
			</c:if>
			</td>
	</tr>
	<tr>
		<td width="70" bgcolor="${value_c }" align="center">내용</td>
		<td width="330"><textarea rows="14" cols="50" name="content"></textarea></td>
	</tr>
	<tr>
		<td width="70" bgcolor="${value_c }" align="center">비밀번호</td>
		<td width="330"><input type="password" size="10" maxlength="10" name="pass"></td>
	</tr>
	<tr>
		<td colspan="2" align="center" bgcolor="${value_c }">
		<input type="submit" value="글쓰기">
		 <input type="reset" value="다시작성">
		 <input type="button" value="목록" onClick="window.location='/jspproject/board/list.de'"></td>
	</tr>
</table>
</form>
</body>
</html>