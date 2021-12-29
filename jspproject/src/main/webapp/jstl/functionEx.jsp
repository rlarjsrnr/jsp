<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL에서 제공하는 EL함수</title>
</head>
<body>
<c:set var="str1" value="Function<태그>를 사용합니다.&nbsp;"/>
<c:set var="str2" value="사용"/>
<c:set var="tokens" value="1,2,3,4,5,6,7,8,9,10"/>

length(str1) : ${fn:length(str1) } <br><br>
toUpperCase(str1) : ${fn:toUpperCase(str1) }<br><br>
toLowerCase(str1) : ${fn:toLowerCase(str1) }<br><br>
substring(str1, 3, 6) = ${fn:substring(str1,3,6) }<br><br>
substringAfter(str1, str2) : ${fn:substringAfter(str1,str2) }<br><br>			<%--str1에서 str1에 포함되어 있는 str2 이후의 문자열을 추출 --%>
substringBefore(str1, str2) : ${fn:substringBefore(str1,str2) }<br><br>			<%--str1에서 str1에 포함되어있는 str2 이전의 문자열을 추출 --%>
trim(str1) : ${fn:trim(str1) }<br><br>
replace(str1,src,dest) : ${fn:replace(str1," ","-") }<br><br>			<%-- src:원본 dest: 복사본 --%>
indexOf(str1, str2) : ${fn:indexOf(str1,str2) }<br><br>						<%--str1에서 str2가 처음으로 나오는 인덱스값 --%>

startsWith(str1, str2) : ${fn:startsWith(str1, str2) }<br><br>				<%--str1이 str2로 시작하면 true, 아니면 false --%>
endsWith(str1, str2) : ${fn:endsWith(str1,str2) }<br><br>					<%--str1이 str2로 끝나면 true, 아니면 false --%>

contains(str1, str2) : ${fn:contains(str1, str2) }<br><br>							<%-- str1에 str2가 포함되어 있으면 true, 아니면 false --%>
containsIgnoreCase(str1,str2) : ${fn:containsIgnoreCase(str1,str2) }<br><br>		<%--str1에 str2가 대소문자 구분없이 포함되어 있는지의 여부 --%>

<c:set var="array" value="${fn:split(tokens, ',')}"/>					<%-- 토큰들을 ,(쉼표)로 구분 --%>
join(arrya,"-") : ${fn:join(array,"-") }<br><br>
escapeXml(str1) : ${fn:escapeXml(str1) }<br><br>

</body>
</html>