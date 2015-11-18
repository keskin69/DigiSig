<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/signature-pad.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description"
	content="Signature Pad - HTML5 canvas based smooth signature drawing using variable width spline interpolation.">

<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">

<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<title>Yellow Zebra</title>

</head>
<body>

	I accept:

	<%
	String bNumber = request.getParameter("bNumber");
%>


	<span id="signin"> <span class="g-signin"
		data-callback="signinCallback"
		data-clientid="692008307570.apps.googleusercontent.com"
		data-cookiepolicy="single_host_origin"
		data-scope="https://www.googleapis.com/auth/drive.file"> </span>
	</span>
	
	<form action="demo_form.asp">
		BookingNumber =<%=bNumber%>
		Full Name <input type="text" name="name"><br>
		Accomodation in Budapest <input type="text" name="accomo"><br>
		Home Address <input type="text" name="home"><br> Contact
		Information(e-mail/phone) <input type="text" name="contact"><br>
	</form>
	
	<div id="signature-pad" class="m-signature-pad">
		<div class="m-signature-pad--body">
			<canvas></canvas>
		</div>
		<div class="m-signature-pad--footer">
			<div class="description">Sign above</div>
			<button type="button" class="button clear" data-action="clear">Clear</button>
			<button type="button" class="button save" data-action="save">Save</button>
		</div>
	</div>
	<script type="text/javascript" src="js/upload.js"></script>
	<script type="text/javascript" src="js/signature_pad.js"></script>
	<script type="text/javascript" src="js/app.js"></script>


</body>
</html>