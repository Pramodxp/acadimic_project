<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design @ SHARAN SHAS...3 (9538180903)
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="icon" href="images/home.png"></link>
<title>ECP</title>
<link href='http://fonts.googleapis.com/css?family=Oswald:400,300'
	rel='stylesheet' type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Abel|Satisfy'
	rel='stylesheet' type='text/css' />
<script type="text/javascript" src="js/validation.js"></script>
<link href="css/default.css" rel="stylesheet" type="text/css"
	media="all" />

</head>
<body>
	<div id="header-wrapper">
		<div id="header">
			<div id="logo">
				<h1>
					<a href="#"></a>
				</h1>

				<p
					style="font-family: times new roman; font-size: 23px; color: white;">
					<mark>Light Weight Break Glass Access Control System for
					Healthcare</mark>
				</p>
			</div>
			<div id="menu">
				<ul>
					<li><a href="index.do">HOME</a></li>
					<li><a href="loginForm.do">Login Page</a></li>
					<li><a href="kgcLoginForm.do">KGC</a></li>
					<li><a href="cpLoginForm.do">CP</a></li>
					<li><a href="hipLoginForm.do">HIP</a></li>
					<li class="current_page_item"><a href="ecpLoginForm.do">ECP</a></li>
				</ul>
			</div>
		</div>
		<div id="banner">
			<div class="img-border">
				<a href="#"><img src="images/doctors.jpg" width="1120"
					height="300" alt="" /></a>
			</div>
		</div>
	</div>
	<div id="wrapper">
		<div id="page-wrapper">
			<div id="page">
				<div id="content">
					<h2>ECP Login page ....!</h2>
					<h2>${LOGIN_STATUS}</h2>
					<p>
						<form name="loginForm" action="./ecpLogin.do" method="post">
							<table border="1" cellpadding="0" cellspacing="0"
								style="width: 50%" bgcolor="#FF9900">
								<tr>
									<td width="41%" height="33"><div align="right"
											class="style1">UserName :&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
									<td width="59%"><div align="center">
											<input type="text" name="nme" placeholder="USERNAME"></input>
										</div></td>
								</tr>
								<tr>
									<td height="34"><div align="right" class="style1">Password
											:&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
									<td><div align="center">
											<input type="password" name="pwd" placeholder="PASSWORD"></input>
										</div></td>
								</tr>
								<tr>
									<td height="40" colspan="2">
										<div align="center">
											<input type="submit" value="login"
												onclick="return LoginFormValidate()"></input>
										</div>
									</td>
								</tr>
							</table>
						</form>
					</p>


				</div>
				<div id="sidebar">
					<h2>Menu</h2>
					<ul class="style1">
						<li class="first"><a href="index.do">HOME</a></li>
						<li><a href="loginForm.do">Login Page</a></li>
						<li><a href="kgcLoginForm.do">KGC</a></li>
						<li><a href="cpLoginForm.do">CP</a></li>
						<li><a href="hipLoginForm.do">HIP</a></li>
						<li><a href="ecpLoginForm.do">ECP</a></li>
					</ul>

				</div>
			</div>
		</div>
	</div>

	<div id="footer" class="container">
		<p style="font-size: 25px;">
			Copyright &copy; <a href="">SHARAN SHAS...3</a>.
		</p>
	</div>
</body>
</html>
