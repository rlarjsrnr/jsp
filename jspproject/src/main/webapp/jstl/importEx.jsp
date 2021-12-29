<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/sample/first.jsp"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
${url }				<%-- 3번째줄에 taglib를 선언하여 uri를 지정하고 import를 하면 간단하게 페이지내용을 가져올 수 있다. --%>
</body>
</html>