<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--
Design @ SHARAN SHAS...3 (9538180903)
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="icon" href="images/authority.jpg"></link>
<title>${PATIENT}</title>
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
					<li><a href="patientDocument.do">Document</a></li>
					<li><a href="patientKey.do">PatientKey</a></li>
					<li><a href="createECP.do">Create ECP</a></li>
					<li><a href="viewECP.do">View ECP</a></li>
					<li><a href="viewAssignedDoctor.do">Assigned Doctor</a></li>

				</ul>
			</div>
		</div>

	</div>
	<div id="wrapper">
		<div id="page-wrapper">
			<div id="page">
				<div id="content1">

					<c:if test="${PATH == '/patientMain.do'}">
						<h1>${PATIENT}&nbsp;Main</h1>
						<div align="center">
							<img src="images/common.jpg" width="100%" height="360" alt="" />
						</div>
					</c:if>

					<c:if test="${PATH == '/patientKey.do'}">
						<h2>Patient Key Details</h2>
						<div align="center">
							<iframe src="jsp/patientKey.jsp" width="100%" height="400"
								scrolling="auto"></iframe>
						</div>
					</c:if>

					<c:if test="${PATH == '/patientDocument.do'}">
						<h2>View Patient Documents</h2>
						<div align="center">
							<iframe src="jsp/viewPatientDocument.jsp" width="100%"
								height="400" scrolling="auto"></iframe>
						</div>
					</c:if>

					<c:if test="${PATH == '/createECP.do'}">
						<h2>Create Emergency Contact Person</h2>
						<div align="center">
							<iframe src="jsp/createECP.jsp" width="100%" height="400"
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

					<c:if test="${PATH == '/viewAssignedDoctor.do'}">
						<h2>Assigned Doctor</h2>
						<div align="center">
							<iframe src="jsp/viewAssignedDoctor.jsp" width="100%"
								height="400" scrolling="auto"></iframe>
						</div>
					</c:if>


					<p>
						<a href="patientMain.do">Main</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
							href="patientLogout.do">Logout</a>
					</p>
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
