<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<div class="account-container">

	<div id="account-content" class="clearfix">
		<form:form id="accountEditForm" method="POST" commandName="user">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="username">Username:</label>
					<div class="controls">
						<span class="input-xlarge uneditable-input">${user.username}</span>
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
						<button id="btnAccountChangeSave" class="btn btn-primary" type="submit">Save</button>
						<button id="btnAccountChangeCancel" class="btn" type="reset">Cancel</button>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
	
	<div class="spacer20"></div>
			
</div>