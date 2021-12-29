<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check == 1 }">
<meta http-equiv="Refresh" content="0; url=/jspproject/board/list.de?pageNum=${pageNum}">
</c:if>

<c:if test="${check == 0 }">
비밀번호가 틀립니다. 다시입력하세요.<br>
<a>[글 수정 폼으로 돌아가기]</a>
<a href="javascript:history.go(-1)">[글 수정 폼으로 돌아가기]</a>
</c:if>