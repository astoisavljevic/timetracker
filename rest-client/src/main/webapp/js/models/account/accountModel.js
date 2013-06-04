define([ 
        'underscore', 
        'backbone'
], function(_, Backbone) {
	
	var AccountModel = Backbone.Model.extend({
		urlRoot: '../timetracker/api/account.json',
		url: function() {
			return this.urlRoot + '?username=dj.ivancevic'; 
		},
		defaults: {
			username: 'admin',
			email: 'admin@admin',
			firstName: 'Admin',
			lastName: 'Admin'
		},
		
		initialize: function() {
			console.log('- account model initialized -')
		}
	});	
	
	return AccountModel;	
});