$(function() {
	$("form[name='updateuser']").validate({
		rules: {

			FirstName: "required",
			LastName: "required",

			email: {
				required: true,
				email: true
			},

			PhoneNo: {
				required: true,
				digits: true,
				minlength: 10,
				maxlength: 10
			},

			Dob: {
				required: true,
				minAge: 18
			},

			gender: {
				required: true
			},

			SecurityAnswer: {
				required: true
			},

			Password: {
				minlength: 5,
				required: true
			},

			CPassword: {
				minlength: 5,
				required: true,
				equalTo: "#password"
			},

			AddressLineOne: {
				required: true,
			},
			AddressLineTwo: {
				required: true,
			},
			pincode: {
				required: true,
			},
			city: {
				required: true,
			},
			state: {
				required: true,
			},
		},
		messages: {

			FirstName: "Enter Valid First Name",

			LastName: "Enter Valid Last Name",

			email: {
				required: "Please enter your Email",
				email: "The email should be in the format: abc@gmail.com"
			},

			PhoneNo: {
				required: "Please enter phone number",
				digits: "Please enter valid phone number",
				minlength: "Phone number field accept only 10 digits",
				maxlength: "Phone number field accept only 10 digits"
			},

			Dob: {
				required: "Please enter you date of birth.",
				minAge: "You must be at least 18 years old!"
			},

			gender: {
				required: "Please Select Gender"
			},

			SecurityAnswer: {
				required: "Please Enter Your Answer"
			},

			Password: {

				minlength: "Minimum length of Password is Five(5).",
				required: "Password Requried"
			},

			CPassword: {

				minlength: "Confirm Password Minimum length is Five(5).",
				required: "Confirm Password Requried",
				equalTo: "Password Can't Match"
			},
			AddressLineOne: {
				required: "First AddressLine is Required!!"
			},
			AddressLineTwo: {
				required: "Second AddressLine is Required!!"
			},
			pincode: {
				required: "Pincode is Required!!"
			},
			city: {
				required: "City is Required!!"
			},
			state: {
				required: "State is Required!!"
			},

		},

		submitHandler: function(form) {
			form.submit();
		}
	});

	//First Name Validation
	$("#firstname").keypress(function(e) {
		var keyCode = e.keyCode || e.which;

		$("#fnameerror").html("");

		//Regex for Valid Characters i.e. Alphabets and Numbers.
		var regex = /^[A-Za-z]+$/;
		var isValid = regex.test(String.fromCharCode(keyCode));
		if (!isValid) {
			$("#fnameerror").html("Only Alphabets allowed.");
		}
		return isValid;
	});

	//Last Name Validation
	$("#lastname").keypress(function(e) {
		var keyCode = e.keyCode || e.which;

		$("#lnameerror").html("");

		//Regex for Valid Characters i.e. Alphabets and Numbers.
		var regex = /^[A-Za-z]+$/;
		var isValid = regex.test(String.fromCharCode(keyCode));
		if (!isValid) {
			$("#lnameerror").html("Only Alphabets allowed.");
		}
		return isValid;
	});

	//Birth Date Validation
	$.validator.addMethod("minAge", function(value, _elementt, min) {
		var today = new Date();
		var birthDate = new Date(value);
		var age = today.getFullYear() - birthDate.getFullYear();

		if (age > min + 1) {
			return true;
		}

		var m = today.getMonth() - birthDate.getMonth();

		if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
			age--;
		}

		return age >= min;
	}, "You are not old enough!");

	//Security Answer Validation
	$("#sanswer").keypress(function(e) {
		var keyCode = e.keyCode || e.which;

		$("#serror").html("");

		//Regex for Valid Characters i.e. Alphabets and Numbers.
		var regex = /^[A-Za-z]+$/;
		var isValid = regex.test(String.fromCharCode(keyCode));
		if (!isValid) {
			$("#serror").html("Only Alphabets allowed.");
		}
		return isValid;
	});

	//Password Validation
	$("#password").keypress(function(e) {
		var keyCode = e.keyCode || e.which;

		$("#password").html("");

		//Regex for Valid Characters i.e. Alphabets and Numbers.
		var regex = /^[A-Za-z0-9]+$/;
		var isValid = regex.test(String.fromCharCode(keyCode));
		if (!isValid) {
			$("#perror").html("Special Character not allowed.");
		}
		return isValid;
	});

	//Confirm Passasword Validation
	$("#cpassword").keypress(function(e) {
		var keyCode = e.keyCode || e.which;

		$("#cpassword").html("");

		//Regex for Valid Characters i.e. Alphabets and Numbers.
		var regex = /^[A-Za-z0-9]+$/;
		var isValid = regex.test(String.fromCharCode(keyCode));
		if (!isValid) {
			$("#cperror").html("Special Character not allowed.");
		}
		return isValid;
	});

	$('.AddLineOne').each(function() {
		$(this).rules("add",
			{
				required: true,
				messages: {
					required: "Address Line One is required",
				}
			});
	});
	$('.AddLineTwo').each(function() {
		$(this).rules("add",
			{
				required: true,
				messages: {
					required: "Address Line Two is required",
				}
			});
	});

	//Pincode Validation
	$(".pin").keypress(function(e) {
		var keyCode = e.keyCode || e.which;

		$(".PinError").html("");

		//Regex for Valid Characters i.e. Alphabets and Numbers.
		var regex = /^[0-9]+$/;
		var isValid = regex.test(String.fromCharCode(keyCode));
		if (!isValid) {
			$(".PinError").html("Character not allowed.");
		}
		return isValid;
	});

	//City Validation
	$(".city").keypress(function(e) {
		var keyCode = e.keyCode || e.which;

		$(".CityError").html("");

		//Regex for Valid Characters i.e. Alphabets and Numbers.
		var regex = /^[A-Za-z]+$/;
		var isValid = regex.test(String.fromCharCode(keyCode));
		if (!isValid) {
			$(".CityError").html(" Numeric not allowed.");
		}
		return isValid;
	});

	//State Validation
	$(".state").keypress(function(e) {
		var keyCode = e.keyCode || e.which;

		$(".StateError").html("");

		//Regex for Valid Characters i.e. Alphabets and Numbers.
		var regex = /^[A-Za-z]+$/;
		var isValid = regex.test(String.fromCharCode(keyCode));
		if (!isValid) {
			$(".StateError").html(" Numeric not allowed.");
		}
		return isValid;
	});

});

