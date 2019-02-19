<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en" dir="ltr">
<head>
<link rel="icon" href="images/admin.png"></link>
<title>Admin</title>
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
			<nav>
				<ul>
					<li><a href="add.do">Add Student</a></li>
					<li><a href="view.do">View Student</a></li>
					<li><a href="permit.do">Permit Student</a></li>
					 <li><a href="adminMain.do"></a></li> 
					<li><a href="addD.do">Add Driver</a></li>
					<li><a href="viewD.do">View Driver</a></li>
					<li><a href="adminLogout.do">Logout</a></li>

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
							<c:if test="${PATH == '/adminMain.do'}">
								<h1>${CLOUD}&nbsp;Main</h1>
								<div align="center">
									<img src="images/logo.png" width="100%" height="360" alt="" />
								</div>
							</c:if>
							<c:if test="${PATH == '/add.do'}">
								<h2>Add Student</h2>
								<div align="center">
									<iframe src="jsp/addUsers.jsp" width="100%" height="400"
										scrolling="auto"></iframe>
								</div>
							</c:if>



							<c:if test="${PATH == '/addD.do'}">
								<h2>Add Driver</h2>
								<div align="center">
									<iframe src="jsp/addDriver.jsp" width="100%" height="400"
										scrolling="auto"></iframe>
								</div>
							</c:if>





							<c:if test="${PATH == '/view.do'}">
								<h2>View Student</h2>
								<div align="center">
									<iframe src="jsp/viewUsers.jsp" width="100%" height="400"
										scrolling="auto"></iframe>
								</div>
							</c:if>



							<c:if test="${PATH == '/viewD.do'}">
								<h2>View Driver</h2>
								<div align="center">
									<iframe src="jsp/viewDriver.jsp" width="100%" height="400"
										scrolling="auto"></iframe>
								</div>
							</c:if>




							<c:if test="${PATH == '/permit.do'}">
								<h2>Permit Student for PICK-UP</h2>
								<div align="center">
									<iframe src="jsp/permitUsers.jsp" width="100%" height="400"
										scrolling="auto"></iframe>
								</div>
							</c:if>



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
