<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>			<%-- 인코딩이 잘 안될 경우에는 이 문장을 추가해준다. --%>
<fmt:setLocale value="jp"/>
<fmt:bundle basename="bundle.testBundle">
<fmt:message key="TITLE" var="title"/>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
</head>
<body>
<fmt:message key="NAME"/><br>
<c:if test="${!empty param.id }">
	<fmt:message key="MESSAGE">
		<fmt:param value="${param.id }"></fmt:param>
	</fmt:message>
</c:if>
</body>
</html>
</fmt:bundle>