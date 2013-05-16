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
			this.$el.html(homeTemplate);
			$.ajax({
				url: TimeTrackerConfig.serverURL + 'api/project-list.json',
				data: {
					username: TimeTrackerConfig.username,
				},
				success: function(data) {
					if (data && data.status === "ok") {
						var profileImageSrc = TimeTrackerConfig.serverURL + 'img/profiles/' + TimeTrackerConfig.userId + ".png";
						$('#profileImage').attr('src', profileImageSrc);
						$('#mainNavigationSection').css("display", "block");
					} else {
						console.log('invalid login data. Status: ' + data.status);
					}
				}
			});
			
		}
		
	});
	
	return HomeView;
	
});