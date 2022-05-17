<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Register Page</title>
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
<style>
<#include "css/custom.css">
</style>
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
                                    <div class="col-sm-12">
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

	<!-- 	Default JavaScript Link -->
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
	<!-- Custom JavaScript Link -->
	<script><#include "js/registervalidation.js"></script>

	<script type="text/javascript">
		<#include "js/cloneData.js">
	</script>

	<script type="text/javascript">
		<#include "js/AddressPlugin.js">
	</script>
	<!-- Include the Footer file -->
	<#include "footer.ftl">
</body>
</html>