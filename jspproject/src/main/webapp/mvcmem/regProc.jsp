<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="mvcmem.model.*" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 확인</title>
<link href="style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="script.js"></script>
</head>
<body>
<c:set var="flag" value="${flag }"/>
<br><br>
<div align="center">
  <c:choose>
	<c:when test="${flag }">
	<b>회원가입을 축하드립니다.</b><br>
	<a href="member.mdo?cmd=login">로그인</a>
	</c:when>
	
	<c:otherwise>
	<b>다시 입력해주시면 고맙 ㅋ ㅋ ㅋ</b>
		<a href="member.mdo?cmd=regForm">다시입력</a>
	</c:otherwise>
</c:choose>
</div>



</body>
</html>