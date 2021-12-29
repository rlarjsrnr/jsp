<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
 // pageContext Scope에 속성 저장하기(해당 JSP 페이지 내에서만 유포함)
pageContext.setAttribute("pageAttrubute", "김씨"); 
// pageContext.setAttribute("pageAttrubute", "김씨",pageContext.PAGE_SCOPE);

// requestScope에 저장함
request.setAttribute("requestAttribute", "010-0000-0000");   
// pageContext.setAttribute("requestAttribute", "010-0000-0000",PageContext.REQUEST_SCOPE);

// session Scope 에 속성을 저장함
session.setAttribute("sessionAttribute", "kim@naver.com");
// pageContext.setAttribute("requestAttribute", "kim@naver.com",PageContext.session_SCOPE);

//application Scope 
application.setAttribute("applicationAttribute", "글로벌인");
//pageContext.setAttribute("applicationAttribute", "글로벌인",PageContext.session_SCOPE);
    
   %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<ul>
		<li>이름: <%=pageContext.getAttribute("pageAttrubute")%></li>
		<li>전번: <%=request.getAttribute("requestAttribute")%></li>
		<li>메일: <%=session.getAttribute("sessionAttribute")%></li>
		<li>회사: <%=application.getAttribute("applicationAttribute")%></li>

</ul>



</body>
</html>