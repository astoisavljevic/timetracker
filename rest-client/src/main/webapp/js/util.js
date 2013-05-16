define([
        'config'
],function(TimeTrackerConfig){
	var Util = {
			login: function(userId, username) {
				TimeTrackerConfig.username = username;
				TimeTrackerConfig.userId = userId;
			},
			logout: function() {
				TimeTrackerConfig.username = "";
				TimeTrackerConfig.userId = "";				
			}
	};
	
	
	
	return Util;
});