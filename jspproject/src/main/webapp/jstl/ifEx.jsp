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

<c:if test="${3 > 4 }">
이 내용을 화면에 나타나지 않음(틀렸으니까) true일 경우에 여기있는 내용을 출력
</c:if>

<c:if test="${param.type eq 'guest' }">
홈페이지 방문을 환영하지만 아직 회원이 아닙니다<br><br>
빠른 가입 부탁드립니다.<br><br>
즐거운 하루 보내세요.
</c:if>

<c:if test="${param.type eq 'member' }">
우리 회원님의 홈페이지 방문을 환영합니다.<br><br>
즐거운 하루 보내세요<br><br>
</c:if>

</body>
</html>