<%-- 
    Document   : addDriver
    Created on : May 4, 2018, 5:19:12 AM
    Author     : raksh
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>${ADDED_STATU}</h2>
	<form method="post" action="./addDriver.do"
		enctype="multipart/form-data" name="addPatient">

		<table border="0" align="center">

			<tbody>
			
				<tr>
					<td>Name :</td>
					<td><input type="text" name="dname" value="" required=""/></td>
				</tr>
				
				<tr>
					<td>Email Id</td>
					<td><input type="text" name="Demail" value="" required=""/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="Driverpass" value="" required=""/></td>
				</tr>
                                
				<tr>
					<td><input type="submit" value="Submit" /></td>
					<td><input type="reset" value="Clear" /></td>
				</tr>
			</tbody>
		</table>

	</form>
</body>
</html>