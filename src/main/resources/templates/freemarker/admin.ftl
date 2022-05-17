<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>

<!-- TAB icon/Favicon -->
<style><#include "images/icons/favicon.ico"></style>

<!-- BootStrap Link -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="http://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">

<!-- 	Google Font Link -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet">

<!-- 	Custom CSS Link -->
<style>
<#include "css/admin.css">
</style>

<style>
<#include "css/UserDataTable.css">
</style>

</head>

<body>
	
	<!-- Navigation Bar  -->
	
	
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
				<a class="navbar-brand" href="#">Admin Profile</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link"
							href="registration">+User<span class="sr-only">(current)</span></a></li>
						<li class="nav-item active"><a class="nav-link"
							href="AdminLogout">Logout</a></li>
					</ul>

				</div>
			</nav>

			<!-- 	Lists of User Table -->
			<div class="container user">
				<h3 class="list-user">
					<i class="fa fa-users" aria-hidden="true"></i>Lists of Users
				</h3>
				<hr>
			</div>

			<table id="showAllUser" class="display">
				<thead>
					<tr>
						<th>UserId</th>
						<th>FirstName</th>
						<th>LastName</th>
						<th>Email</th>
						<th>PhoneNO</th>
						<th>Birth Date</th>
						<th>Gender</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tr>
				</tr>
			</table>
		

	<!-- 	<button id="mybtn">Click</button> -->


	<!-- jQuery File -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<!--  JS file -->
	<script type="text/javascript" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
	
	<script type="text/javascript">
	<#include "js/showUser.js">
	</script>

	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<!-- Include the Footer file -->
	<#include "footer.ftl">
</body>
</html>