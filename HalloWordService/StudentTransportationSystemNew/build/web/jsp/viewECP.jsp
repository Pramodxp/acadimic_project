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
				<th>--Contact Person--</th>
				<th>--Address--</th>
				<th>--Email--</th>
				<th>--Mobile Number--</th>
				<th>--KGC--</th>

			</tr>
		</thead>


		<tbody style="color: white;">
			<c:forEach var="details" items="${ECP}">
				<tr>
					<td><div align="center">
							<c:out value="${details.slNo}" />
						</div></td>
					<td align="center">
						<div align="center">
							<input name="image" type="image"
								src="ecpPic.do?id=<c:out value="${details.slNo}" />" width="160"
								height="120" alt="ImgNotFound"></input>
						</div> <c:out value="${details.name}" />
					</td>
					<td><div align="center">
							<c:out value="${details.address}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.emailId}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.mobileNumber}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.kgc}" />
						</div></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>

