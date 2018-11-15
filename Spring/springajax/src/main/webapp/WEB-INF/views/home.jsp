<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style type="text/css">
		form{
			width: 500px;
			margin: 10px auto;
		}
		ul{
			padding: 0;
			margin: 0;
			list-style: none;
		}
		ul li{
			padding : 0;
			margin : 0 0 10px 0;
		}
		label{
			width: 150px;
			float: left;
		}
		table{
			border: 1px solid gray;
			width: 500px;
			margin: 0 auto;
			border-collapse: collapse;
		}
		td{
			border: 1px solid gray;
			text-align: center;
		}
	</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js" ></script>
<script>
	$(document).ready(function(){
		
		function selectData(){
			
			$('#output').empty();
			
			$.ajax({
				url: '/springajax/getPeopleJSON.do',
				type: 'POST',
				dataType: 'json',
				contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
				success: function(data){
					$.each(data, function(index, item){
						var output = '';
						output += '<tr>';
						output +='<td>' + item.id + '</td>';
						output +='<td>' + item.name + '</td>';
						output +='<td>' + item.job + '</td>';
						output +='<td>' + item.address + '</td>';
						output +='<td>' + item.bloodtype + '</td>';
						output +='</tr>';
						console.log('output : ' + output);
						$('#output').append(output);
					});	
				},
				error: function() {alert('ajax 통신실패');}
			});
		}
		
		$('#input_data').click(function(event){
			var params = $('#insert_form').serialize();
			alert(params);
			jQuery.ajax({
				url : '/springajax/insertPerson.do',
				type : 'POST',
				data : params,
				contentType : 'application/x-www-form-urlencoded; charset=utf-8',
				dataType : 'json',
				success : function(retVal){
					if(retVal.res == "OK"){
						selectData();
						$('#id').val(' ');
						$('#name').val(' ');
						$('#job').val(' ');
						$('#address').val(' ');
						$('#bloodtype').val(' ');
					}else{
						alert('Insert fail');
					}
				},
				error : function(){alert('ajax통신 실패!!!');}
			});
		});
		selectData();
	});
</script>
</head>
<body>
<form id='insert_form' method='post'>
	<fieldset>
		<legend>데이터추가</legend>
		<ul>
			<li><label for='id'>아이디</label><input type='text' id='id' name='id'></li>
			<li><label for='name'>이름</label><input type='text' id='name' name='name'></li>
			<li><label for='job'>직업</label><input type='text' id='job' name='job'></li>
			<li><label for='address'>주소</label><input type='text' id='address' name='address'></li>
			<li><label for='bloodtype'>혈액형</label><input type='text' id='bloodtype' name='bloodtype'></li>
			<li><input type='button' value='추가' id='input_data' /></li>
		</ul>
	</fieldset>
</form>
<table id='output' ></table>
</body>
</html>
