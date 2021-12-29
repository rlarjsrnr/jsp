<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.*"%>
    
    <!--  
    
    page 지시어
		- 페이지관련 환경을 정의함
		- 주로 문자 인코딩, 응답체이지 컨텐츠 타입등을 정의함 
		
		1. language : 현재는 자바만 지원함
		2. extends : jsp 페이지가 상속받을 부모클래스를 지정함
		3. import : api를  import할 패키지를 명시하면됨
    -->



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	Calendar cal = Calendar.getInstance();
%>

	오늘은
	<%=cal.get(cal.YEAR) %>년 오늘은
	<%=cal.get(cal.MONTH)+1 %>월 오늘은
	<%=cal.get(cal.DATE) %>일
	입니다.


</body>
</html>