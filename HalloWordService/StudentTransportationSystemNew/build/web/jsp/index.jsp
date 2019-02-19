<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<link rel="icon" href="images/logo.png"></link>
<title>login Page</title>
<meta charset="iso-8859-1">
<link rel="stylesheet" href="css/layout.css" type="text/css">
<script type="text/javascript" src="js/validation.js"></script>
</head>
<body>
	<div class="wrapper row1">
		<header id="header" class="clear">
			<div id="hgroup">
				<h1>
					<a hreflang="#">StudentTransportationSystem</a>
				</h1>
			</div>

		</header>
	</div>
	<!-- content -->
	<div class="wrapper row2">
		<div id="container" class="clear">
			<!-- main content -->
			<div id="homepage">

				<!-- Introduction -->
				<section id="intro" class="last clear">
					<article>
						<figure>
							<img src="images/logo.png" width="450" height="400" alt="">
							<figcaption>
								<h2>Admin Platform ....!</h2>
								<h2>${LOGIN_STATUS}</h2>
								<p>&nbsp;</p>
								<form name="loginForm" action="./cloudLogin.do" method="post">
									<table border="0" cellpadding="0" cellspacing="0"
										style="width: 80%; height: 50%;">
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

							</figcaption>
						</figure>
					</article>
				</section>
				<!-- / Introduction -->
			</div>
			<!-- / content body -->
		</div>
	</div>

	<!-- Copyright -->
	<div class="wrapper row4">
		<footer id="copyright" class="clear">

			<p class="fl_right">Template by Sharan Shastri</p>
		</footer>
	</div>
</body>
</html>
