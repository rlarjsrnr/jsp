<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숫자형식, 날짜형식</title>
</head>
<body>
<h3>숫자형식 설정하기</h3>
number : <fmt:formatNumber value="12345.678" type="number"/><br><br>
currency : <fmt:formatNumber value="12345.678" type="currency"/><br><br>

percent : <fmt:formatNumber value="12345.678" type="percent"/><br><br>

pattern : <fmt:formatNumber value="12345.678" pattern=".0"/><br><br>			<%-- 소수점 패턴 --%>
<hr>
<h3>시간과 날짜 출력하기</h3>
<c:set var="now" value="<%=new java.util.Date() %>"/>
<c:out value="${now }"/><br><br>

date : <fmt:formatDate value="${now }" type="date"/><br><br>
time : <fmt:formatDate value="${now }" type="time"/><br><br>
both : <fmt:formatDate value="${now }" type="both"/>
</body>
</html>