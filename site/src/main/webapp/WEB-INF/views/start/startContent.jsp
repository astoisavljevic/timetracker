<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<div class="container">
	<header id="overview" class="jumbotron subhead">
		<div class="row">
			<div class="span6">
				<h1><fmt:message key="applicationName" /></h1>
				<p class="lead"><fmt:message key="applicationDescription" /></p>
			</div>
			<div class="span6">&nbsp;</div>
		</div>	
	</header>
	<div class="page-header">&nbsp;</div>
	<section class="start-actions center">
		<div class="row">
			<div class="span12">
				<a class="btn btn-primary" href="<c:url value="/login"/>"><fmt:message key="startPage.btnLogIn" /></a>
				<div class="spacer20"></div>
			 	<a class="btn btn-info" href="<c:url value="/signIn"/>"><fmt:message key="startPage.btnSignIn" /></a>
				<div class="spacer20"></div>
				<div class="control-group country-flags pull-right">
					<a id="flag-uk" href="<c:url value="/start?lang=en" />"></a>
					<a id="flag-serbia" href="<c:url value="/start?lang=rs" />"></a>
				</div>
			</div>
		</div>
	</section>
</div>