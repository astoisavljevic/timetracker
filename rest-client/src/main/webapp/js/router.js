define(['jquery', 'underscore', 'backbone'], function($, _, Backbone) {

	var TimeTrackerRouter = Backbone.Router.extend({
		routes: {
			"start": "start",
			"login": "login",
			"*actions": "defaultRoute"
		},
		defaultRoute: function() {
			console.log('-+- defaultRoute -+-');
		}
	});
	
	var initialize = function() {
		
		var timeTrackerRouter = new TimeTrackerRouter;
		
		timeTrackerRouter.on('route:start', function() {
			console.log('-+- start -+-');
		});
		
		timeTrackerRouter.on('route:login', function() {
			console.log('-+- login -+-');
		});
		
		
		Backbone.history.start();
	};
	
	return {
		initialize:initialize
	};
});


