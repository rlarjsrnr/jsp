<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@ include file="view/color.jspf"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시판 </title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">

function check() {
	if(document.find_frm.find_box.value==""){
		alert("검색어입력")
	return false;
	}
}

function frm_sub(i) {
	i_frm.action="/jspproject/board/list.de?pageNum="+i;
	i_frm.submit();
	
}
</script>

</head>
<body bgcolor = "${ bodyback_c}">
<div align="center"><b>글 목록(전체 글 :"${count}")</b>

<table width="700">
	<tr>
	
	<td align="right" bgcolor="${value_c}">
		<a href="/jspproject/board/list.de">글목록</a></td>
		
		<td align="right" bgcolor="${value_c}">
		<a href="/jspproject/board/writeForm.de">글쓰기</a></td>
	</tr>
</table>
<c:if test="${count==0 }">



<table width="700" border="1" cellpadding="0" cellspacing="0">
	<tr align="center">
		<td>게시판에 저장된 글이 없습니다.</td>
	</tr>
</table>
</c:if>

<c:if test="${count>0 }">


<table width="700" border="1" cellpadding="0" cellspacing="0" align="center">

	<tr height="30" bgcolor="${value_c}">
		<td align="center" width="50">번호</td>
		<td align="center" width="250">제목</td>
		<td align="center" width="100">작성자</td>
		<td align="center" width="150">작성일</td>
		<td align="center" width="50">조회</td>
		<td align="center" width="100">IP</td>
	</tr>
	

<c:forEach var="article" items="${articleList}">


	<tr height="30">
		<td align="center" width="50">
		<c:out value="${number}"/>
		<c:set var="number" value="${number-1 }"/>
		</td>
		
		<td width="250">
			
		
		<c:if test="${article.depth >0 }">
	
				<img src="../img/level.gif" 
				width="${5*article.depth}" height="16">
				<img src="../img/re.gif">
				</c:if>	
				
				<c:if test="${article.depth == 0}">
				
				<img src="../img/level.gif" 
				width="${5*article.depth}" height="16">
				</c:if>	
				
				

			<a href="/jspproject/board/content.de?num=${article.num}&pageNum=${currentPage}">
			${article.num}</a>
				
				<c:if test="${article.readcount >=20}">
				<img alt="" src="images/hot.gif" border="0" height="16">
				</c:if>
			
		</td>
		<td align="center" width="100">
			<a href="mailto:${article.email}">
			${article.writer}
			</a>
		</td>
		<td align="center" width="150">
			${article.regdate}
		</td>
		<td align="center" width="50">
			${article.readcount}
		</td>
		<td align="center" width="100">
			${article.ip}
		</td>
	</tr>
	</c:forEach>
</table>
</c:if>

<!-- 페이징 처리 -->

<c:if test="${count > 0  }">

<c:set var="imsi" value="${count % pageSize == 0?0:1 }"/>
<c:set var="pageCount" value="${count / pageSize + imsi }"/>
<c:set var="pageBlock" value="${3}"/>
<fmt:parseNumber var="result" 
value="${(currentPage - 1)/ pageBlock }" integerOnly="true"/>


<c:set var="startPage" value="${result * pageBlock + 1 }"/>
<c:set var="endPage" value="${startPage + pageBlock - 1 }"/>


<c:if test="${endPage > pageCount }">
	<c:set var="endPage" value="${pageCount}"/>
</c:if>


<c:if test="${startPage > pageBlock}">
	<a href="/jspproject/board/writeForm.de?pageNum=${startPage - pageBlock }" 
	onclick="frm_sub(${startPage- pageBlock})">[이전]</a>
</c:if>

<c:forEach var="i" begin="${startPage }" end="${endPage }">
	<a href="/jspproject/board/writeForm.de?pageNum=${i}"onclick="frm_sub">[${i}]</a>

</c:forEach>




<c:if test="${endPage > pageCount}">
	<a href="/jspproject/board/writeForm.de?pageNum=${startPage + pageBlock }"
	onclick="frm_sub(${startPage- pageBlock})">[다음]</a>
</c:if>
</c:if>
<br><br>

<form method="post" name="i_frm">
	<input type="hidden" name="find_box" value="${find_box }">
	<input type="hidden" name="find" value="${find}">
</form>

<form action="/jspproject/board/list.de" method="post" name="find_frm"
onsubmit="return_check()">

<select name="find" size="1">
<option value="writer">이름</option>
<option value="subject">제목</option>
<option value="content">내용</option>
</select>
&nbsp;
<input type="text" name="find_box">
&nbsp;
<input type="submit" value="검색">



</form>



</div>


</body>
</html>