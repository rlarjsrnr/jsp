<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
HttpServletRequest httpRequest = (HttpServletRequest)pageContext.getRequest();
%>

<br><br>
pageContext.getOut()메소드를 이용하여 출력:
<%pageContext.getOut().print("To all are one.....");%>

</body>
</html>