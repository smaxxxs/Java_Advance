$("button.btn-primary").click(function() {
	debugger;
	var productId = jQuery(this).attr("product-id");
	
	
	$.post("payments", {'productId':productId},
			function(data) {
				if (data == 'Success') {
					$('#buyProductModal').modal('hide');
					alert('Success');
					history.back();
				}
			});
});