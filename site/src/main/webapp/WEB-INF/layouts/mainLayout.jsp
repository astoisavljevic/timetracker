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
<link href="http://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet" type="text/css">

<c:forEach items="${styles}" var="styleHref">
	<link rel="stylesheet" type="text/css"
		href="<c:url value="${styleHref}"/>" />
</c:forEach>

<c:forEach items="${scripts}" var="scriptSrc">
	<script type="text/javascript" src="<c:url value="${scriptSrc}"/>"></script>
</c:forEach>
</head>
<body class="preview">
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				
				<!-- 			
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				 -->
			
				<!-- Be sure to leave the brand out there if you want it shown -->
				<a class="brand" href="#">StaleksIT</a>
				
				<sec:authorize access="isAuthenticated()">
					<ul class="nav pull-right">
						<li class="dropdown">
							<i class="icon-user"></i>
							java-developer
							<span class="caret"></span>
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