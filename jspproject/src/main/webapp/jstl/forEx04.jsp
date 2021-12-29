<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.HashMap, java.util.Date" %>

<%
	HashMap<String, Object> mapData = new HashMap<String, Object>();
	
	mapData.put("name", "홍길동");
	mapData.put("today", new Date());					// Date date = new Date()로 만들어도 됨

%>

<c:set var="intArray" value="<%=new int[]{1,2,3,4,5} %>"/>
<c:set var="map" value="<%=mapData %>"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h4>int형 배열</h4>
<c:forEach var="i" items="${intArray }" begin="2" end="3">
	[${i}]
</c:forEach><br><br>
<h4>HashMap 출력</h4>
<c:forEach var="i" items="${map }">
${i.key }=${i.value }<br><br>
</c:forEach>
</body>
</html>