<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<script>

	// execute code on document ready
	$(document).ready(function() {
		console.log("-+- test page loaded successfully -+-");
		
		$("#btnAjaxCall").click(function() {
			$.getJSON("<c:url value='/project-list' />", {userId: ${currentUser.id}, query: "i"}, function(data) {
				console.log('data[0]: ' + data[0].id);
			});
		});
		
		var labels, mapped;
		
		$("#inAjaxCall").typeahead({
		  source: function (query, process) { 
			  return $.get("<c:url value='/project-list' />", { query: query, userId: ${currentUser.id} }, function (data) {
		      	labels = [];
		      	mapped = {};
		      	$.each(data, function (i, item) { 
		      		mapped[item.name] = item.id;
		      		labels.push(item.name);
		      	});
		      	process(labels);
		      });
		  },
		  updater: function(item) {
			  alert('item id: ' + mapped[item]);
			  return item;
		  }
		});

		
		/**
		$("#inAjaxCall").typeahead({
			source:  function(process, query) {
				return $.getJSON("<c:url value='/project-list' />", {userId: ${currentUser.id}, query: query}, function(data) {
					process(data);
				});	
			}
		});
		**/

		/**
		$("#inAjaxCall").typeahead({
			source:  function(process, query) {
				return $.ajax({
					url: "<c:url value='/project-list' />",
					type: "GET",
					dataType: "json",
					data: {
						userId: ${currentUser.id},
						query: query
					},
					success: function(data) {
						process(data);						
					}
				});
			} 
		});
		**/
		
		/** 
		$("#btnAjaxCall").click(function() {
			$.ajax({
				url: "<c:url value='/project-list' />",
				async: false,
				data: {
					userId: ${currentUser.id},
					query: "i"
				},
				success: function(data) {
					console.log("data: " + data);
				}
			});
		});
		**/
		
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
