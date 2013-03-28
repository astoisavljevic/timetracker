<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<div class="account-container">

	<div id="account-content" class="clearfix">
		<form id="accountForm" action="#">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="username">Username:</label>
					<div class="controls">
						<span class="input-xlarge uneditable-input">admin</span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="email">E-mail account:</label>
					<div class="controls">
						<span class="input-xlarge uneditable-input">admin@gmail.com</span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="firstName">First name:</label>
					<div class="controls">
						<span class="input-xlarge uneditable-input">Admin</span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="lastName">Last name:</label>
					<div class="controls">
						<span class="input-xlarge uneditable-input">Admin</span>
					</div>
				</div>
				<div class="form-actions form-actions-account">
					<div class="pull-right">
						<button class="btn btn-primary" type="submit">Change</button>
						<button class="btn" type="reset">Cancel</button>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
	
	<div class="spacer20"></div>
			
</div>