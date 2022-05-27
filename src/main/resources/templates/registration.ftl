<#import "/spring.ftl" as spring />
<html>
<head>

<meta charset="ISO-8859-1">
<title>Register Page</title>

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
				<form class="login100-form  p-l-55 p-r-55 p-t-178" name="register"
					action="register" method="post">
					<span class="login100-form-title"> Sign UP User </span>
	 				<input type="hidden" name="assign[0].id" value="1">
	 				<#if validerror??><span class="error">${validerror?join("<br>")}</span></#if>
					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter First Name">
						<input class="input100" type="text" name="FirstName"
							id="firstname" Placeholder="Enter your First Name"> <span
							id="fnameerror" style="color: red"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter Last Name">
						<input class="input100" type="text" name="LastName" id="lastname"
							Placeholder="Enter your Last Name"> <span id="lnameerror"
							style="color: red"></span>
					</div>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter username">
						<input class="input100" type="text" name="email" id="email"
							Placeholder="abc@gmail.com"> <span id="result"
							style="color: green"></span> <span id="emailerror"
							style="color: red"></span>

					</div>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter phoneno">
						<input class="input100" type="text" name="PhoneNo" id="phoneno"
							Placeholder="Phoneno"> <span id="emailerror"
							style="color: red"></span>
					</div>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter birthdate">
						<input class="input100" type="date" name="Dob"
							id="birthdaydate">
					</div>

					<div class="wrap-input100 validate-input m-b-16">
						<label class="m-l-12" for="customer-gender">Gender : -</label> <label
							for="male" class="gender-size">Male</label> <input class="m-l-4"
							type="radio" id="male" name="gender" value="Male"> <br>
						<label class="gender-size m-l-85" for="female">Female</label> <input
							type="radio" id="female" name="gender" value="Female">
					</div>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter phoneno">
						<input type="text" id="sanswer" class="input100" name="SecurityAnswer"
							Placeholder="Enter your Security Answer"> <span
							id="serror" style="color: red"></span>
					</div>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter password">
						<input class="input100" type="password" name="Password"
							id="password" Placeholder="******"> <span id="perror"
							style="color: red"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter password">
						<input class="input100" type="password" name="CPassword"
							id="cpassword" Placeholder="******"> <span id="cperror"
							style="color: red"></span>
					</div>

					<div id="main-container" class="content">
						<div class="row group container-item">

							<div class="col-md-12 m-b-12 m-t-12">
								<input class="input100 AddLineOne" type="text"
									name="address[0].AddressLineOne" Placeholder="AddressLine One"> <span
									class="AddressLineOneError"></span>
							</div>
							<div class="col-md-12 m-b-12">
								<input class="input100 AddLineTwo" type="text"
									name="address[0].AddressLineTwo" Placeholder="AddressLine Two"> <span
									class="AddressLineTwoError"></span>
							</div>

							<div class="col-md-12 m-b-12">
								<input type="text" name="address[0].pincode" class="input100 pin"
									maxlength="6" Placeholder="Pincode"> <span
									class="PinError"></span>
							</div>
							<div class="col-md-12 m-b-12">
								<input type="text" class="input100 city" name="address[0].city"
									maxlength="64" Placeholder="City"> <span
									class="CityError"></span>
							</div>
							<div class="col-md-12 m-b-12">
								<input type="text" class="input100 state" name="address[0].state"
									maxlength="64" Placeholder="State"><span
									class="StateError"></span>
							</div>
							<div class="row">
                                    <div class="col-sm-12 m-b-12">
                                        <div>
                                            <a href="javascript:void(0)" class="remove-item btn btn-sm btn-danger remove-social-media">Remove</a>
                                        </div>
                                    </div>
                            </div>

						</div>
					</div>
					
					<div class="row">
                         <div class="col-sm-12">
 							<div>
                      			  <a class="btn btn-success btn-sm" id="add-more" href="javascript:;" role="button"><i class="fa fa-plus"></i> Add more address</a>                    
                   		    </div>
                   		 </div>
                    </div>

					<div class="container-login100-form-btn m-b-32 m-t-16">
						<button class="login100-form-btn" type="submit">Submit</button>
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
	<script src="<@spring.url 'views/js/registervalidation.js' />"> </script>
	<script src="<@spring.url 'views/js/cloneData.js' />"> </script>
	<script src="<@spring.url 'views/js/AddressPlugin.js' />"> </script>
	
	<!-- Include the Footer file -->
	<#include "footer.ftl">
</body>
</html>