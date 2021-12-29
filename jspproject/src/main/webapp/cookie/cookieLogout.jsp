<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    Cookie[] cookies = request.getCookies();
    
    if(cookies != null){
    	for(int i = 0; i< cookies.length; i++){
			if(cookies[i].getName().equals("memId")){
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
    		
    	}
    	
    }
    
    
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
alert("로그아웃 성공");
</script>
</body>
</html>