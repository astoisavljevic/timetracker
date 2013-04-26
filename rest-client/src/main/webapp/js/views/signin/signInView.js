define([
        'jquery', 
        'underscore', 
        'backbone',
        'text!templates/signIn/signInTemplate.html',
], function($, _, Backbone, signInTemplate) {
	var SignInView = Backbone.View.extend({
		el: $('#pageContainer'),
		
		initialize: function(opts) {
			this.router = opts.router;
		},

		
		render: function() {
			this.$el.html(signInTemplate);
		},
		events: {
			"click #btnSignInSave": "signin",
			"click #btnSignInCancel": "cancel",
		},
		signin: function() {
			console.log("-+- go to server and signin -+-");
		},
		cancel: function() {
			console.log("-+- go back -+-");
		}
		
	});
	
	return SignInView;
	
});