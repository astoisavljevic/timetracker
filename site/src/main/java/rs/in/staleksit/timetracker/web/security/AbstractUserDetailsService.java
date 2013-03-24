/**
 * 
 */
package rs.in.staleksit.timetracker.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import rs.in.staleksit.timetracker.core.account.User;
import rs.in.staleksit.timetracker.core.account.api.UserService;

/**
 * @author a.stoisavljevic
 *
 */
public abstract class AbstractUserDetailsService implements UserDetailsService {
	
	private UserService userService;
	
	@Autowired
	public AbstractUserDetailsService(UserService userService) {
		this.userService = userService;
	}
	
	protected UserService getUserService() {
		return userService;
	}

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = findUser(username);
		if (user == null) {
			throw new UsernameNotFoundException("User with given username [" + username + "] can't be found.");
		}
		return user;
	}
	
	protected abstract User findUser(String username);

}
