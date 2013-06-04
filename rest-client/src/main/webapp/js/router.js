define([
        'jquery', 
        'underscore', 
        'backbone',
        'views/start/startView',
        'views/login/loginView',
        'views/signin/signInView',
        'views/home/homeView',
        'views/account/accountView',
        'util'
], function($, _, Backbone, StartView, LoginView, SignInView, HomeView, AccountView, Util) {

	var TimeTrackerRouter = Backbone.Router.extend({
		routes: {
			"": "start",
			"login": "login",
			"signIn": "signin",
			"home": "home",
			"logout": "start",
			"account": "account"
		},
		start: function() {
			Util.logout();
			var startView = new StartView({router: this});
			startView.render();
		},
		login: function() {
			var loginView = new LoginView({router: this});
			loginView.render();
		},
		signin: function() {
			var signInView = new SignInView({router: this});
			signInView.render();
		},
		home: function() {
			var homeView = new HomeView({router: this});
			homeView.render();
		},
		account: function() {
			var accountView = new AccountView({router: this});
			accountView.render();
		}
	});
	
	var initialize = function() {
		
		var timeTrackerRouter = new TimeTrackerRouter;
				
		Backbone.history.start();
	};
	
	return {
		initialize:initialize
	};
});


