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
			<form id="logHoursForm" class="" action="#">
				<input class="input-mini" type="text" placeholder="HH:mm">
				<input id="project" class="input-medium" type="text" placeholder="Project" data-provide="typeahead" data-items="4">
				<input class="input-xlarge" type="text" placeholder="Description">
				<button class="btn" type="submit">Log!</button>
			</form>
		</div>
	</div>
	<div class="spacer5"></div>
	<div class="row">
		<div class="span12">
			<div class="page-header">
				<h3 id="lblYourRecentEntries">Your recent entries</h3>
			</div>
		</div>
	</div>	
</div>
