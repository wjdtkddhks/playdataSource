<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js" ></script>
<script>
	$(document).ready(function(){
		
		function selectData(){
			
			$('#output').empty();
			
			$.ajax({
				url: '/croling/croling.do',
				type: 'POST',
				dataType: 'json',
				contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
				success: function(data){
					$.each(data, function(index, item){
						var output = '';
						output +='<div><a href="' + item.url + '">'+ item.title + '</a></div>';
						output +='<div>' + item.content + '</div><br/>';
						console.log('output : ' + output);
						$('#output').append(output);
					});	
				},
				error: function() {alert('ajax 통신실패');}
			});
		}
		
		selectData();
	});
</script>
</head>
<body>
<div id='output' ></div>
</body>
</html>

