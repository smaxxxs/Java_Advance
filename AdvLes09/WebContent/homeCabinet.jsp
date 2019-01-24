<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"	href="css/card.css">
</head>
<body>
<script src="js/home.js"></script>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
		
						<h1>Hello ${userName}!!!</h1>
						<div class="card text-center">
  
  <div class="card-body" id="magazineCards">
    <h5 class="card-title">${product.name}</h5>
    <p class="card-text">>${product.price}</p>
    <a href="#" class="btn btn-primary">${product.description}</a>
  </div>
  
</div>
			
					
				
				
</body>
</html>