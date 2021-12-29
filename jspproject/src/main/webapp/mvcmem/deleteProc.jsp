<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="mvcmem.model.StudentDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" content="3; url=member.mdo?cmd=login">
<title></title>
</head>
<body>
<c:set var="result" value="${result }"/>
<div align="center">
   <font size="5" face="궁서체">
   <c:if test="${result eq 0 }">
      <script type="text/javascript">
      alert("비밀번호가 틀렸습니다.");
      history.go(-1);
      </script>
      </c:if>
   회원탈퇴가 정상적으로 처리되었습니다.<br><br>멀리 안나갑니다~<br><br><br>3초 후 로그인 페이지로 이동합니다.</font>
</div>
</body>
</html>