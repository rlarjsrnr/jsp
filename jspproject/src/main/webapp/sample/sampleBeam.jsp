<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="sample.*"%>

<%
request.setCharacterEncoding("utf-8");

%>


<!-- msg 객체 -->
 <jsp:useBean id="msg" class ="sample.sampledata"></jsp:useBean>
 <jsp:setProperty property="message" name="msg"/><!-- 여기서 닫기 -->
 <!-- message 변수 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<font size="5">
메세지 : <jsp:getProperty property="message" name="msg"/>
</font>


</body>
</html>

