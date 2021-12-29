<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page isErrorPage="true" %>
<!-- Throwable 객체인 exception을 사용할것인지를 정함  -->
    
    
<%response.setStatus(HttpServletResponse.SC_OK); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외발생</title>
</head>
<body>
요청처리 과정에서 예외가 발생 하였습니다.<br><br>
빠른시간내 에 문제를 해결 하도록 하겠습니다.<br><br>
<br><br>
에러타임 : <%=exception.getClass().getName() %><br><br>
에러 메세지 : <b><%=exception.getMessage() %></b>



</body>
</html>