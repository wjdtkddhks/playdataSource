<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" contentType="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
id : ${id }<br/>
pw : ${pw }<br/>

id : <%=request.getParameter("id") %><br/>
pw : <%=request.getParameter("pw") %><br/>
</body>
</html>