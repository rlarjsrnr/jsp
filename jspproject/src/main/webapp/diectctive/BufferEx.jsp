<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer = "1kb" autoFlush="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- for 부분은 웹에 안뜸 그리고 이 부분에서 4kbyte 이상의 데이터가 발생됨-->
<% for(int i =0; i<1000; i++) {%> 
1234
<%} %>




</body>
</html>