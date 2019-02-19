<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="./updateD.do" enctype="multipart/form-data"
		name="addPatient">

		<table border="0" align="center">

			<tbody>
				<tr>
					<td>ID :</td>
					<td><input type="text" name="driverID"
						value="${DRIVER.driverID}"  /></td>
				</tr>

				<tr>
					<td>Name :</td>
					<td><input type="text" name="dname" value="${DRIVER.dName}" /></td>
				</tr>
				<tr>
					<td>EMAIL</td>
					<td><input type="text" name="Demail" value="${DRIVER.dEmail}" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="Driverpass"
						value="${DRIVER.driverPass}" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Update" /></td>
				</tr>
			</tbody>
		</table>

	</form>
</body>
</html>