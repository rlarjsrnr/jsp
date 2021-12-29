<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>C:forToken</title>
<%-- 
	var : 토큰
	items : 문자열
	delims : 구분자
 --%>
</head>
<body>

<c:forTokens var="car" items="Sprinter Trueno AE86, RX-7 Savanna ECS3S, Lnacer Evolution III, RX-7 Efini DF" delims=",">
자동차 이름 : <c:out value="${car }"/><br>
</c:forTokens><br>
<hr color="blue"><br>
<c:forTokens var="token" items="빨간색, 주황색, 노란색. 초록색, 파란색, 남색. 보라색" delims=",.">
${token }<br>

</c:forTokens>
</body>
</html>