<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en" dir="ltr">
<head>
<link rel="icon" href="images/ttpIcon.png"></link>
<title>Third Party Page</title>
<meta charset="iso-8859-1">
<link rel="stylesheet" href="css/layout.css" type="text/css">
<script type="text/javascript" src="js/validation.js"></script>
</head>
<body>
	<div class="wrapper row1">
		<header id="header" class="clear">
			<div id="hgroup">
				<h1>
					<a hreflang="#">Cloud Assisted Key</a>
				</h1>
				<h2>Distribution in Batch for Secure Real-time Mobile Services</h2>
			</div>
			<nav>
				<ul>

					<li><a href="uc.do">Doctors-K</a></li>
					<li><a href="uc.do">Patients-K</a></li>
					<li><a href="uc.do">Patient-SK</a></li>
					<li><a href="uc.do">Doctor-Key</a></li>
					<li><a href="uc.do">Patient-Key</a></li>
				</ul>
			</nav>
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
							<c:if test="${PATH == '/trustedThirdPartyMain.do'}">
								<h1>${TTP}&nbsp;Main</h1>
								<div align="center">
									<img src="images/ttp.jpg" width="100%" height="360" alt="" />
								</div>
							</c:if>

							<c:if test="${PATH == '/generateKey.do'}">
								<h2>Generate Key for Patient</h2>
								<div align="center">
									<iframe src="jsp/KGCforPatient.jsp" width="100%" height="400"
										scrolling="auto"></iframe>
								</div>
							</c:if>

							<c:if test="${PATH == '/generatedKey.do'}">
								<h2>Generate Key for Patient</h2>
								<div align="center">
									<iframe src="jsp/PatientKGC.jsp" width="100%" height="400"
										scrolling="auto"></iframe>
								</div>
							</c:if>

							<c:if test="${PATH == '/upload.do'}">
								<h2>Upload File Here</h2>
								<div align="center">
									<iframe src="jsp/upload.jsp" width="100%" height="400"
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
							<p>
								<a href="trustedThirdPartyMain.do">Main</a>&nbsp;&nbsp;&nbsp;<a
									href="trustedThirdPartyLogout.do">Logout</a>
							</p>
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
