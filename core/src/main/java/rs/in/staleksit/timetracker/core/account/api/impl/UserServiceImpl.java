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
	private RoleRepository roleRepository;
	
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User save(User user) {
		return userRepository.save((UserImpl)user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User create(String username, String password, String email, String firstName, String lastName) {
		UserImpl newUser = new UserImpl(username, password, email, firstName, lastName);
		RoleImpl userRole = roleRepository.findOne(2);
		newUser.setRole(userRole);
		return (User)newUser;
	}

	@Override
	public User findOne(Integer userId) {
		return userRepository.findOne(userId);
	}
	
	

}
