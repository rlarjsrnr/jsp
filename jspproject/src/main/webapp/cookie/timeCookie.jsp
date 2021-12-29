<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   Cookie cookie = new Cookie("hour","1time");
   cookie.setMaxAge(60);
   response.addCookie(cookie); 
   
 %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키의 유효시간</title>
</head>
<body>
유효시간이 설정된 쿠키생성
</body>
</html>