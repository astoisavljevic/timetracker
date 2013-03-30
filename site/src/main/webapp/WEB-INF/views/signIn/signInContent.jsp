<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<div class="account-container">

	<div id="account-content" class="clearfix">
		<form:form id="signInForm" method="POST" commandName="signInUser">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="username">Username:</label>
					<div class="controls">
						<form:input path="username" cssClass="input-xlarge"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="password">Password:</label>
					<div class="controls">
						<form:input path="password" type="password" cssClass="input-xlarge"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="retypePassword">Re-type password:</label>
					<div class="controls">
						<form:input path="retypePassword" type="password" cssClass="input-xlarge"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="email">E-mail account:</label>
					<div class="controls">
						<form:input path="email" cssClass="input-xlarge"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="firstName">First name:</label>
					<div class="controls">
						<form:input path="firstName" cssClass="input-xlarge"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="lastName">Last name:</label>
					<div class="controls">
						<form:input path="lastName" cssClass="input-xlarge" />
					</div>
				</div>
				<div class="form-actions form-actions-account">
					<div class="pull-right">
						<button id="btnSignInSave" class="btn btn-primary" type="submit">Save</button>
						<button id="btnSignInCancel" class="btn" type="reset">Cancel</button>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
	
	<div class="spacer20"></div>
			
</div>