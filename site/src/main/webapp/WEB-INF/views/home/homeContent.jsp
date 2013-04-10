<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<c:set var="projectNamePlaceholder">
	<fmt:message key="homePage.projectname.placeholder" />
</c:set>
<c:set var="descriptionPlaceholder">
	<fmt:message key="homePage.description.placeholder" />
</c:set>

<% pageContext.setAttribute("now", new org.joda.time.DateTime()); %>

<div class="container">
	<div class="home-title">
		<span><fmt:message key="homePage.lblTimeSheetFor"/> <joda:format value="${now}" pattern="EEEE, dd/MMM/yyyy" /> </span>
	</div>
	<div class="spacer5"></div>
	<div class="row">
		<div class="span12">
			<spring:hasBindErrors name="logHours">
				<div class="alert alert-error">
					<strong><fmt:message key="homePage.lblError" /></strong>
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
				<form:input path="projectName" placeholder="${projectNamePlaceholder}" cssClass="input-medium" autocomplete="off" data-provide="typeahead" />
				<form:hidden path="projectTaskId"/>
				<form:input id="description" path="description" cssClass="input-xlarge" placeholder="${descriptionPlaceholder}" autocomplete="off" data-provide="typeahead"/>
				<button class="btn" type="submit"><fmt:message key="homePage.btnLog" /></button>
			</form:form>
		</div>
	</div>
	<div class="spacer5"></div>
	<div class="row">
		<div class="span12">
			<div class="page-header">
				<div id="profileImageHolder"><img src="<c:url value="/img/profiles/${currentUser.id}.png" />" /></div><h3 id="lblYourRecentEntries"><fmt:message key="homePage.lblRecentEntries"/></h3>
				<div class="clearfix"></div>
			</div>
			<c:if test="${fn:length(loggedHours) gt 0}">
				<table class="table table-bordered table-striped table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th><fmt:message key="homePage.table.header.lblHours" /></th>
							<th><fmt:message key="homePage.table.header.lblDescription" /></th>
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
				<div class="pagination pagination-centered">
					<ul>
						<li class="active">
							<a href="#">1</a>
						</li>
						<li>
							<a href="#">2</a>
						</li>
						<li>
							<a href="#">3</a>
						</li>						
					</ul>
				</div>
			</c:if>
		</div>
	</div>	
</div>
