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
<title>${DOCTOR}</title>
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
					<li><a href="doctorProfile.do">Profile</a></li>
					<li><a href="assignedPatients.do">Assigned Patient</a></li>
					<li><a href="bgAccess.do">BG Assigned Patient</a></li>
					<li><a href="doctorMain.do">Main</a></li>
					<li><a href="doctorLogout.do">Logout</a></li>
				</ul>
			</div>
		</div>

	</div>
	<div id="wrapper">
		<div id="page-wrapper">
			<div id="page">
				<div id="content1">

					<c:if test="${PATH == '/doctorMain.do'}">
						<h1>${DOCTOR}&nbsp;Main</h1>
						<div align="center">
							<img src="images/common.jpg" width="100%" height="360" alt="" />
						</div>
					</c:if>

					<c:if test="${PATH == '/doctorProfile.do'}">
						<h2>Profile</h2>
						<div align="center">
							<iframe src="jsp/doctorProfile.jsp" width="100%" height="400"
								scrolling="auto"></iframe>
						</div>
					</c:if>

					<c:if test="${PATH == '/assignedPatients.do'}">
						<h2>View Assigned Patients</h2>
						<div align="center">
							<iframe src="jsp/assignedPatients.jsp" width="100%" height="400"
								scrolling="auto"></iframe>
						</div>
					</c:if>

					<c:if test="${PATH == '/bgAccess.do'}">
						<h2>Break Glass Access</h2>
						<div align="center">
							<iframe src="jsp/bgAccess.jsp" width="100%" height="400"
								scrolling="auto"></iframe>
						</div>
					</c:if>

					<c:if test="${PATH == '/viewECP.do'}">
						<h2>View Emergency Contact Person</h2>
						<div align="center">
							<iframe src="jsp/viewECP.jsp" width="100%" height="400"
								scrolling="auto"></iframe>
						</div>
					</c:if>

					<c:if test="${PATH == '/files.do'}">
						<h2>Authority Files in Cloud</h2>
						<div align="center">
							<iframe src="jsp/files.jsp" width="100%" height="400"
								scrolling="auto"></iframe>
						</div>
					</c:if>

					<c:if test="${PATH == '/downloadPermission.do'}">
						<h2>Provide Download Permission to Users</h2>
						<div align="center">
							<iframe src="jsp/downloadPermission.jsp" width="100%"
								height="400" scrolling="auto"></iframe>
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
