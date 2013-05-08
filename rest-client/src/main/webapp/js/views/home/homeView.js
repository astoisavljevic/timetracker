define([
        'jquery', 
        'underscore', 
        'backbone',
        'text!templates/home/homeTemplate.html',
], function($, _, Backbone, homeTemplate) {
	var HomeView = Backbone.View.extend({
		el: $('#pageContainer'),
		
		initialize: function(opts) {
			this.router = opts.router;
		},
		
		render: function() {
			this.$el.html(homeTemplate);
		}
	});
	
	return HomeView;
	
});