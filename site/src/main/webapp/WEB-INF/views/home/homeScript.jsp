<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<script>
	var canvasData1 = [
		{ value: 53.1, color:"#F38630" },
		{ value: 100, color: "#E0E4CC"}
	];
	var canvasData2 = [{value: 18.75, color:"#F38630"}, {value: 100, color: "#E0E4CC"}];
	// execute code on document ready
	$(document).ready(function() {
		new Chart(document.getElementById("canvas1").getContext("2d")).Pie(canvasData1);
		new Chart(document.getElementById("canvas2").getContext("2d")).Pie(canvasData2);
		
		$("#hours").focus();

		var projectListLabels, projectListMapped;

		$("#projectName").typeahead({
			  source: function (query, process) { 
				  return $.get("<c:url value='/project-list' />", { query: query, userId: ${currentUser.id} }, function (data) {
					projectListLabels = [];
					projectListMapped = {};
			      	$.each(data, function (i, item) { 
			      		projectListMapped[item.name] = item.id;
			      		projectListLabels.push(item.name);
			      	});
			      	process(projectListLabels);
			      });
			  },
			  updater: function(item) {
				  $("#projectId").val(projectListMapped[item]);
				  return item;
			  }
			});
		
		var projectTaskLabels, projectTaskMapped;

		$("#description").typeahead({
			  source: function (query, process) { 
				  return $.get("<c:url value='/projecttask-list' />", { query: query, projectId: $("#projectId").val() }, function (data) {
					  projectTaskLabels = [];
					  projectTaskMapped = {};
			      	$.each(data, function (i, item) { 
			      		projectTaskMapped[item.name] = item.id;
			      		projectTaskLabels.push(item.name);
			      	});
			      	process(projectTaskLabels);
			      });
			  },
			  updater: function(item) {
				  $("#projectTaskId").val(projectTaskMapped[item]);
				  return item;
			  }
			});
		
	});
	
</script>	