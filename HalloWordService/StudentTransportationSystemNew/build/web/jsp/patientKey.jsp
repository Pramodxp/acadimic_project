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
	<table border="1" width="100%" cellspacing="0" bgcolor="#5D7B9D">
		<thead style="color: WHITE;">
			<tr>
			<tr>
				<th>-S.NO-</th>
				<th>--Patient Name--</th>
				<th>--Mobile Number--</th>
				<th>--KGC Key--</th>
				<th>--Break Glass Key--</th>


			</tr>
		</thead>


		<tbody style="color: white;">
			<tr>
				<td><div align="center">
						<c:out value="${PATIENTKEY.slNo}" />
					</div></td>
				<td align="center">
					<div align="center">
						<input name="image" type="image"
							src="patientPic.do?id=<c:out value="${PATIENTKEY.slNo}" />"
							width="160" height="120" alt="ImgNotFound"></input>
					</div> <c:out value="${PATIENTKEY.patientname}" />
				</td>
				<td><div align="center">
						<c:out value="${PATIENTKEY.mobileNumber}" />
					</div></td>
				<td><div align="center">
						<c:out value="${PATIENTKEY.kgc}" />
					</div></td>
				<td><div align="center">
						<a
							href="./breakGlassKey.do?id=<c:out value="${PATIENTKEY.slNo}"/>"><c:out
								value="${PATIENTKEY.pakey}" /></a>
					</div></td>

			</tr>
		</tbody>
	</table>
</body>
</html>

