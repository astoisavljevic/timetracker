define([
        'config'
],function(TimeTrackerConfig){
	var Util = {
			login: function(username) {
				TimeTrackerConfig.username = username;
				console.log('set username in store');
			}
	};
	
	return Util;
});