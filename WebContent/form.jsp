<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Yellow Zebra Waiver and Release Form</title>
<script src="js/jspdf.js"></script>
<script type="text/javascript" src="js/upload.js"></script>
</head>
<body>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(new Date());
	%>

	<script type="text/javascript">
		function openSignature() {
			if (document.getElementById('nameField').value == "") {
				alert("Please type your name");
				return;
			}

			var ref = document.getElementById('dateField').value + "_"
					+ document.getElementById('nameField').value;

			ref = ref.replace("/", "_");
			sigWindow = window
					.open("signature.jsp?imgFile=" + ref, "Signature",
							"toolbar=0,titlebar=0,menubar=0,resizable=0,status=0,width=650,height=350");
			sigWindow.moveTo(400, 0);
		}

		function saveAsPDF() {
			var doc = new jsPDF();

			doc.setFontSize(40);
			doc.text(35, 25, "Paranyan loves jsPDF");
			doc.addImage(imgData, 'JPEG', 15, 40, 180, 160);
		}
	</script>
	<div id="content">
		Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam
		nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat,
		sed diam voluptua. At vero eos et accusam et justo duo dolores et ea
		rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem
		ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur
		sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et
		dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam
		et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea
		takimata sanctus est Lorem ipsum dolor sit amet.

		<form>
			<br> Date of tour <input type="text" id="dateField"
				value=<%=date%> readonly> <input type="hidden" id="bNumber"
				value=<%=request.getParameter("bNumber")%> readonly> <br>
			Full Name <input type="text" id="nameField" name="name"> <br>
			Accomodation in Budapest <input type="text" name="accomo"> <br>
			Home Address <input type="text" name="home"> <br>
			Contact Information(e-mail/phone) <input type="text" name="contact"><br>
			<input type="reset" value="Reset Form"> <br> Signature
		</form>
	</div>

	<a onclick="openSignature()"> <img src="signature.png"
		id="sigField" />
	</a>

	<button type="submit" onclick="saveAsPDF()">Submit</button>
</body>
</html>