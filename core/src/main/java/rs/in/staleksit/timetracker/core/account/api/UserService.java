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
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	User save(User user);
	
	
	/**
	 * find user with given email. Email in the system must be unique
	 * @param email
	 * @return
	 */
	User findByEmail(String email);
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param email
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	User create(String username, String password, String email, String firstName, String lastName);
}
