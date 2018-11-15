<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

/* Button used to ppen the contact form - fixed at the bottom of the page */
.open-button {
  background-color: #555;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 23px;
  right: 28px;
  width: 280px;
}

/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  bottom: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}
</style>
<script>
	var log = function(s) {
		document.getElementById("output").textContent += (s + "\n");
	}
	
	w = new WebSocket("ws://localhost:8800/naonnaTest/broadcasting");
	
	w.onopen = function() {
		log("상담을 시작합니다.");
	}
	
	w.onmessage = function(e) {
		log(e.data.toString());
	}
	
	w.onclose = function(e) {
		log("WebSocket closed");
	}
	
	w.onerror = function(e) {
		log("Websocket Error!!");
	}
	
	window.onload = function() {
		document.getElementById("send_button").onclick = function() {
			if("${param.sessionNick}" == "") {
				alert("로그인이 필요합니다.")
			}
			else {
				var nickname = "${param.sessionNick}";
				var input = document.getElementById("input").value;
				w.send(nickname+">  "+input);
			}
		}
	}
	
	
	function openForm() {
	    document.getElementById("myForm").style.display = "block";
	}

	function closeForm() {
	    document.getElementById("myForm").style.display = "none";
	}
</script>
</head>
<body>


<button class="open-button" onclick="openForm()">Open Form</button>

<div class="form-popup" id="myForm">
  <div class="form-container">
    <textarea id="output" readonly rows="30" cols="80"></textarea>
	<p>
    <input type="textarea" id="input" placeholder="input message..." size="55">
	<button id="send_button">Send</button>
	</p>
  </div>
</div>

</body>
</html>