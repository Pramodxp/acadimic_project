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
<script type="text/javascript" src="./../js/validation.js"></script>
</head>
<body>
	<h2>Attribute Based Access</h2>
	<table border="1" width="100%" cellspacing="0" bgcolor="#5D7B9D">
		<thead style="color: WHITE;">
			<tr>
			<tr>
				<th>-S.NO-</th>
				<th>--Patient Name--</th>
				<th>--Doctor--</th>
				<th>--sickness type--</th>
				<th>--Permission by Patient--</th>
			</tr>
		</thead>


		<tbody style="color: white;">
			<c:forEach var="details" items="${ALLABA}">

				<tr>

					<td><div align="center">
							<c:out value="${details.pSlNo}" />
						</div></td>
					<td align="center">
						<div align="center">
							<input name="image" type="image"
								src="patientPic.do?id=<c:out value="${details.pSlNo}" />"
								width="160" height="120" alt="ImgNotFound"></input>
						</div> <c:out value="${details.patientname}" />
					</td>
					<td><div align="center">
							<c:out value="${details.drName}" />
						</div></td>

					<td><div align="center">
							<c:out value="${details.type}" />
						</div></td>

					<td><div align="center">
							<c:out value="${details.patientPermission}" />
						</div></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>

	<h2>Break Glass Access</h2>
	<table border="1" width="100%" cellspacing="0" bgcolor="#5D7B9D">
		<thead style="color: WHITE;">
			<tr>
			<tr>
				<th>-S.NO-</th>
				<th>--Patient Name--</th>
				<th>--Doctor Name--</th>
				<th>--KGC Key--</th>
				<th>--Patient Key--</th>
				<th>--Date of Access--</th>
			</tr>
		</thead>


		<tbody style="color: white;">
			<c:forEach var="details" items="${ALLBGA}">

				<tr>
					<td><div align="center">
							<c:out value="${details.sl}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.patientName}" />
						</div></td>

					<td><div align="center">
							<c:out value="${details.doctorName}" />
						</div></td>

					<td><div align="center">
							<c:out value="${details.KGCKey}" />
						</div></td>

					<td><div align="center">
							<c:out value="${details.paKey}" />
						</div></td>

					<td><div align="center">
							<c:out value="${details.date}" />
						</div></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>

