<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Magazines Logined as ${userName}</title>

<link rel="stylesheet" type="text/css" href="css/myCabinet.css" />
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
 <link rel="stylesheet"	href="css/card.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script><script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<script src="js/myCabinet.js"></script>
<script src="js/header.js"></script>
<!-- ---- Include the above in your HEAD tag -------- -->
<jsp:include page="header.jsp"></jsp:include>
    <div id="wrapper">
        <div class="overlay"></div>
    
        <!-- Sidebar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
            <ul class="nav sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                       My menu
                    </a>
                </li>
                <li>
                    <a href="myCabinet.jsp">Home</a>
                </li>
                <li>
                    <a href="#">About project     empty item</a>
                </li>
              
                <li>
                    <a href="#">Team</a>
                </li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Works empty item <span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                    <li class="dropdown-header">Dropdown heading</li>
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li><a href="#">Separated link</a></li>
                    <li><a href="#">One more separated link</a></li>
                  </ul>
                </li>
                <li>
                    <a href="myCabinetAddMagazine.jsp">new Magazine</a>
                </li>
                <li>
                   <a href="myCabinetBucket.jsp">my Bucket</a>
                </li>
                
            </ul>
        </nav>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <button type="button" class="hamburger is-closed" data-toggle="offcanvas">
                <span class="hamb-top"></span>
    			<span class="hamb-middle"></span>
				<span class="hamb-bottom"></span>
            </button>
            <div class="container">
                <div class="row">
                
                    <div class="col-lg-8 col-lg-offset-2">
                       						<div class="card text-center">
  
  <div class="card-body area" id="magazineCards">
    <p class="card-title">${product.name}</p>
    <p class="card-text">${product.price} uah</p>
   
    <button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#buyProductModal">buy product</button>
  </div>
  
  <!-- Modal -->
	<div class="modal fade" id="buyProductModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Confirmation</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					Are You sure that You want to buy this product?
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cancel</button>
					<button type="button" product-id="${product.id}"  class="btn btn-primary buy-product">Buy</button>
				</div>
			</div>
		</div>
	</div>
</div>
						
						</div>
						
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
<script src="js/serverCalls.js"></script>
</body>
</html>