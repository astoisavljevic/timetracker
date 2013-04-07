<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<div class="container">
	<div class="row">
		<div class="span6">
			<c:choose>
				<c:when test="${statusCode == 403}">
					<h1 class="error-code color-red">Error 403</h1>
					<p class="error-description muted">
						The request was a legal request, but the server is refusing to respond to it
					</p>
				</c:when>
				<c:when test="${statusCode == 404}">
					<h1 class="error-code color-red">Error 404</h1>
					<p class="error-description muted">
						Oops! The requested page could not be found
					</p>
				</c:when>
				<c:when test="${statusCode == 405}">
					<h1 class="error-code color-red">Error 405</h1>
					<p class="error-description muted">
						A request was made of a page using a request method not supported by that page
					</p>
				</c:when>
				<c:when test="${statusCode == 500}">
					<h1 class="error-code color-red">Error 500</h1>
					<p class="error-description muted">
						A generic error message, given when no more specific message is suitable
					</p>
				</c:when>				
				<c:when test="${statusCode == 503}">
					<h1 class="error-code color-red">Error 503</h1>
					<p class="error-description muted">
						The server is currently unavailable (overloaded or down)
					</p>
				</c:when>
				<c:otherwise>
					<h1 class="error-code color-red">Error 500</h1>
					<p class="error-description muted">
						A generic error message, given when no more specific message is suitable
					</p>
				</c:otherwise>								
			</c:choose>
		</div>
	</div>
	<!-- StatusCode: ${statusCode} -->
	<!-- Reason: ${reason} -->			
	<!-- RequestedURI: ${requestedURI} -->
	<!-- Exception: ${exception} -->
</div>