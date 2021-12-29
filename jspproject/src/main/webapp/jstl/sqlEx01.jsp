<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<sql:query var="rs" dataSource="jdbc/mydb">				<%-- dataSource : 서버 context에 보면 Resouce/data의 jdbc/mydb 를 의미한다 --%>
select * from tempmember
</sql:query>

<table border="1">
	<tr>		<%--필드명 --%>
		<c:forEach var="columnName" items="${rs.columnNames }">
			<th><c:out value="${columnName }"/></th>
		</c:forEach>
	</tr>
	
	<c:forEach var="row" items="${rs.rowsByIndex }">			<%--레코드(행) 수만큼 반복수행 처리 --%>
		<tr>		<%-- 레코드 필드 수만큼 반복 --%>
			<c:forEach var="column" items="${row }" varStatus="i">
					<td>	
						<c:if test="${column != null }"><c:out value="${column }"/></c:if><%--해당 필드값이 null이 아닌경우--%>
						<c:if test="${column == null }"><c:out value=""/>&nbsp;</c:if><%--해당 필드값이 null인 경우 공백을 출력--%>	
					</td>
			</c:forEach>
		</tr>
	</c:forEach>
</table>
</body>
</html>