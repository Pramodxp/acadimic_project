<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--
Design @ SHARAN SHAS...3 (9538180903)
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table width="550" border="1" align="center" cellpadding="0"
		cellspacing="0" style="color: white" bgcolor="#5D7B9D">

		<tr>
			<td width="200" rowspan="7"><div align="center">
					<input name="image" type="image"
						src="patientPic.do?id=<c:out value="${DOCTORPROFILE.slNo}" />"
						width="160" height="120" alt="ImgNotFound"></input>
				</div></td>
			<td width="150" height="40"><p align="right">
				<div align="right">
					Doctor Name&nbsp;&nbsp;&nbsp;
					</p>
				</div></td>
			<td width="200"><div align="left">
					&nbsp;&nbsp;&nbsp;
					<c:out value="${DOCTORPROFILE.slNo}. ${DOCTORPROFILE.drName}" />
				</div></td>
		</tr>
		<tr>

			<td height="40"><div align="right">Specialist&nbsp;&nbsp;&nbsp;</div></td>
			<td><div align="left">
					&nbsp;&nbsp;&nbsp;
					<c:out value="${DOCTORPROFILE.specialist}" />
				</div></td>
		</tr>
		<tr>

			<td height="40"><div align="right">Qualification&nbsp;&nbsp;&nbsp;</div></td>
			<td><div align="left">
					&nbsp;&nbsp;&nbsp;
					<c:out value="${DOCTORPROFILE.qualification}" />
				</div></td>
		</tr>
		<tr>

			<td height="40"><div align="right">Experience&nbsp;&nbsp;&nbsp;</div></td>
			<td><div align="left">
					&nbsp;&nbsp;&nbsp;
					<c:out value="${DOCTORPROFILE.experience}" />
				</div></td>
		</tr>

		<tr>

			<td height="40"><div align="right">Date of
					Birth&nbsp;&nbsp;&nbsp;</div></td>
			<td><div align="left">
					&nbsp;&nbsp;&nbsp;
					<c:out value="${DOCTORPROFILE.dob}" />
				</div></td>
		</tr>
		<tr>

			<td height="40"><div align="right">Email&nbsp;&nbsp;&nbsp;</div></td>
			<td><div align="left">
					&nbsp;&nbsp;&nbsp;
					<c:out value="${DOCTORPROFILE.emailId}" />
				</div></td>
		</tr>

		<tr>
			<td height="40"><div align="right">Contact&nbsp;&nbsp;&nbsp;</div></td>
			<td><div align="left">
					&nbsp;&nbsp;&nbsp;
					<c:out value="${DOCTORPROFILE.mobileNumber}" />
				</div></td>
		</tr>
	</table>


</body>
</html>