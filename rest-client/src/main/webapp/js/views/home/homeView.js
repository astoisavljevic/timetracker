define([
        'jquery', 
        'underscore', 
        'backbone',
        'text!templates/home/homeTemplate.html',
        'config'
], function($, _, Backbone, homeTemplate, TimeTrackerConfig) {
	var HomeView = Backbone.View.extend({
		el: $('#pageContainer'),
		
		initialize: function(opts) {
			this.router = opts.router;
		},
		
		render: function() {
			$.ajax({
				url: TimeTrackerConfig.serverURL + 'api/project-list.json',
				data: {
					username: TimeTrackerConfig.username,
				},
				success: function(data) {
					if (data && data.status === "ok") {
						console.log('fetched data from server');
					} else {
						console.log('invalid login data. Status: ' + data.status);
					}
				}
			});
			
			this.$el.html(homeTemplate);
		}
	});
	
	return HomeView;
	
});