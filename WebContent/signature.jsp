<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/signature-pad.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description"
	content="Signature Pad - HTML5 canvas based smooth signature drawing using variable width spline interpolation.">

<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">

<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<title>Signature Form</title>

</head>
<body>
	<input type="hidden" id="imgFile" value=<%=request.getParameter("imgFile")%>>
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
	<script type="text/javascript" src="js/signature_pad.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</body>
</html>