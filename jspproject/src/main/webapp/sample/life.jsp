<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%!private int numOne = 0;

	public void jspInit() {// 최초 호출시에만 사용함 
		System.out.println("jspInit() 메소드호출");

	}

	public void jspDesttoy() {// tomcat에 종료될때 호출
		System.out.println("jspDesttoy() 메소드호출");

	}%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//연산처리 
	int numTwo = 0;
	numOne++; // 새로 고칠때 마다 증가(_jspservice 호출)//재정의 불가능
	numTwo++; // 새로고칠때마다 초기화(jspInit()호출) // 재정의 가능
	%>
	<ul>
		<li>Number One : <%=numOne%>></li>
		<li>Number Two : <%=numTwo%>></li>

	</ul>



</body>
</html>