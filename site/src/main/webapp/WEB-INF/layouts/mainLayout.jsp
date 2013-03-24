<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<tiles:useAttribute name="styles" id="styles" />
<tiles:useAttribute name="scripts" id="scripts" />
<tiles:useAttribute name="scriptBlocks" id="scriptBlocks" />

<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="http://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet" type="text/css">
		<c:forEach items="${styles}" var="styleHref">
			<link rel="stylesheet" type="text/css" href="<c:url value="${styleHref}"/>" />
		</c:forEach>
		
		<c:forEach items="${scripts}" var="scriptSrc">
			<script type="text/javascript" src="<c:url value="${scriptSrc}"/>"></script>
		</c:forEach>		
	</head>
	<body>
		<tiles:insertAttribute name="header" />
		
		<tiles:insertAttribute name="content" />
		
		<c:forEach items="${scriptBlocks}" var="scriptBlock">
			<tiles:insertAttribute value="${scriptBlock}" />
		</c:forEach>
	</body>
</html>