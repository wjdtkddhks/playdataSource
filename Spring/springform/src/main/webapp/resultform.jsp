<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 : <%=request.getAttribute("id") %><br/>
비밀번호 : <%=request.getAttribute("pw") %><br/>

아이디 : ${id }<br/>
비밀번호 : ${pw }<br/>

<%
	ArrayList<String> list = (ArrayList<String>)request.getAttribute("list");
	for(int i=0; i<list.size(); i++){
%>
	<b><%=list.get(i) %></b>
<% 		
	}
%>
</body>
</html>