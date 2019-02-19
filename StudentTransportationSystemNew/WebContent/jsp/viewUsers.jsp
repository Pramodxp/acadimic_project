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
				<th>--Student Name--</th>
				<th>--USN--</th>
				<th>--emialId--</th>
				<th>--Pass--</th>
				<th>--Edit--</th>
				<th>--Delete--</th>
			</tr>
		</thead>


		<tbody style="color: white;">
			<c:forEach var="details" items="${STUDENT}">
				<tr>
					<td><div align="center">
							<c:out value="${details.slNo}" />
						</div></td>

					<td><div align="center">
							<c:out value="${details.stuname}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.stuusn}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.stuemail}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.stupass}" />
						</div></td>
					<td><div align="center">
							<a href="./edit.do?id=<c:out value="${details.slNo}"/>">Edit</a>
						</div></td>
					<td><div align="center">
							<a href="./delete.do?id=<c:out value="${details.slNo}"/>">Delete</a>
						</div></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>