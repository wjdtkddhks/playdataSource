<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="java.util.*" %>
<%@ page import = "com.spring.springmember.MemberVO" %>

<%
	ArrayList<MemberVO> member_list = (ArrayList<MemberVO>)request.getAttribute("MemberList");
	
	if ((session.getAttribute("id")==null) || 
	  (!((String)session.getAttribute("id")).equals("admin"))) {
		out.println("<script>");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");
	}
	
 	if(request.getAttribute("changeMember") != null){
		String changeMember = (String)request.getAttribute("changeMember");
 		if(changeMember.equals("deleteSuccess")){
%>
			<script>
				alert('삭제에 성공하였습니다.');
	  		</script>
<%
 		}else if(changeMember.equals("updateSuccess")){
%>
 			<script>
 				alert('수정에 성공하였습니다.');
 			</script>
<%
 		}}
%>
<html>
<head>
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
</head>
<body>
<center>
<table border=1 width=300>
	<tr align=center><td colspan=3>회원 목록</td></tr>
<%
	for (int i=0; i<member_list.size(); i++)
	{
		MemberVO memberVO = (MemberVO)member_list.get(i);
	
%>
	<tr align=center>
		<td>
			<a href="member.mo?method=selectMember&id=<%=memberVO.getId() %>">
				<%=memberVO.getId() %>
			</a>
		</td>
		<td><a href="member.mo?method=deleteMember&id=<%=memberVO.getId() %>">삭제</a></td>
		<td><a href="member.mo?method=updateForm&id=<%=memberVO.getId() %>">수정</a></td>
	</tr>
<%
	} 
%>
</table>
</center>
</body>
</html>
