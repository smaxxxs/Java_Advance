<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <html xmlns="http://www.w3.org/1999/xhtml" 
    xmlns:th="http://www.thymeleaf.org" 
    xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">


<head>
<title>AdvLes19</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>

<body>
	


			<div>
				<h3>Create new Student</h3>

				<form method ="post" action ="upload" enctype="multipart/form-data">
					First Name: <input name= "firstName" type = "text" required /><br>
					Second Name:<input name= "secondName" type = "text" required /><br>
					Your age: <input name= "age" type = "text" required /><br>
					Your Photo<input  type="file" name="file" required /><br>
					<button type="submit" >Save</button>
				</form>


			</div>



</body>
</html>