<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<% pageContext.setAttribute("now", new org.joda.time.DateTime()); %>

<div class="container">
	<div class="home-title">
		<span>Timesheet for <joda:format value="${now}" pattern="EEEE, dd/MMM/yyyy" /> </span>
	</div>
	<div class="spacer5"></div>
	<div class="row">
		<div class="span12">
			<form:form id="logHoursForm" class="well" method="POST" commandName="logHours">
				<form:input path="hours" cssClass="input-mini" placeholder="HH:mm" autocomplete="off"/>
				<form:hidden path="projectId"/>
				<input id="projectName" name="projectName" placeholder="Project name" class="input-medium" type="text" autocomplete="off" data-provide="typeahead"/>
				<form:hidden path="projectTaskId"/>
				<form:input id="description" path="description" cssClass="input-xlarge" placeholder="Description" autocomplete="off" data-provide="typeahead"/>
				<button class="btn" type="submit">Log!</button>
			</form:form>
		</div>
	</div>
	<div class="spacer5"></div>
	<div class="row">
		<div class="span12">
			<div class="page-header">
				<div id="profileImageHolder"><img src="<c:url value="/img/profiles/${currentUser.id}.png" />" /></div><h3 id="lblYourRecentEntries">Your recent entries</h3>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>	
</div>
