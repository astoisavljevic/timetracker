<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<script>
	// execute code on document ready
	$(document).ready(function() {

		$("#btnAccountCancel").click(function() {
			window.location.href = "<c:url value='/home' />";
		});
		
		$("#btnAccountChange").click(function() {
			var username = $("#btnAccountChange").attr('data-username');
			window.location.href = "<c:url value='/account-change/" + username +"'  />";
		});
		
	});
</script>	