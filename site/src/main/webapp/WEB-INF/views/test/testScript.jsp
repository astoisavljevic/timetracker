<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<script>

	// execute code on document ready
	$(document).ready(function() {
		console.log("-+- test page loaded successfully -+-");
		
		/*
		$("#btnAjaxCall").click(function() {
			$.ajax({
				url: "<c:url value='/project-list' />",
				async: false,
				data: {
					userId: 1,
					query: "l"
				},
				success: function(data) {
					console.log("data: " + data);
				}
			});
		});
		*/
		
		/*
		$("#inAjaxCall").typeahead({
			source: function(typeahead, query) {
				return $.ajax({
					url: "<c:url value='/project-list' />",
					async: false,
					data: {
						query: query,
						userId: 1
					},
					success: function(data) {
						return typeahead(data);
					}
				});
			},
			display: "name"
		});
		*/
		$("#inAjaxCall").typeahead({
			ajax: {
				url: "<c:url value='/project-list' />" + "?userId=" + 1,
				method: "GET",
				triggerLength: 1
			},
			itemSelected:function(item, value, name) {
				console.log("item: [value: " + value + "; name:" + name + "]");
			} 
		});
		
	});
	
</script>	