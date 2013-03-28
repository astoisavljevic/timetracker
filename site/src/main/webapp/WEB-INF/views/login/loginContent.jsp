<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<div class="login-container">

	<div id="login-header">
		<h3>Login</h3>
	</div>
	
	<div id="login-content" class="clearfix">
		<form id="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="j_username">Username</label>
					<div class="controls">
						<input id="j_username" name="j_username" class="" type="text" placeholder="Username">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="j_password">Password</label>
					<div class="controls">
						<input id="j_password" name="j_password" class="" type="password" placeholder="Password">
					</div>
				</div>				
			</fieldset>
			<div class="pull-right">
				<button id="btnLogin" class="btn btn-info" type="submit"> Login </button>
			</div>
		</form>
	</div>
	
</div>