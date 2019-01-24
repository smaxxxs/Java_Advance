function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[2];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}

var buckets = null;
$.get("buckets", function(data) {
	if (data !== '') {
		buckets = data;
	}
}).done(function() {
	
	var tableContent = "<tr class='header'>"+
					"<th style='width: 10%;'>Id Payment</th>"+
					"<th style='width: 20%;'>Date</th>"+
					"<th style='width: 30%;'>Magazine</th>"+
					"<th style='width: 20%;'>Price</th>"+
					"<th style='width: 20%;'></th>"+
					"</tr>";
	
	jQuery.each(buckets, function(i, value) {
	
		tableContent+="<tr>"+
					  "<td>" + value.id_payment + "</td>"+
					  "<td>" + value.date + "</td>"+
					  "<td>" + value.description + "</td>"+
					  "<td>" + value.sum + "</td>"+
					  "<td><button onclick='deleteOrderFromBucket(" + value.id_payment + ")'>delete</button></td>"+
					  "</tr>"
					   
	});
	
	  $('#myTable').html(tableContent);
	
});



function deleteOrderFromBucket(bucketId) {	
	var customUrl = '';
	var urlContent = window.location.href.split('/');
	for (var i = 0; i < urlContent.length-1; i++) {
		customUrl+=urlContent[i]+'/'
	}
	customUrl+='payments?bucketId='+bucketId;
	
	$.ajax({
	    url: customUrl,
	    type: 'DELETE',
	    success: function(data) {
	    	if (data == 'Success') {
	    		location.reload();
			}
	    }
	});
}