<#import "/spring.ftl" as spring />
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="<@spring.url 'views/css/main.css' />" rel="stylesheet">
<link href="<@spring.url 'views/css/util.css' />" rel="stylesheet">
<link href="<@spring.url 'views/css/custom.css' />" rel="stylesheet">
<link href="<@spring.url 'views/fonts/font-awesome-4.7.0/css/font-awesome.min.css' />" rel="stylesheet">
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
				<form class="login100-form  p-l-55 p-r-55 p-t-178"
					action="resetPasswordController" method="get" name="resetpassword">
					<span class="login100-form-title"> Reset Password </span>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter Old password">
						<input class="input100" type="password" name="oldPassword"
							id="oldpassword" placeholder="Enter Your Old Password">
					</div>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter password">
						<input class="input100" type="password" name="newPassword"
							id="newpassword" placeholder="Enter Your New Password"> <span
							id="passworderror" style="color: red"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter password">
						<input class="input100" type="password" name="CPassword"
							id="cpassword" placeholder="Enter Your Confirm New Password">
						<span id="passworderror" style="color: red"></span>
					</div>

					<div class="container-login100-form-btn m-b-32">
						<button class="login100-form-btn" type="submit">Save</button>
					</div>

				</form>
			</div>
		</div>
	</div>
	

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
	<script src="<@spring.url 'views/vendor/jquery/jquery-3.2.1.min.js' />"> </script>
	<script src="<@spring.url 'views/vendor/jquery/formToJson.js' />"> </script>
	<script src="<@spring.url 'views/vendor/jquery/jquery.validate.min.js' />"> </script>
	<script src="<@spring.url 'views/vendor/animsition/js/animsition.min.js' />"> </script>
	<script src="<@spring.url 'views/vendor/bootstrap/js/popper.js' />"> </script>
	<script src="<@spring.url 'views/vendor/bootstrap/js/bootstrap.min.js' />"> </script>
	<script src="<@spring.url 'views/vendor/select2/select2.min.js' />"> </script>
	<script src="<@spring.url 'views/vendor/daterangepicker/moment.min.js' />"> </script>
	<script src="<@spring.url 'views/vendor/daterangepicker/daterangepicker.js' />"> </script>
	<script src="<@spring.url 'views/vendor/countdowntime/countdowntime.js' />"> </script>
	<script src="<@spring.url 'views/js/resetPassword.js' />"> </script>
	
	<!-- Include the Footer file -->
	<#include "footer.ftl">
</body>
</html>