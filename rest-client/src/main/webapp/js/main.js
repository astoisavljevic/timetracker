require.config({
	urlArgs: "bust=" + (new Date()).getTime(),
	paths: {
		jquery: 'libs/jquery/jquery-1.9.1.min',
		underscore: 'libs/underscore/underscore-min',
		backbone: 'libs/backbone/backbone-min',
		templates: '../templates'
	},
	shim: {
		underscore: {
			exports: '_'
		},
		backbone: {
			deps: ["underscore", "jquery"],
			exports: "Backbone"
		}
	}
});

require([
         'app',
], function(App) {
	App.initialize();
});