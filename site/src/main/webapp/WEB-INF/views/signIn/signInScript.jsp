<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<script>
	// execute code on document ready
	$(document).ready(function() {
		
		$("#btnSignInCancel").click(function() {
			window.location.href = "<c:url value='/start' />";
		});
	});
</script>	