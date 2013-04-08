<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<script>

	// execute code on document ready
	$(document).ready(function() {
		$("#hours").focus();
		
		$("#projectName").typeahead({
			ajax: {
				url: "<c:url value='/project-list' />" + "?userId=" + ${currentUser.id},
				method: "GET",
				triggerLength: 1
			},
			itemSelected:function(item, value, name) {
				$("#projectId").val(value);
			} 
		});
		
		$("#description").typeahead({
			ajax: {
				url: "<c:url value='/projecttask-list' />" + "?projectId=" + $("#projectId").val(),
				method: "GET",
				triggerLength: 1
			},
			itemSelected:function(item, value, name) {
				$("#projectTaskId").val(value);
			} 
		});
		
	});
	
</script>	