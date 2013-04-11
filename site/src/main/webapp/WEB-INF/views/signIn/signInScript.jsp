<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<script>
	// execute code on document ready
	$(document).ready(function() {
		
		if ($("#usernameError").length > 0) {
			$("#usernameControlGroup").addClass('error');
		}
		
		if ($("#emailError").length > 0) {
			$("#emailControlGroup").addClass('error');
		}
		
		if ($("#passwordError").length > 0) {
			$("#passwordControlGroup").addClass('error');
		}
		
		if ($("#retypePasswordError").length > 0) {
			$("#retypePasswordControlGroup").addClass('error');
		}
		
		$("#btnSignInCancel").click(function() {
			window.location.href = "<c:url value='/start' />";
		});
	});
</script>	