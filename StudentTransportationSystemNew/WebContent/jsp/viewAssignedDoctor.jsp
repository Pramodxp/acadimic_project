<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--
Design @ SHARAN SHAS...3 (9538180903)
-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="100%" cellspacing="0" bgcolor="#5D7B9D">
		<thead style="color: WHITE;">
			<tr>
			<tr>
				<th>-S.NO-</th>
				<th>--My Name--</th>
				<th>--Doctor--</th>
				<th>--sickness type--</th>
				<th>--Provide Permission--</th>
			</tr>
		</thead>


		<tbody style="color: white;">

			<tr>

				<td><div align="center">
						<c:out value="${ASSIGNEDDOCTOR.pSlNo}" />
					</div></td>
				<td align="center">
					<div align="center">
						<input name="image" type="image"
							src="patientPic.do?id=<c:out value="${ASSIGNEDDOCTOR.pSlNo}" />"
							width="160" height="120" alt="ImgNotFound"></input>
					</div> <c:out value="${ASSIGNEDDOCTOR.patientname}" />
				</td>
				<td><div align="center">
						<c:out value="${ASSIGNEDDOCTOR.drName}" />
					</div></td>

				<td><div align="center">
						<c:out value="${ASSIGNEDDOCTOR.type}" />
					</div></td>

				<td><div align="center">

						<a
							href="./providePermission.do?id=<c:out value="${ASSIGNEDDOCTOR.pSlNo}"/>"><c:out
								value="${ASSIGNEDDOCTOR.patientPermission}" /></a>

					</div></td>
			</tr>
		</tbody>
	</table>
</body>
</html>