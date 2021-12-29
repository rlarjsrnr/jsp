<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ page import="java.net.URLEncoder" %>
        <%@ page import="java.net.URLDecoder" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키목록</title>
</head>
<body>
<h3>쿠키목록<h3></h3>
<%

	Cookie[]cookies =request.getCookies();

	if(cookies != null && cookies.length >0){
		for(int i = 0; i < cookies.length; i++){
			

%>
	<%=cookies[i].getName()%>=
	<%=URLDecoder.decode(cookies[i].getValue(),"UTF-8") %>
<%
  }
}else{
 %>
쿠키값이 존재 안함

<%} %>

</body>
</html>