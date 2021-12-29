<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="view/color.jspf" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor="${bodyback_c }">

<div align="center">
<b>글삭제</b>
<br><br>
<form action="/jspproject/board/deletePro.de?pageNum=${pageNum}" 
onsubmit="return deleteSave()" method="post" name="delForm">

<table width="360" border="1" align="center" cellpadding="0" cellspacing="0">
      <tr height="30">
          <td align="center" bgcolor="${value_c }">
             <b>비밀번호를 입력해 주세요.</b>
          </td>
      </tr>
      
      <tr height="30">
           <td align="center">비밀번호:
               <input type="password" name="pass" size="8" maxlength="12">
               <input type="hidden" name="num" value="${num }">
           </td>
      </tr>
      
      <tr height="30">
          <td align="center" bgcolor="${value_c }">
            <input type="submit" value="글삭제">
            <input type="button" value="글목록" 
        onclick="document.location.href='/jspproject/board/deletePro.de?pageNum=${pageNum}'">
          
          </td>
      </tr>
      

</table>
</form>
</div>
</body>
</html> --%>