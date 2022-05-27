$(function() {
	$("form[name='forgotpassword']").validate({
		rules: {

			email: {
				required: true,
				email: true
			},

			phoneNo: {
				required: true,
				digits: true,
				minlength: 10,
				maxlength: 10
			},

			SecurityAnswer: {
				required: true
			},

			NPassword: {
				minlength: 5,
				required: true
				
			}
		},
		messages: {

			email: {
				required: "Please enter your Email",
				email: "The email should be in the format: abc@gmail.com"
			},

			phoneNo: {
				required: "Please enter phone number",
				digits: "Please enter valid phone number",
				minlength: "Phone number field accept only 10 digits",
				maxlength: "Phone number field accept only 10 digits"
			},

			SecurityAnswer: {
				required: "Please Enter Your Answer"
			},

			NPassword: {
				minlength: "Minimum length of Password is Five(5).",
				required: "Password Requried"
			},

		},

		submitHandler: function(form) {
			form.submit();
		}
	});


	//Security Answer Validation
	$("#useranswer").keypress(function(e) {
		var keyCode = e.keyCode || e.which;

		$("#usererror").html("");

		//Regex for Valid Characters i.e. Alphabets and Numbers.
		var regex = /^[A-Za-z]+$/;
		var isValid = regex.test(String.fromCharCode(keyCode));
		if (!isValid) {
			$("#usererror").html("Only Alphabets allowed.");
		}
		return isValid;
	});
	
	$("#newpassword").keypress(function(e) {
		var keyCode = e.keyCode || e.which;

		$("#newpassword").html("");

		//Regex for Valid Characters i.e. Alphabets and Numbers.
		var regex = /^[A-Za-z0-9]+$/;
		var isValid = regex.test(String.fromCharCode(keyCode));
		if (!isValid) {
			$("#passworderror").html("Special Character not allowed.");
		}
		return isValid;
	});


});
