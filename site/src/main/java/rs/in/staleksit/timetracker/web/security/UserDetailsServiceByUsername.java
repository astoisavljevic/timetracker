/**
 * 
 */
package rs.in.staleksit.timetracker.web.security;

import org.springframework.beans.factory.annotation.Autowired;

import rs.in.staleksit.timetracker.core.account.User;
import rs.in.staleksit.timetracker.core.account.api.UserService;

/**
 * @author a.stoisavljevic
 *
 */
public class UserDetailsServiceByUsername extends AbstractUserDetailsService {

	@Autowired
	public UserDetailsServiceByUsername(UserService userService) {
		super(userService);
	}

	@Override
	protected User findUser(String username) {
		return getUserService().findByUsername(username);
	}

}
