<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>HOME</title>
</head>
<body>
<h1>Hello world!</h1>

<p> The time on the server is <%=request.getAttribute("serverTime") %>. </p>
<p> The time on the server is ${serverTime }. </p>
</body>
</html>