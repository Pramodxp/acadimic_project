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
				<th>--Student USN--</th>
				<th>--Latitude--</th>
				<th>--Longitude--</th>
				<th>--Pick Up Location--</th>
				<th>--Driver Name--</th>
				<th>--Date of Request--</th>
				<th>--Permit--</th>
			</tr>
		</thead>

		<tbody style="color: white;">
			<c:forEach var="details" items="${STUDENT_PICKUP_LOCATION}">
				<tr>
					<td><div align="center">
							<c:out value="${details.slNo}" />
						</div></td>

					<td><div align="center">
							<c:out value="${details.stuname}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.lat}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.lon}" />
						</div></td>
					<td><div align="center">
							<textarea><c:out value="${details.address}" /></textarea>
						</div></td>
					<td><div align="center">
							<c:out value="${details.driver}" />
						</div></td>
					<td><div align="center">
							<c:out value="${details.date}" />
						</div></td>
					<td><div align="center">

							<c:choose>
								<c:when test="${details.stdPermission=='1'}">
									<a
										href="./cancel.do?id=<c:out value="${details.slNo}"/>"><c:out
											value="${details.stdPermission}" /></a>
									<br />
								</c:when>
								<c:otherwise>
									<a
										href="./permit.do?id=<c:out value="${details.slNo}"/>"><c:out
											value="${details.stdPermission}" /></a>
									<br />
								</c:otherwise>
							</c:choose>


						</div></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>