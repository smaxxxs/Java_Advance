
   
			function addNewMagazine() {
				alert("sadfasdfasdf");
				var name = $('input[name="email"]').val();
				
				var price = $('input[name="pass"]').val();
			
					var mag = {
							name : name,
							price : price
					};
//add validation
					$.post("CRUDMagazineServlet", mag,
							function(data) {
								if (data == 'Success') {

									alert('New magazine registered');
								}
							});
				
			};
  


