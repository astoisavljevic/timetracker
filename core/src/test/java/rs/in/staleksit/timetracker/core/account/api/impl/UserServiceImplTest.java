/**
 * 
 */
package rs.in.staleksit.timetracker.core.account.api.impl;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import java.util.ArrayList;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.GrantedAuthority;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import rs.in.staleksit.timetracker.core.account.User;

/**
 * @author a.stoisavljevic
 *
 */
@Test(groups = {"unit", "service", "rs.in.staleksit.timetracker.core.account.api.impl.UserServiceImplTest"})
public class UserServiceImplTest {
	
	private UserServiceImpl userService;
	
	// mocks
	@Mock
	private UserRepository userRepository;
	@Mock
	private RoleRepository roleRepository;
	
	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		userService = new UserServiceImpl(userRepository, roleRepository);
	}
	
	public void testNotNull() {
		assertNotNull(userService);
	}
	
	public void findUserByUsername() {
		UserImpl user = new UserImpl();
		user.setEmail("java.developer@gmail.com");
		user.setEnabled(Boolean.TRUE);
		user.setUsername("java");
		
		
		when(userRepository.findByUsername("java")).thenReturn(user);
		
		User result = userService.findByUsername("java");
		
		assertNotNull(result);
		assertEquals(result.getEmail(), "java.developer@gmail.com");
		
	}
	
	public void findUserByEmailNotFound() {
		when(userRepository.findByEmail("p.petrovic@gmail.com")).thenReturn(null);

		User result = userService.findByEmail("p.petrovic@gmail.com");
		assertNull(result);
	}
	
	public void findUserByEmailFound() {
		UserImpl user = new UserImpl();
		user.setEmail("java.developer@gmail.com");
		user.setEnabled(Boolean.TRUE);
		user.setUsername("java");
		
		when(userRepository.findByEmail(user.getEmail())).thenReturn(user);
		
		User result = userService.findByEmail(user.getEmail());
		assertNotNull(result);
		assertEquals(result.getUsername(), "java");
	}
	
	public void testSaveUser() {
		UserImpl user = new UserImpl();
		user.setEmail("java.developer@gmail.com");
		user.setEnabled(Boolean.TRUE);
		user.setUsername("java");
		
		when(userRepository.save(user)).thenReturn(user);
		
		User result = userService.save(user);
		
		assertNotNull(result);
		assertEquals(result.getEmail(), "java.developer@gmail.com");
	}
	
	public void testCreate() {
		RoleImpl role = new RoleImpl();
		role.setName("ROLE_USER");
		
		when(roleRepository.findOne(2)).thenReturn(role);
		
		User result = userService.create("developer", "developer", "developer@gmail.com", null, null);
		
		assertNotNull(result);
		assertEquals(((ArrayList<? extends GrantedAuthority>)result.getAuthorities()).get(0).getAuthority(), "ROLE_USER");
	}
	
	

}
