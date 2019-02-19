<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>




<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
#msg{
color:red;
}
</style>
</head>
<body>
<h2>${ADDED_STATU}</h2>
	<form method="post" action="./addStudent.do" onsubmit="return myFunction()"
		enctype="multipart/form-data" name="addPatient">

		<table border="0" align="center">

			<tbody>
				<tr>
					<td>Name :</td>
					<td><input type="text" name="stuname" value="" required=""/></td>
				</tr>
				<tr>
					<td id="err">USN</td>
					<td><input type="text" name="stuusn" value="" required="" id="usn" onblur="myFunction()"/></td>
					<td><span id="msg"></span></td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td><input type="text" name="stuemail" value="" required=""/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="stupass" value="" required=""/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"  /></td>
					<td><input type="reset" value="Clear" /></td>
				</tr>
			</tbody>
		</table>

	</form>
	
	<script type="text/javascript" >

	
		
		function myFunction(){
		var usn=document.getElementById("usn");
		document.getElementById("err").style.color = "black";
		 var patt = /^[0-9]{1}[a-zA-Z]{2}[0-9]{2}[a-zA-Z]{2}[0-9]{3}$/;
	    var res = patt.test(usn.value);
	    console.log(res);
	    if(res==true)
		return res;
	    else
	   {
	    	document.getElementById("err").style.color = "red";
	    	document.getElementById("msg").innerHTML = "Enter  valid Pattern eg:1DB15CS123";
		    return false;

		    	    }
		
	}

	</script>
</body>
</html>