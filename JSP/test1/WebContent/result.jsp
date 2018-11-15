<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% request.setCharacterEncoding("utf-8");
 		String id = request.getParameter("id");
 		String name = request.getParameter("name");
 		String url = request.getParameter("url");
 		String email = request.getParameter("email");
 
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
id = <%=id %> <br/>
name = <%=name %><br/>
<img src='<%=url %>' /><br/>
email = <%=email %>
</body>
</html>