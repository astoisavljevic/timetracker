<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<% pageContext.setAttribute("now", new org.joda.time.DateTime()); %>

<div class="container">
	<div class="home-title">
		<span>Timesheet for <joda:format value="${now}" pattern="EEEE, dd/MMM/yyyy" /> </span>
	</div>
	<table class="table table-bordered table-striped table-hover">
		<thead>
			<tr>
				<th>Time</th>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1h30m</td>
				<td>Bug fixing</td>
			</tr>
			<tr>
				<td>30m</td>
				<td>RP-234 Some issue</td>
			</tr>		
			<tr>
				<td>1h</td>
				<td>RP-235 Lorem ipsum</td>
			</tr>		
			<tr>
				<td>2h</td>
				<td>RP-236 dolor sit namen</td>
			</tr>		
			<tr>
				<td>1h45m</td>
				<td>RP-237 other</td>
			</tr>		
			<tr>
				<td>1h15m</td>
				<td>RP-238 other</td>
			</tr>							
		</tbody>
	</table>
</div>
