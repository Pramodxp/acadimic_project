<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design @ SHARAN SHAS...3 (9538180903)
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="icon" href="images/authority.jpg"></link>
<title>${ECP}</title>
<link href='http://fonts.googleapis.com/css?family=Oswald:400,300'
	rel='stylesheet' type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Abel|Satisfy'
	rel='stylesheet' type='text/css' />
<link href="css/default.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="js/validation.js"></script>
<!--[if IE 6]>
<link href="default_ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<style type="text/css">
<!--
.style1 {
	color: #000000
}
-->
</style>
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
					<li><a href="patientDetails.do">Patient Details</a></li>
					<li><a href="patientPW.do">PA Password</a></li>
					<li><a href="ecpMain.do">Main</a></li>
					<li><a href="ecpLogout.do">Logout</a></li>
				</ul>
			</div>
		</div>
		<!-- <div id="banner">
			<div class="img-border">
				<a href="#"><img src="images/cloudComputing.jpg" width="1120"
					height="300" alt="" /></a>
			</div>
		</div> -->
	</div>
	<div id="wrapper">
		<div id="page-wrapper">
			<div id="page">
				<div id="content1">

					<c:if test="${PATH == '/ecpMain.do'}">
						<h1>${ECP}&nbsp;Main</h1>
						<div align="center">
							<img src="images/doctors.jpg" width="100%" height="360" alt="" />
						</div>
					</c:if>
					<c:if test="${PATH == '/patientDetails.do'}">
						<h2>Patient Details</h2>
						<div align="center">
							<iframe src="jsp/patientDetails.jsp" width="100%" height="400"
								scrolling="auto"></iframe>
						</div>
					</c:if>

					<c:if test="${PATH == '/patientPW.do'}">
						<h2>Patient Password</h2>
						<div align="center">
							<iframe src="jsp/patientPassword.jsp" width="100%" height="400"
								scrolling="auto"></iframe>
						</div>
					</c:if>


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
