<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%
  request.setCharacterEncoding("utf-8");
  
  String name = request.getParameter("name");
  String subject = request.getParameter("subject");
  String filename1 = request.getParameter("filename1");
  String filename2 = request.getParameter("filename2");
  String origfilename1 = request.getParameter("origfilename1");
  String origfilename2 = request.getParameter("origfilename2");
  
  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 확인 및 다운로드</title>
</head>
<body>
<div align="center">

올린사람 : <%=name %><br>
제목 : <%=subject %><br>
파일명1 : <a href="/jspproject/upload/<%=filename1 %>">
<%=filename1 %></a><br>

파일명1 : <a href="/jspproject/upload/<%=filename2 %>">
<%=filename2 %></a><br>

</div>

</body>
</html>


