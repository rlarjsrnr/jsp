<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%@ page import="action.Customer" %>
<% request.setCharacterEncoding("utf-8"); %>
	
<jsp:useBean id="customer" class="action.Customer" scope="page"/>
<jsp:setProperty property="*" name="customer"/>
`<!--id 의 객체는 ="customer"이다.-->
`<!--class는 ="action 패키지의 Customer"이다.-->
`<!--스코프는 page-->

<!-- property 모든값  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	`<!--name 의 객체는 ="customer"이다.-->
	<ul>
		<li>이름: <jsp:getProperty property="name" name="customer"/></li>
		<li>메일: <jsp:getProperty property="email" name="customer"/></li>
		<li>전화번호: <jsp:getProperty property="phone" name="customer"/></li>
	</ul>



</body>
</html>