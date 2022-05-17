$(document).ready(function(e) {

	//Access Data using DataTable 
	$('#showAllUser').DataTable({

		//Retriev the json data
		"ajax": {
			"type": "GET",
			"url": "UserTableController",
			"datatype": "json"
		},

		"columns": [
			{ "data": "Userid" },
			{ "data": "FirstName" },
			{ "data": "LastName" },
			{ "data": "Email" },
			{ "data": "PhoneNo" },
			{ "data": "Dob" },
			{ "data": "gender" },
			{ "defaultContent": "<a href='updateuser' class='btn btn-success'>Edit</a>" },
			{ "defaultContent": "<button  class='btn btn-danger' >Delete</button>" },
		]
	});
	e.preventDefault();
});


//Edit User
$(document).on('click', '.btn-success', function() {

	var currentRow = $(this).closest("tr");
	var Email = currentRow.find("td:eq(3)").text();
	console.log(Email);
	$.ajax({
		type: 'GET',
		url: "UpdateUserDetails",
		"datatype": "json",
		data: {
			Email: Email,
		},
		success: function() {
			setInterval('refreshPage()', 500);
		},
	});
});

function timedRefresh(timeoutPeriod) {
	setTimeout("location.reload(true);", timeoutPeriod);
}


//Delete User
$(document).on('click', '.btn-danger', function() {
	var currentRow = $(this).closest("tr");
	var uid = currentRow.find("td:eq(0)").text();
	console.log(uid);
	$.ajax({
		type: 'GET',
		url: "DeleteCurrentUserController",
		"datatype": "json",
		data: {
			uid: uid,
		},
		success: function() {
			swal({
				title: "Are you sure?",
				text: "Once deleted, you will not be able to recover this User Profile!",
				icon: "warning",
				buttons: true,
				dangerMode: true,
			})
				.then((willDelete) => {
					if (willDelete) {
						swal("Poof! User Profile has been Deleted!", {
							icon: "success",
						});
					} else {
						swal("User Profile is not Deleted!");
					}
				});
			setInterval('refreshPage()', 4000);
		}
	});
});

function refreshPage() {
	window.location.reload(true);
}

