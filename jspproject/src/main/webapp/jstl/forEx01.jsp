<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- forEach : 배열과 컬렉션 데이터를 루프로 작업할 때 사용(for문과 유사)
	
	변수로 제공되는 프로퍼티(property) 
			
			- index : 루프 실행에서 현재 인덱스
			- count : 루프 실행 횟수
			- begin : 루프의 시작값
			- end : 루프의 끝값
			- step : 증감식
			- first : 현재 실행이 첫번째면 true 
			- last : 현재 실행이 마지막이면 true
			- current : 컬렉션 중 현재 루프에서 사용할 객체
			- items : 반복처리할 데이터 
			- varStatus : 루프 상태를 저장할 EL 변수
			- 그외 : var(변수 이름을 지정할 때 쓰는 자료형)
					 
--%>    

<%
	String[] movieList = {"프리즌브레이크","스파르타쿠스","히어로즈"};

	request.setAttribute("movieList", movieList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
인기 미드
<ul>
	<c:forEach var="movie" items="${movieList }">
	<li>${movie }</li>
	</c:forEach>
</ul>
</body>
</html>