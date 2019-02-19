<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--
Design @ SHARAN SHAS...3 (9538180903)
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="./../js/validation.js"></script>
<link rel="stylesheet" type="text/css" href="./../css/calender.css" />
<script src="./../js/date1.js"></script>
<script src="./../js/dateUi.js"></script>
<script>
	$(function() {
		$("#datepicker-13").datepicker({
			changeYear : true,
			yearRange : "1980:2016",
			changeMonth : true
		});

	});
</script>
</head>
<body>
	<h2>${ADDED_STATUS}</h2>
	<p>
	<form method="post" action="./addDoctor.do"
		enctype="multipart/form-data" name="addDoctor">

		<table style="color: black;" align="center" cellpadding="0"
			cellspacing="1" bgcolor="#FF9900">


			<tr>
				<td width="152" height="35">DR. Name</td>
				<td width="385"><input type="text" name="dr_name"
					maxlength="30" /></td>
			</tr>

			<tr>
				<td height="35">Specialist</td>
				<td><input type="text" name="specialist" maxlength="30" /></td>
			</tr>

			<tr>
				<td height="35">Qualification</td>
				<td><input type="text" name="qualification" maxlength="30" /></td>
			</tr>

			<tr>
				<td height="35">Experience in Year</td>
				<td><input type="text" name="experience" maxlength="2" /></td>
			</tr>

			<tr>
				<td height="35">Date of Birth</td>
				<td><input id="datepicker-13" name="dob" type="text"
					class="slimpicker" readonly="readonly" /></td>
			</tr>

			<tr>
				<td height="35">email ID</td>
				<td><input type="text" name="emailId" maxlength="100" /></td>
			</tr>

			<tr>
				<td height="35">Mobile Number</td>
				<td><input type="text" name="mobileNumber" maxlength="10" /></td>
			</tr>

			<tr style="color: black;">
				<td height="35" style="color: black;">ProfilePic</td>
				<td><label> <input type="file" name="file"
						accept="image/*"></input>
				</label></td>
			</tr>


			<tr>
				<td height="35"><div align="right">
						<input type="submit" value="Submit"
							onclick="return addDoctorValidate()"></input> &nbsp;
					</div></td>
				<td><div align="left">
						<input type="reset" value="Reset"></input> &nbsp;
					</div></td>
			</tr>
		</table>
		</div>
	</form>
</body>
</html>