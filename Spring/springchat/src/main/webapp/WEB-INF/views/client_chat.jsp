<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
	if(session.getAttribute("id") == null){
		out.print("<script>location.href='loginForm.do'</script>");
	}
	String name = (String)session.getAttribute("name");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var log =  function(s) {
		document.getElementById("output").textContent += (s + "\n");
	}
	w = new WebSocket("ws://localhost:8800/springchat/broadcasting?name=<%=name%>");
	w.onopen = function() { //on:명시적으로 호출되는 문장이 없고 해당관련된 액션이 실행됨
		alert("Websocket Connected!!!");
	
	}
	w.onmessage = function(e) {
		log(e.data.toString());
	}
	w.onclose = function(e) {
		log("WebSocket closed!!!");
	}
	w.onerror = function(e) {
		log("webSocket error!!!");
	}
	
	window.onload = function(){
		document.getElementById("send_button").onclick = function(){
				var input = document.getElementById("input").value;
				w.send(<%=name %> + "> " + input);
				
				document.getElementById("input").value = "";
				
				//.send 서버로 전송할때 사용되는 메소드 ->SocketHandler에서 handleMessage메소드관련
			}
	}
</script>


</head>
<body>
	<input type ="text" id="input" placeholder = "input message..." size ="55">
	<button id="send_button">Send</button>
	대화명 : <%=name %>
<p />
	<textarea  id = "output" readonly rows="30" cols="80"></textarea>
</body>
</html>