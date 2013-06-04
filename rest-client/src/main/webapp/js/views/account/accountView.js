define([
        'jquery', 
        'underscore', 
        'backbone',
        'text!templates/account/accountTemplate.html',
        'config',
        'models/account/accountModel'
], function($, _, Backbone, accountTemplate, TimeTrackerConfig, AccountModel) {
		
	var accountModel = new AccountModel({username: 'dj.ivancevic'});
	
	var AccountView = Backbone.View.extend({
		el: $('#pageContainer'),
		
		model: accountModel,
			
		initialize: function() {
			console.log(' -+- accountView initialized -+-');
			this.model.fetch();
			_.bindAll(this, 'render');			
		},
		
		render: function() { 
			this.$el.html(_.template(accountTemplate, this.model.toJSON()));
		}
		
		
	}); 
	
	return AccountView;
	
});