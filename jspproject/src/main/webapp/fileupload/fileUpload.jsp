<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ page import="com.oreilly.servlet.MultipartRequest"%>
   <%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
    <%@ page import="java.util.*" %>
    
    
    <%
    
    String uploadPath = request.getRealPath("upload");
    
    int size = 10*1024*1024; //10Mbyte
    
    String name = "";
    String subject = "";
    String filename1 = "";// 저장된파일
    String filename2 = "";
    String origfilename1 = ""; //실제파일(사용자가 지정해서 업로드한 원본파일)
    String origfilename2 = "";
    
    try{
    	
    	MultipartRequest multi = 
    			new MultipartRequest(request,uploadPath,
    					size,"utf-8",
    					new DefaultFileRenamePolicy());
    	name = multi.getParameter("name");
    	subject = multi.getParameter("subject");
    	
    	Enumeration files= multi.getFileNames();
    	
    	String file1 = (String)files.nextElement();
    	filename1 = multi.getFilesystemName(file1);
    	origfilename1 = multi.getOriginalFileName(file1);
    	
    	String file2 = (String)files.nextElement();
    	filename2= multi.getFilesystemName(file2);
    	origfilename2 = multi.getOriginalFileName(file2);
    	
    	
    	
    	
    }catch(Exception e){
    	e.printStackTrace();
    }
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form action="fileCheck.jsp" method="post" name="filecheck">
<input type="hidden" name="name" value="<%=name%>">
<input type="hidden" name="subject" value="<%=subject%>">
<input type="hidden" name="filename1" value="<%=filename1%>">
<input type="hidden" name="filename2" value="<%=filename2%>">
<input type="hidden" name="origfilename1" value="<%=origfilename1%>">
<input type="hidden" name="origfilename2" value="<%=origfilename2%>">

</form>


<a href="#" onclick="javascript:filecheck.submit()">
업로드확인및 다운로드</a>
</body>
</html>






