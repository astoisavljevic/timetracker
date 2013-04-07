<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<script>

	// execute code on document ready
	$(document).ready(function() {
		$("#hours").focus();
		
		$("#projectName").typeahead({
			ajax: {
				url: "<c:url value='/project-list' />" + "?userId=" + ${currentUser.id},
				method: 'get',
				triggerLength: 1				
			},
			itemSelected: function(obj, itemValue, itemName) {
				$("#projectId").val(itemValue);
			}
		});
		
		$("#description").typeahead({
			ajax: {
				url: "<c:url value='/activitytype-list' />",
				method: 'get',
				triggerLength: 1				
			}
		});
	});
</script>	