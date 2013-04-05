<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<script>

	// execute code on document ready
	$(document).ready(function() {
		$("#hours").focus();
		
		$("#project").typeahead({
			ajax: {
				url: "<c:url value='/project-list' />" + "?userId=" + ${currentUser.id},
				method: 'get',
				triggerLength: 1
			}
		});
	});
</script>	