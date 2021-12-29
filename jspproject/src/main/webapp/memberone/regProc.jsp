<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  <%request.setCharacterEncoding("utf-8"); %>
    
    <jsp:useBean id="dao" class="memberone.StudentDAO"/>
    <jsp:useBean id="vo" class="memberone.StudentVO">
    
    <jsp:setProperty property="*" name="vo"/>
    </jsp:useBean>
    
    <%
    boolean flag = dao.memberInsert(vo);
    
    
    %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" >
<title>회원 가입 확인</title>
<link href="../css/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body bgcolor="#FFFFCC">
<br><br>
<div align="center">
<%
if(flag){
	out.println("<b> 회원가입을 축하합니다.</b><br>");
	out.println("<a href='login.jsp'>로그인</a>");
}else{
	out.println("<b> 다시입력해주세요.</b><br>");
	out.println("<a href='regForm.jsp'>다시 가입</a>");
}


%>


</div>


</body>
</html>