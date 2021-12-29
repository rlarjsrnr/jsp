<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    String type = request.getParameter("type");
    if(type != null){ 
    
    
    
    %>
    
    <br>
    
    <table width="400"  border="1" cellpadding="2" cellspacing="0">
    <tr>
    	<td>타입</td><td><b><%=type %></b></td>
    </tr>
    
    <tr>
    <td>특징</td>
    <td>
   	<% if(type.equals("A")) {%>
   	강한내구성
   	<%}if(type.equals("B")) {%>
   	
   	뛰어난 대체능력
   	
   	<% } %>
    </td>
 
    </tr>
    
    </table>
    
    <%}%>
    