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
			<spring:hasBindErrors name="logHours">
				<div class="alert alert-error">
					<strong>Error</strong>
					<ul>
						<c:forEach var="error" items="${errors.allErrors}">
							<li>${error.field} ${error.defaultMessage}</li>
						</c:forEach>
					</ul>
				</div>
			</spring:hasBindErrors>
			<form:form id="logHoursForm" class="well" method="POST" commandName="logHours">
				<form:input path="hours" cssClass="input-mini" placeholder="HH:mm" autocomplete="off"/>
				<form:hidden path="projectId"/>
				<form:input path="projectName" placeholder="Project name" cssClass="input-medium" autocomplete="off" data-provide="typeahead" />
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
			<c:if test="${fn:length(loggedHours) gt 0}">
				<table class="table table-bordered table-striped table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Hours</th>
							<th>Description</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="logHoursRecord" items="${loggedHours}" varStatus="theCount">
							<tr>
								<td>${theCount.index+1}</td>
								<td>${logHoursRecord.hours}</td>
								<td>${logHoursRecord.description}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>	
</div>
