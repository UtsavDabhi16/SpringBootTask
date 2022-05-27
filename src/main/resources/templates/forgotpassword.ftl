<#import "/spring.ftl" as spring />
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password Page</title>
<link href="<@spring.url 'views/css/main.css' />" rel="stylesheet">
<link href="<@spring.url 'views/css/util.css' />" rel="stylesheet">
<link href="<@spring.url 'views/vendor/bootstrap/css/bootstrap.min.css' />" rel="stylesheet">
<link href="<@spring.url 'views/vendor/animate/animate.css' />" rel="stylesheet">
<link href="<@spring.url 'views/vendor/css-hamburgers/hamburgers.min.css' />" rel="stylesheet">
<link href="<@spring.url 'views/vendor/animsition/css/animsition.min.css' />" rel="stylesheet">
<link href="<@spring.url 'views/vendor/select2/select2.min.css' />" rel="stylesheet">
<link href="<@spring.url 'views/vendor/daterangepicker/daterangepicker.css' />" rel="stylesheet">
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
	<script src="<@spring.url 'views/js/forgotpassword.js' />"> </script>


	<!-- Include the Footer file -->
<#include "footer.ftl">
</body>
</html>