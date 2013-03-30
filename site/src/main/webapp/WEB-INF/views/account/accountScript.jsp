<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<script>
	// execute code on document ready
	$(document).ready(function() {

		$("#btnAccountCancel").click(function() {
			window.location.href = "<c:url value='/home' />";
		});
		
		$("#btnAccountChange").click(function() {
			var username = $("#btnAccountChange").attr('data-username');
			alert('username: ' + username);
			var accountChangeUrl = "<c:url value='/accountChange/" + username + "' />";
			alert('url: ' + accountChangeUrl);
			window.location.href = accountChangeUrl;
		});
		
	});
</script>	