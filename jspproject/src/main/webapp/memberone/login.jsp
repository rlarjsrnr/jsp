<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    String loginID= (String)session.getAttribute("loginID");
    
    %>
    
 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="../css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
<% if(loginID != null) {// 로그인이 성공한 경우%>

	<table width="300" border="1">
		<tr>
			<td colspan="3">
			
			<%=loginID%>님환영합니다.
			</td>
		</tr>

<tr>
	<td align="center" width="100">
		<a href="modifyForm.jsp">정보수정</a>
	</td>
	
	<td align="center" width="100">
		<a href="deleteForm.jsp">회원탈퇴</a>
	</td>
	
	<td align="center" width="100">
		<a href="logout.jsp">로그아웃</a>
	</td>


</tr>



	</table>



	<%}else {%>




<form action="loginProc.jsp" method="post">
<table width="300" border="1" >

			<tr>
				<td colspan="2" align="center">회원로그인</td>
			</tr>


			<tr>
				<td width="100" align="right">아이디: </td>
				<td width="200">>&nbsp;&nbsp;

				<input type="text" name="id" size="20">
				</td>
			</tr>



			<tr>
				<td width="100" align="right">비밀: </td>
				<td width="200">>&nbsp;&nbsp;

					<input type="password" name="pass" size="20">
			</td>
			</tr>

			<tr>
				<td colspan="2" align="center">
				
					<input type="submit" value="로그인">&nbsp;&nbsp;;
					<input type="button" value="회원가입" 
				onClick="javascript:window.location='regForm.jsp'">
				</td>

			</tr>


<!-- 동백 &nbsp;  -->
</table>
</form>
<%} %>


</body>
</html>