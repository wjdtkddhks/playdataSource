<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*, com.spring.springmybatis.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" charset="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function res(){
		location.href="list.do";
	}
</script>
</head>
<body>
<form method="post" action="update.do" >
	<input type="hidden" name="id" id="id" value=${member.id } />
	<table border=1 align="center">
		<tr>
			<td width="80px"> 아이디</td>
			<td>이름</td>
			<td>이메일</td>
			<td>전화번호</td>
		</tr>
		<tr>
			<td>${member.id }</td>
			<td><input type="text" name="name" value="${member.name }" /></td>
			<td><input type="text" name="email" value="${member.email }" /></td>
			<td><input type="text" name="phone" value="${member.phone }" /></td>
		</tr>
		<tr>
			<td colspan=4 align="center">
				<input type="submit" value="수정" /><input type="button" value="리스트" onclick="res();" />
			</td>
		</tr>		
	</table>
</form>
</body>
</html>