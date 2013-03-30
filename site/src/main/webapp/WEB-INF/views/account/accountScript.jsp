<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<script>
	// execute code on document ready
	$(document).ready(function() {

		$("#btnAccountCancel").click(function() {
			window.location.href = "<c:url value='/home' />";
			return false;
		});
		
		$("#btnAccountChange").click(function() {
			var username = $("#btnAccountChange").attr('data-username');
			var accountChangeUrl = "<c:url value='/accountChange/" + username + "' />";
			window.location.href = accountChangeUrl;
			return false;
		});
		
	});
</script>	