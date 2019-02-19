<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<th>--Driver Name--</th>
				<th>--emialId--</th>
				<th>--password--</th>
				<th>--isActive--</th>
				<th>--Edit--</th>
				<th>--Delete--</th>
			</tr>
		</thead>


		<tbody style="color: white;">
			<c:forEach var="details" items="${DRIVER}">
				<tr>
					<td><div align="center">
							<c:out value="${details.driverID}" />
						</div></td>

					<td><div align="center">
							<c:out value="${details.dName}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.dEmail}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.driverPass}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.dActive}" />
						</div></td>
					<td><div align="center">
							<a href="./editD.do?id=<c:out value="${details.driverID}"/>">Edit</a>
						</div></td>
					<td><div align="center">
							<a href="./deleteD.do?id=<c:out value="${details.driverID}"/>">Delete</a>
						</div></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>