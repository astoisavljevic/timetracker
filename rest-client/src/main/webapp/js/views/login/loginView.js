define([
        'jquery', 
        'underscore', 
        'backbone',
        'text!templates/login/loginTemplate.html',
], function($, _, Backbone, loginTemplate) {
	var LoginView = Backbone.View.extend({
		el: $('#pageContainer'),
		
		initialize: function(opts) {
			this.router = opts.router;
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
				url: "http://localhost:8080/timetracker/api/login.json",
				data: {
					username: username,
					password: password
				},
				success: function(data) {
					if (data && data.status === "ok") {
						console.log("data: username:" + data.username); 
					} else {
						console.log('invalid login data. Status: ' + data.status);
					}
				}
			});
		},
	});
	
	return LoginView;
	
});