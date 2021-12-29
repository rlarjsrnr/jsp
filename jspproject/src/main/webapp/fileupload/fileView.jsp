<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="com.oreilly.servlet.MultipartRequest,
 com.oreilly.servlet.multipart.DefaultFileRenamePolicy,
 java.util.*, java.io.*" %>   
 
 <%
 String realFolder="";
 String saveFolder="upload";
 String rncType="utf-8";
 int maxSize = 10*1024*1024;
 
 ServletContext context = getServletContext();
 realFolder = context.getRealPath(saveFolder);
 
 ArrayList saveFiles = new ArrayList();
 ArrayList origFile = new ArrayList();
 
 String paramUser="";
 String paramTitle="";
 String paramAbstract="";
 
 try{
	 MultipartRequest multi = new MultipartRequest(request,
			 realFolder, maxSize, rncType, 
			 new DefaultFileRenamePolicy());
	 
	 paramUser = multi.getParameter("txtUser");
	 paramTitle = multi.getParameter("txtTitle");
	 paramAbstract = multi.getParameter("txtAbstract");
	 
	 Enumeration files = multi.getFileNames();
 
	 
	 while(files.hasMoreElements()){
		 
		 String name = (String)files.nextElement();
			
		 saveFiles.add(multi.getFilesystemName(name));
		 origFile.add(multi.getFilesystemName(name));
		 
	 }
 
 
 
 %>   
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<table width ="75%" border="1" align="center" cellpadding="1"
	cellspacing="1" bordercolor="#660000" bgcolor="#FFFF99">


<tr>
 <td width="10%" bgcolor="#FFCC00">
 <div align="right"><strong>user</strong></div>
 </td>
<td width="30%"><%=paramUser %></td>

<td width="10%" bgcolor="#FFCC00">
 <div align="right"><strong>title</strong></div>
 </td>
<td width="30%"><%=paramTitle %></td>

<tr>
<td width="10%" bgcolor="#FFCC00">
 <div align="right"><strong>Abstract</strong></div>
 </td>
<td width="50%" colspan="2">
<textarea row="5" colspan="2"><%=paramTitle %></textarea>
</td>
</tr>

<tr><td colspan="4" bgcolor="#ffffff">&nbsp;</td></tr>

<tr>
<td colspan="4"><strong>업로드 된 파일입니다.</strong></td>
</tr>


	<%for(int i=0; i<saveFiles.size(); i++){%>
<tr>
		<td colspan="4">
		<a href="<%="/jspproject/"+saveFolder+"/"+saveFiles.get(i)%>">
		<strong><%=origFile.get(i)%></strong>
		</a>
	</td>
</tr>

<%}%>
</table>
</body>
</html>
 
    

<%
}catch(IOException ioe){
System.out.println(ioe);
}catch(Exception e){
System.out.println(e);
}
%>







