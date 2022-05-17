<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
<#include "css/util.css">
<#include "css/main.css">
<#include "images/icons/favicon.ico">
<#include "vendor/bootstrap/css/bootstrap.min.css">
<#include "vendor/bootstrap/css/bootstrap.min.css">
<#include "vendor/animate/animate.css">
<#include "vendor/css-hamburgers/hamburgers.min.css">
<#include "vendor/animsition/css/animsition.min.css">
<#include "vendor/select2/select2.min.css">
<#include "vendor/daterangepicker/daterangepicker.css">
</style>
</head>
<body>
<!-- Include the Header file -->
<#include "header.ftl">
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form  p-l-55 p-r-55 p-t-178" action="ForgotPasswordController" method="get"
					name="forgotpassword">
					<span class="login100-form-title"> Forgot Password </span>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter username">
						<input class="input100" type="text" name="email"
							id="useremail" placeholder="Enter Your Email">
					</div>
					 <span id="emailerror" style="color: red"></span>


					<div class="wrap-input100 validate-input m-b-16">
						<input type="text" id="userphoneno" class="input100"
							name="phoneNo" aria-required="true" placeholder="1234567890">
					</div>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter secutiry answer">
						<input type="text" id="useranswer"
							class="input100" name="SecurityAnswer"
							placeholder="Enter Your Programming Language Answer">
						<span id="serror" style="color: red"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter password">
						<input class="input100" type="password" name="NPassword"
							id="newpassword" placeholder="Enter Your New Password"> <span
							id="passworderror" style="color: red"></span>
					</div>

					<div class="container-login100-form-btn m-b-32">
						<button class="login100-form-btn"  type="submit">Save
						</button>
					</div>

				</form>
			</div>
		</div>
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
<#include "vendor/jquery/jquery-3.2.1.min.js">
<#include "vendor/jquery/jquery.validate.min.js">
<#include "vendor/animsition/js/animsition.min.js">
<#include "vendor/bootstrap/js/popper.js">
<#include "vendor/bootstrap/js/bootstrap.min.js">
<#include "vendor/select2/select2.min.js">
<#include "vendor/daterangepicker/moment.min.js">
<#include "vendor/daterangepicker/daterangepicker.js">
<#include "vendor/countdowntime/countdowntime.js">
</script>
	<script>
	<#include "js/forgotpassword.js">	
	</script>

	<!-- Include the Footer file -->
<#include "footer.ftl">
</body>
</html>