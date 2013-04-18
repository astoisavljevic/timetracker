<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<script>
	// execute code on document ready
	$(document).ready(function() {
		
		$("#theme").val($.cookie("ttTheme"));
		
		$("#btnAccountChangeCancel").click(function() {
			window.location.href = "<c:url value='/account' />";
			return false;
		});
		
		$("#btnAccountChangeSave").click(function(event) {
			event.preventDefault();
			var themeKey = $("#theme").val();
			$.cookie("ttTheme", themeKey, 10000);
			$("#accountEditForm").submit();
		});

	});
</script>	