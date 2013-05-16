define([
        'jquery', 
        'underscore', 
        'backbone',
        'text!templates/login/loginTemplate.html',
        'config',
        'util'
], function($, _, Backbone, loginTemplate, TimeTrackerConfig, Util) {
	var LoginView = Backbone.View.extend({
		
		el: $('#pageContainer'),
		
		initialize: function(opts) {
			this.router = opts.router;
			LoginView.self = this;
		},
		
		render: function() {
			this.$el.html(loginTemplate);
		},
		events: {
			"click #btnLogin": "login",
		},
		login: function() {
			var username = $(this.el).find("#j_username").val();
			var password = $(this.el).find("#j_password").val();
			$.ajax({
				url: TimeTrackerConfig.serverURL + 'api/login.json',
				data: {
					username: username,
					password: password
				},
				success: function(data) {
					if (data && data.status === "ok") {
						Util.login(username);
						LoginView.self.router.navigate("home", {trigger: true, pushState: true}); 
					} else {
						console.log('invalid login data. Status: ' + data.status);
					}
				}
			});
		},
	});
	
	return LoginView;
	
});