define([
        'jquery', 
        'underscore', 
        'backbone',
        'text!templates/start/startTemplate.html',
], function($, _, Backbone, startTemplate) {
	var StartView = Backbone.View.extend({
		el: $('#pageContainer'),
		
		initialize: function(opts) {
			this.router = opts.router;
		},

		
		render: function() {
			this.$el.html(startTemplate);
		},
		events: {
			"click #btnLogin": "login",
			"click #btnSignIn": "signin"
		},
		login: function() {
			this.router.navigate("login", {trigger: true, pushState: true});
			return false;
		},
		signin: function() {
			this.router.navigate("signIn", {trigger: true});
			return false;
		}
	});
	
	return StartView;
	
});