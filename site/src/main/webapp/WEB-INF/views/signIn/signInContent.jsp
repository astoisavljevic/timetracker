<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<c:set var="usernamePlaceholder">
	<fmt:message key="signInPage.username.placeholder" />
</c:set>
<c:set var="passwordPlaceholder">
	<fmt:message key="signInPage.password.placeholder" />
</c:set>
<c:set var="retypePasswordPlaceholder">
	<fmt:message key="signInPage.retypepassword.placeholder" />
</c:set>
<c:set var="emailPlaceholder">
	<fmt:message key="signInPage.email.placeholder" />
</c:set>
<c:set var="firstNamePlaceholder">
	<fmt:message key="signInPage.firstname.placeholder" />
</c:set>
<c:set var="lastNamePlaceholder">
	<fmt:message key="signInPage.lastname.placeholder" />
</c:set>

<div class="account-container">

	<div id="account-content" class="clearfix">
		<form:form id="signInForm" method="POST" commandName="signInUser">
			<fieldset>
				<div id="usernameControlGroup" class="control-group">
					<label class="control-label" for="username"><fmt:message key="signInPage.lblUsername" />:</label>
					<div class="controls">
						<form:input path="username" cssClass="input-xlarge" autocomplete="off" placeholder="${usernamePlaceholder}" />
						<span class="help-inline"><form:errors id="usernameError" path="username" /></span>
					</div>
				</div>
				<div id="passwordControlGroup" class="control-group">
					<label class="control-label" for="password"><fmt:message key="signInPage.lblPassword" />:</label>
					<div class="controls">
						<form:input path="password" type="password" cssClass="input-xlarge" placeholder="${passwordPlaceholder}"/>
						<span class="help-inline"><form:errors id="passwordError" path="password" /></span>
					</div>
				</div>
				<div id="retypePasswordControlGroup" class="control-group">
					<label class="control-label" for="retypePassword"><fmt:message key="signInPage.lblReTypePassword" />:</label>
					<div class="controls">
						<form:input path="retypePassword" type="password" cssClass="input-xlarge" placeholder="${retypePasswordPlaceholder}"/>
						<span class="help-inline"><form:errors id="retypePasswordError" path="retypePassword" /></span>
					</div>
				</div>
				<div id="emailControlGroup" class="control-group">
					<label class="control-label" for="email"><fmt:message key="signInPage.lblEmail" />:</label>
					<div class="controls">
						<form:input path="email" cssClass="input-xlarge" placeholder="${emailPlaceholder}"/>
						<span class="help-inline"><form:errors id="emailError" path="email" /></span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="firstName"><fmt:message key="signInPage.lblFirstName" />:</label>
					<div class="controls">
						<form:input path="firstName" cssClass="input-xlarge" placeholder="${firstNamePlaceholder}"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="lastName"><fmt:message key="signInPage.lblLastName" />:</label>
					<div class="controls">
						<form:input path="lastName" cssClass="input-xlarge" placeholder="${lastNamePlaceholder}"/>
					</div>
				</div>
				<div class="form-actions form-actions-account">
					<div class="pull-right">
						<button id="btnSignInSave" class="btn btn-primary" type="submit"><fmt:message key="signInPage.btnSave" /></button>
						<button id="btnSignInCancel" class="btn" type="reset"><fmt:message key="signInPage.btnCancel" /></button>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
	
	<div class="spacer20"></div>
			
</div>