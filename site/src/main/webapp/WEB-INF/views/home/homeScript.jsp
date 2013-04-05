<%@ include file="/WEB-INF/common/taglibs.jsp" %>

<script>

	var projects = [
	   { id:1, name: 'Illness' },
	   { id:2, name: 'JKP Cistoca' },
	   { id:3, name: 'Kick-off' },
	   { id:4, name: 'Startup Accademy' },
	   { id:5, name: 'Argo' },
	   { id:6, name: 'Heiniken' },
	   { id:7, name: 'Amstel' },
	   { id:8, name: 'Timetracker' },
	   { id:9, name: 'Levi9BB' }
	];
	   
	// execute code on document ready
	$(document).ready(function() {
		$("#project").typeahead({source: projects});
	});
</script>	