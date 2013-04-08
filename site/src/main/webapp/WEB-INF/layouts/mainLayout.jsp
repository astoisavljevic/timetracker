<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<tiles:useAttribute name="styles" id="styles" />
<tiles:useAttribute name="scripts" id="scripts" />
<tiles:useAttribute name="scriptBlocks" id="scriptBlocks" />

<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>StaleksIT - Simple Time Tracker</title>
		<!-- 
		<link href="http://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet" type="text/css">
 		-->
		<c:forEach items="${styles}" var="styleHref">
			<link rel="stylesheet" type="text/css" href="<c:url value="${styleHref}"/>" />
		</c:forEach>

		<c:forEach items="${scripts}" var="scriptSrc">
			<script type="text/javascript" src="<c:url value="${scriptSrc}"/>"></script>
		</c:forEach>
	</head>
	<body class="preview">
		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container">
				
					<!-- Be sure to leave the brand out there if you want it shown -->
					<a class="brand" href="<c:url value="/home" />">StaleksIT</a>
				
					<sec:authorize access="isAuthenticated()">
						<ul class="nav pull-right">
							<li class="dropdown">
								<a class="dropdown-toggle" href="#" data-toggle="dropdown">
									<sec:authentication property="principal.username" />
									<span class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li>
										<a href="<c:url value="/account" />">Account</a>
									</li>
									<li>
										<a href="<c:url value="/test" />">Test</a>
									</li>
									<li class="divider"></li>
									<li>
										<a href="<c:url value="/logout" />">Log Out</a>
									</li>
								</ul>
							</li>
						</ul>
					</sec:authorize>
				</div>
			</div>
		</div>

		<tiles:insertAttribute name="content" />

		<c:forEach items="${scriptBlocks}" var="scriptBlock">
			<tiles:insertAttribute value="${scriptBlock}" />
		</c:forEach>		
	</body>
</html>