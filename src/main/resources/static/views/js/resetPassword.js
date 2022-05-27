$(function() {
	$("form[name='resetpassword']").validate({
		rules: {

			oldPassword: {
				minlength: 5,
				required: true

			}
		},
		messages: {

			oldPassword: {
				minlength: "Minimum length of Password is Five(5).",
				required: "Password Requried"
			},

		},

		submitHandler: function(form) {
			form.submit();
		}
	});


	
//	$("#oldpassword").keypress(function(e) {
//		var keyCode = e.keyCode || e.which;
//
//		$("#oldpassword").html("");
//
//		//Regex for Valid Characters i.e. Alphabets and Numbers.
//		var regex = /^[A-Za-z0-9]+$/;
//		var isValid = regex.test(String.fromCharCode(keyCode));
//		if (!isValid) {
//			$("#passworderror").html("Special Character not allowed.");
//		}
//		return isValid;
//	});
	
	$(document).ready(function() {
		$("#oldpassword").change(function() {
			var currentPassword = $("#oldpassword").val();
			console.log(currentPassword);
			$.ajax({
				type: 'POST',
				url: "ResetPassword",
				data: {
					currentPassword: currentPassword,
				},
				success: function(result) {
					$("#result").html(result);
				},
			});
		});
	});


});
