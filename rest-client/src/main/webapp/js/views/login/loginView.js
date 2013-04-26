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
			console.log("-+- go to server and log -+-");
		},
	});
	
	return LoginView;
	
});