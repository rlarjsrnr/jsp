<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%--  

선언문 
	- JSP 페이지에 삽입된 자바 코드를 통해서 멤버변수나 멤버 메소드를 선언할때 사용함
		형식 : <%! 선언문
	
	
스크립트 
	- JSP 페이지에서 작성된 자바 코드를 지원
		형식 <%  자바코드 %>
	

표현식
	- JSP 페이지내에서 직접 클라이언트로 출력될 내용을 표시할때 사용함
		<%= 표현식 =>

--%>

</head>
<body>
	<h2>JSP Script</h2>
	<%
	// Script - 연산처리
	String scriptlet = "스크립트컷";
	String comment = "스크립트컷";
	out.println("내장객체를 이용한 출력:" + declation + "<br><br>");
	%>
	<%!//declation= 변수선언
	String declation = "선언문입니다.";
	%>
	
	
	<%!
	public String declationMethod(){
		return declation;
	}
	%>

	선언문 출력(변수) 출력 :<%=declation%>><br>
	선언문 출력(메소드) 출력 :<%=declationMethod()%>><br>
	스크크립트릿 출력: <%=scriptlet%>><br>

</body>
</html>









