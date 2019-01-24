function logOut(){
	$.get("Logout",
			function(data) {
		
		alert("Don't leave us pls");
					if(data !== ''){
//					var customUrl = '';
//					var urlContent = window.location.href.split('/');
//					for (var i = 0; i < urlContent.length-1; i++) {
//						customUrl+=urlContent[i]+'/'
//					}
//					customUrl+=data;
					window.location = data;//customUrl;
				}
			});
}