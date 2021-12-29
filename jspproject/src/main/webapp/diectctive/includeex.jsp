<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>include 지시어</h2>
<%
String name = "G G KIM ";
%>
<%@include file="top.jsp" %>
top.jsp내용포함
<%@include file="Botton.jsp" %>

</body>
</html>