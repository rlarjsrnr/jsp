<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>catch태그</title>
</head>
<body>
<c:catch var="ex">
name 파라미터값 : <%=request.getParameter("name") %><br><br>

<%
	if(request.getParameter("name").equals("test")){
%>
${param.name }은 test입니다.
<%}%><br><br>

<c:if test="${ex != null }">
예외발생<br>예외 이름
${ex }
</c:if>

</c:catch>
</body>
</html>