
				function postRegisterData() {
					debugger;
					var userName = $("#usernamesignup")
							.val();
					var password = $(" #passwordsignup").val();
					var cpassword = $("#passwordsignup_confirm").val();
					
					if (!(password).match(cpassword)) {
							alert("Your passwords don't match. Try again!");
						} else {
				
						var userRegistration = {
								userName : userName,
								password : password
						
						};

						$.post("RegistrationServlet", userRegistration,
								function(data) {
									if (data == 'noSuccess') {
										alert("Change your userName. It's here already");
									}
									if(data !== ''){
										var customUrl = '';
										var urlContent = window.location.href.split('/');
										for (var i = 0; i < urlContent.length-1; i++) {
											customUrl+=urlContent[i]+'/'
										}
										customUrl+=data.destinationUrl;
										window.location = customUrl;
									}
								});
				};
				}

function postLoginData() {
	debugger;
	var username = $("#username").val();
	var password = $("#password").val();

	if (username == '' || password == '') {
		alert("Please fill login form!");
	} else {
		var userLogin = {
				username : username,
				password : password
		};

		$.post("LoginServlet", userLogin, function(data) {
			if(data !== ''){
				var customUrl = '';
				var urlContent = window.location.href.split('/');
				for (var i = 0; i < urlContent.length-1; i++) {
					customUrl+=urlContent[i]+'/'
				}
				customUrl+=data.destinationUrl;
				
				window.location = customUrl;
			}
			$("form")[1].reset();
		});
	}
}