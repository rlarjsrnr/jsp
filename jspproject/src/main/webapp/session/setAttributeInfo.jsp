<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //세션에 저장
    	session.setAttribute("MEMBRID", "stdio");
    	session.setAttribute("NAME", "김씨");

    %>

<%
// 세션에 정보를 불러 올때
String memberid = (String)session.getAttribute("MEMBRID");
String name = (String)session.getAttribute("NAME");

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션정보저장</title>
</head>
<body>
세션 정보를 저장하였습니다.

<br><br>
세션에 정보를 불러들어옴 <br>
Member ID: <%=memberid %><br>
Name: <%=name %>
</body>
</html>


