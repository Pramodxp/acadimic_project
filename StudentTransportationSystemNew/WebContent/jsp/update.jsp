<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="./update.do"
		enctype="multipart/form-data" name="addPatient">

		<table border="0" align="center">

			<tbody>
				<tr>
					<td>ID :</td>
					<td><input type="text" name="slNo" value="${STUDENT.slNo}"
						readonly="readonly" /></td>
				</tr>

				<tr>
					<td>Name :</td>
					<td><input type="text" name="stuname"
						value="${STUDENT.stuname}" /></td>
				</tr>
				<tr>
					<td>USN</td>
					<td><input type="text" name="stuusn" value="${STUDENT.stuusn}" /></td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td><input type="text" name="stuemail"
						value="${STUDENT.stuemail}" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="stupass"
						value="${STUDENT.stupass}" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update" /></td>
				</tr>
			</tbody>
		</table>

	</form>
</body>
</html>