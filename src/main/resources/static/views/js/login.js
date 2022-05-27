$(function() {
	$("form[name='userlogin']").validate({
		rules: {
			
			uemail: {
				required: true,
				email: true
			},

			upassword: {
				minlength: 5,
				required: true
			},

		},
		messages: {
			uemail: {
				required: "Please enter your Email",
				email: "The email should be in the format: abc@gmail.com"
			},

			upassword: {
				
				minlength: "Minimum length of Password is Five(5).",
				required: "Password Requried"
			},

		},

		submitHandler: function(form) {
			form.submit();
		}
	});
	
	

//	$("#upassword").keypress(function(e) {
//		var keyCode = e.keyCode || e.which;
//
//		$("#passworderror").html("");
//
//		//Regex for Valid Characters i.e. Alphabets and Numbers.
//		var regex = /^[A-Za-z0-9]+$/;
//		var isValid = regex.test(String.fromCharCode(keyCode));
//		if (!isValid) {
//			$("#passworderror").html("Special Character not allowed.");
//		}
//		return isValid;
//	});


});

console.log(uemail);

