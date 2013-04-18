<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<div class="account-container">

	<div id="account-content" class="clearfix">
		<form:form id="accountEditForm" method="POST" commandName="user">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="username"><fmt:message key="accountChangePage.lblUsername" />:</label>
					<div class="controls">
						<span class="input-xlarge uneditable-input">${currentUser.username}</span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="email"><fmt:message key="accountChangePage.lblEmail" />:</label>
					<div class="controls">
						<form:input path="email" cssClass="input-xlarge"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="firstName"><fmt:message key="accountChangePage.lblFirstname" />:</label>
					<div class="controls">
						<form:input path="firstName" cssClass="input-xlarge"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="lastName"><fmt:message key="accountChangePage.lblLastname" />:</label>
					<div class="controls">
						<form:input path="lastName" cssClass="input-xlarge" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="theme"><fmt:message key="accountChangePage.lblTheme" />:</label>
					<div class="controls">
						<select id="theme" name="theme" class="input-xlarge">
							<option value="default">United</option>
							<option value="simplex">Simplex</option>
							<option value="slate">Slate</option>
							<option value="spacelab">Spacelab</option>
						</select>
					</div>
				</div>
				
				
				<div class="form-actions form-actions-account">
					<div class="pull-right">
						<button id="btnAccountChangeSave" class="btn btn-primary" type="submit"><fmt:message key="accountChangePage.btnSave" /></button>
						<button id="btnAccountChangeCancel" class="btn" type="reset"><fmt:message key="accountChangePage.btnCancel" /></button>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
	
	<div class="spacer20"></div>
			
</div>