<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<div class="container">
	<div class="row">
		<div class="span6">
			<c:choose>
				<c:when test="${statusCode == 403}">
					<h1 class="error-code color-red"><fmt:message key="error.lblError" /> 403</h1>
					<p class="error-description muted">
						<fmt:message key="error.lblError403" />
					</p>
				</c:when>
				<c:when test="${statusCode == 404}">
					<h1 class="error-code color-red"><fmt:message key="error.lblError" /> 404</h1>
					<p class="error-description muted">
						<fmt:message key="error.lblError404" />
					</p>
				</c:when>
				<c:when test="${statusCode == 405}">
					<h1 class="error-code color-red"><fmt:message key="error.lblError" /> 405</h1>
					<p class="error-description muted">
						<fmt:message key="error.lblError405" />
					</p>
				</c:when>
				<c:when test="${statusCode == 500}">
					<h1 class="error-code color-red"><fmt:message key="error.lblError" /> 500</h1>
					<p class="error-description muted">
						<fmt:message key="error.lblError500" />
					</p>
				</c:when>				
				<c:when test="${statusCode == 503}">
					<h1 class="error-code color-red"><fmt:message key="error.lblError" /> 503</h1>
					<p class="error-description muted">
						<fmt:message key="error.lblError503" />
					</p>
				</c:when>
				<c:otherwise>
					<h1 class="error-code color-red"><fmt:message key="error.lblError" /> 500</h1>
					<p class="error-description muted">
						<fmt:message key="error.lblErrorGeneric" />
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