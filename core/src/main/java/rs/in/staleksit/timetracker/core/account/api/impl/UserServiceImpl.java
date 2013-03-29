/**
 * 
 */
package rs.in.staleksit.timetracker.core.account.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.in.staleksit.timetracker.core.account.User;
import rs.in.staleksit.timetracker.core.account.api.UserService;

/**
 * @author a.stoisavljevic
 *
 */
@Service("userService")
class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User findByUsername(String username) {
		return (User) userRepository.findByUsername(username);
	}

	@Override
	public User save(User user) {
		return userRepository.save((UserImpl)user);
	}

}
