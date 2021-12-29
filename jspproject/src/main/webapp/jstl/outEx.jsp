<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.io.IOException, java.io.FileReader" %> 
<%  %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소스보기</title>
</head>
<body>
<%
	FileReader reader = null;

try{
	String path = request.getParameter("path");
	reader = new FileReader(getServletContext().getRealPath(path));
%>

<pre>
소스코드 : <%=path %>
	<c:out value="<%=reader %>" escapeXml="true"/>			<%-- escapeXml : 특수문자 처리를 할 것인지 여부 --%>
</pre>

<%
}catch(Exception e){
%>
에러가 발생 : <%=e.getMessage() %>
<%}finally{
	if(reader!=null)
		try{
			reader.close();
		}catch(Exception ex){}
}	
%>

</body>
</html>