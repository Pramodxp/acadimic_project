<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--
Design @ SHARAN SHAS...3 (9538180903)
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="./../js/validation.js"></script>
</head>
<body>
	<form name="loginForm" action="./getDocument.do" method="post">
		<table border="1" cellpadding="0" cellspacing="0" style="width: 50%"
			bgcolor="#FF9900">
			<tr>

				<td width="59%"><div align="center">
						<input type="text" name="key" placeholder="enter key for document"></input>
					</div></td>
				<td height="40" colspan="2">
					<div align="center">
						<input type="submit" value="submit"
							onclick="return docFormValidate()"></input>
					</div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>