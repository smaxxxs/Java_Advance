var products = null;

$.get("magazine", function(data) {
	if (data !== '') {
		products = data;
	}
}).done(function() {
	
	var cardsContent = "";
	jQuery.each(products, function(i, value) {
	
		cardsContent+="<div class='col'>" +
					  "<div class='card'>" +
					  "<div class='card-body'>" +
					  "<h5 class='card-title'>" + value.name + "</h5>"+
					  "<h6 class='card-subtitle mb-2 text-muted'>" + value.price + "</h6>"+
					  
					  "<a href='CRUDMagazineServlet?id=" + value.id + "' class='card-link'>details</a>"+
					  "</div>" +
					  "</div>" +
					  "</div>" +
					  "</div>"
	});
	
	  $('#magazineCards').html(cardsContent);
	
});