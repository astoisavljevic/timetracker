/**
 * 
 */
package rs.in.staleksit.timetracker.core.account.api;

import rs.in.staleksit.timetracker.core.account.User;

/**
 * @author a.stoisavljevic
 *
 */
public interface UserService {
	
	/**
	 * find user with given username.
	 * Username has unique index on User entity so result can be one and only one
	 * @param username
	 * @return 
	 */
	User findByUsername(String username);

}
