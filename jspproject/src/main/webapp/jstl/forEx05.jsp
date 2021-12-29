<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h3>1부터 100까지의 홀수의 합</h3>
<c:set var="sum" value="0"/>
<c:forEach var="i" begin="1" end="100" step="2" >
	<c:set var="sum" value="${sum+i }"/>
</c:forEach>
결과값 : ${sum }

<h3>구구단 4단</h3>
<ul>
	<c:forEach var="i" begin="1" end="9" step="1">
		<li>4 * ${i } = ${4*i }</li>
	</c:forEach>
</ul>

<h3>3의 배수를 출력하기</h3>
<c:set var="besu" value="1"/>
<h4>3의 배수 : 
<c:forEach var="i" begin="3" end="45" step="3">
 ${i*besu }
</c:forEach>
</h4>

<h3>팩토리얼 출력하기</h3>
<c:set var="fac" value="1"/>
<c:forEach var="i" begin="1" end="7" step="1" >
	<c:set var="fac" value="${fac*i }"/>
</c:forEach>
결과값 : ${fac }
</body>
</html>