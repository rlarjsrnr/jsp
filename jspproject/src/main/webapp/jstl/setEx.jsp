<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>			<%-- 코어를 접두사(prefix)로 선언하면 코어에 따른 객체를 사용할 수 있다 --%>

<jsp:useBean id="vo" class="jstl.MemberVO"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%--target : 프로퍼티(property)값을 설정할 대상 객체를 지정
 property : 설정할 프로퍼티(property) 이름을 지정
 value : 프로퍼티(property)의 값을 지정  
--%>
<c:set target="${vo }" property="name" value="홍길동"></c:set>			<%--방법1 : MemberVO클래스의 ID인 vo에서 그중 name속성을 설정 --%>
<c:set target="${vo }" property="email" value="@naver.com"></c:set>
<c:set target="${vo }" property="age" value="20"></c:set>

<c:set var="age" value="30"></c:set>			<%-- 방법2 : 변수이름을 age로 지정하여 값을 30으로 지정 --%>
<c:set target="${vo }" property="age" value="${age }"/>		<%-- 방법3 --%>

<h3>회원 정보</h3>
<ul>
	<li>이름 : ${vo.name }</li>
	<li>메일 : ${vo.email }</li>
	<li>나이 : ${vo.age }</li>
</ul>
</body>
</html>