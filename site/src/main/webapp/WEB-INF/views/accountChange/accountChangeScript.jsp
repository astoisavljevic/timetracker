<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<script>
	// execute code on document ready
	$(document).ready(function() {
		
		$("#btnAccountChangeCancel").click(function() {
			window.location.href = "<c:url value='/account' />";
		});

	});
</script>	