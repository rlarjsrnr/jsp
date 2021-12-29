<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="memberone.*" %>
    
    <jsp:useBean id="dao" class="memberone.StudentDAO"/>
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" content="3; url=login.jsp">
<meta charset="UTF-8">
<title></title>
<%
String id = (String) session.getAttribute("loginID");
String pass = request.getParameter("pass");
int check = dao.deletMember(id, pass);

if (check == 1) {

	session.invalidate();


%>
<body>
</head>
<div align="center">
<font size="5" face="궁서체">
입력하신내용대로 <b>회원정보가 탈퇴되었습니다.</b><br><br>
3초 후에 Log in page로 이동 합니다.
</font>
<%}else{%>
<script type="text/javascript">
alert("비밀번호맞지않음")
hisstory.go(-1);

</script>
<%}%>

</div>
</body>
</html>