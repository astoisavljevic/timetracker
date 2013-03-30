<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<div class="container">
	<header id="overview" class="jumbotron subhead">
		<div class="row">
			<div class="span6">
				<h1>Time Track</h1>
				<p class="lead">simple time tracker application</p>
			</div>
			<div class="span6">&nbsp;</div>
		</div>	
	</header>
	<div class="page-header">&nbsp;</div>
	<section class="start-actions">
		<a class="btn btn-primary" href="<c:url value="/login"/>">Log in</a>
		<div class="spacer20"></div>
		<a class="btn btn-info" href="<c:url value="/signIn"/>">Sign In</a>
	</section>
</div>