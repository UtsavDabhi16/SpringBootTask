<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page </title>
<link href="<@spring.url 'views/css/util.css' />" rel="stylesheet">
<link href="<@spring.url 'views/css/main.css' />" rel="stylesheet">
<link href="<@spring.url 'views/css/custom.css' />" rel="stylesheet">
</head>
<body>
	<!-- Include the Header file -->
	
	<#include "header.ftl">
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form  p-l-55 p-r-55 p-t-178" name="userlogin"
					method="get" action="loginController">
					<span class="login100-form-title"> Sign In </span>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter username">
						<input class="input100" type="text" name="uemail" 
							placeholder="Enter Your Email"> <span id="emailerror"
							style="color: red"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Please enter password">
						<input class="input100" type="password" name="upassword"
							 placeholder="Password"> <span
							id="passworderror" style="color: red"></span>
					</div>

					
					<div class="text-right p-t-13 p-b-23">
						<span class="txt1"> Forgot </span> <a href="forgotpassword"
							class="txt2"> Password? </a>
					<span class="txt1"> Reset </span> <a href="resetPassword"
						class="txt2"> Password? </a>
					</div>


					<div class="container-login100-form-btn">
						<button class="login100-form-btn" type="submit">Sign in</button>
					</div>

					<div class="flex-col-c p-t-70 p-b-30">
					<span class="txt1 p-b-9"> Don't have an account? </span> <a
							href="registration" class="txt3"> Sign up now </a>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- JavaScript File -->
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
	<script src="<@spring.url 'views/vendor/jquery/jquery-3.2.1.min.js' />"> </script>
	<script src="<@spring.url 'views/vendor/jquery/formToJson.js' />"> </script>
	<script src="<@spring.url 'views/vendor/animsition/js/animsition.min.js' />"> </script>
	<script src="<@spring.url 'views/vendor/bootstrap/js/popper.js' />"> </script>
	<script src="<@spring.url 'views/vendor/bootstrap/js/bootstrap.min.js' />"> </script>
	<script src="<@spring.url 'views/vendor/select2/select2.min.js' />"> </script>
	<script src="<@spring.url 'views/vendor/daterangepicker/moment.min.js' />"> </script>
	<script src="<@spring.url 'views/vendor/daterangepicker/daterangepicker.js' />"> </script>
	<script src="<@spring.url 'views/vendor/countdowntime/countdowntime.js' />"> </script>
	<script src="<@spring.url 'views/js/login.js' />"> </script>
	
	<!-- Include the Footer file   -->
	<#include "footer.ftl">
	
</body>
</html>