<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<c:set var="usernamePlaceholder">
	<fmt:message key="loginPage.username.placeholder" />
</c:set>

<c:set var="passwordPlaceholder">
	<fmt:message key="loginPage.password.placeholder" />
</c:set>


<div class="login-container">

	<div id="login-header">
		<h3><fmt:message key="loginPage.lblHeader" /></h3>
	</div>
	
	<div id="login-content" class="clearfix">
		<form id="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="j_username"><fmt:message key="loginPage.lblUsername" /></label>
					<div class="controls">
						<input id="j_username" name="j_username" class="" type="text" placeholder="${usernamePlaceholder}" autocomplete="off">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="j_password"><fmt:message key="loginPage.lblPassword" /></label>
					<div class="controls">
						<input id="j_password" name="j_password" class="" type="password" placeholder="${passwordPlaceholder}" autocomplete="off">
					</div>
				</div>				
			</fieldset>
			<div class="pull-right">
				<button id="btnLogin" class="btn btn-info" type="submit"> <fmt:message key="loginPage.btnLogin" /> </button>
			</div>
		</form>
	</div>
	
</div>