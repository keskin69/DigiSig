<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="yellowzebra.booking.BookingTools"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="css/TableCSSCode.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Yellow Zebra WebTools</title>
</head>

<body>
	<div class="booking-div">
		<%
			BookingTools bookings = new BookingTools();
			bookings.getTodayBookings();
			String result = bookings.getHTML("BookingTable");

			out.write(result);
		%>
	</div>

	<script type="text/javascript">
		var selectedRow = 0;
		var table = document.getElementById("BookingTable");

		onload = function() {
			if (!document.getElementsByTagName || !document.createTextNode)
				return;
			var rows = table.getElementsByTagName("tr");
			for (i = 0; i < rows.length; i++) {
				rows[i].onclick = function() {
					selectedRow = this.rowIndex;
				}
			}
		}

		function getHeader(header) {
			var th = document.getElementsByTagName("th");
			for (i = 0; i < th.length; i++) {
				if (th[i].innerHTML == header) {
					return table.rows[selectedRow].cells[i].innerHTML;
				}
			}
		}

		function fnselect() {
			var row = table.rows[selectedRow];
			// column value = row.cells[j]
			var bNumber = getHeader("Booking Number");
			window.location = "form.jsp?bNumber=" + bNumber;
		}
	</script>

	<input type="submit" value="Sign for Selected" name="btnSubmit"
		onclick="fnselect()" />
</html>