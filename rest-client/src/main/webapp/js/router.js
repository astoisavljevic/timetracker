var TimeTrackerRouter = Backbone.Router.extend({
	routes: {
		"*actions": "defaultRoute"
	},
	defaultRoute: function() {
		console.log('-+- defaultRoute -+-');
	}
});