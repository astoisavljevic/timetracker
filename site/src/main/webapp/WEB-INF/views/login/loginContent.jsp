<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<div class="login-container">

	<div id="login-header">
		<h3>Login</h3>
	</div>
	
	<div id="login-content" class="clearfix">
		<form action="<c:url value="/home" />">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="username">Username</label>
					<div class="controls">
						<input id="username" class="" type="text" placeholder="Username">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="username">Password</label>
					<div class="controls">
						<input id="password" class="" type="text" placeholder="Password">
					</div>
				</div>				
			</fieldset>
			<div class="pull-right">
				<button class="btn btn-info" type="submit"> Login </button>
			</div>
		</form>
	</div>
	
</div>