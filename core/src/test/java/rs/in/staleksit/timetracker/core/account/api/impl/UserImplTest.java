/**
 * 
 */
package rs.in.staleksit.timetracker.core.account.api.impl;

import static org.testng.Assert.*;

import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.testng.annotations.Test;

/**
 * @author a.stoisavljevic
 *
 */
@Test(groups = {"unit", "core", "model", "rs.in.staleksit.timetracker.core.account.api.impl.UserImplTest"})
public class UserImplTest {
	
	// class under test
	private UserImpl user;
	
	
	public void testDefaultConstrcutor() {
		user = new UserImpl();
		
		assertNotNull(user);
	}
	
	public void testFullConstructor() {
		user = new UserImpl("admin", "admin", "admin@gmail.com", null, null);
		
		assertNotNull(user);
		assertEquals(user.getEmail(), "admin@gmail.com");
		assertTrue(user.isEnabled());
	}
	
	public void testRole() {
		RoleImpl role = new RoleImpl();
		role.setName("ROLE_USER");
		
		user = new UserImpl("developer", "developer", "developer@gmail.com", null, null);
		user.setRole(role);
		
		assertNotNull(user);
		assertEquals(user.getRole().getName(), "ROLE_USER");
	}
	
	public void testGrantedAuthorities() {
		RoleImpl role = new RoleImpl();
		role.setName("ROLE_USER");
		
		user = new UserImpl("developer", "developer", "developer@gmail.com", null, null);
		user.setRole(role);
		
		assertNotNull(user);
		assertEquals(user.getAuthorities().size(), 1);
		assertTrue(((GrantedAuthority)((ArrayList<? extends GrantedAuthority>)user.getAuthorities()).get(0)).getAuthority().equals("ROLE_USER"));
	}
	
	public void testFirstName() {
		user = new UserImpl();
		user.setFirstName("Petar");
		
		assertNotNull(user);
		assertEquals(user.getFirstName(), "Petar");
	}
	
	public void testLastName() {
		user = new UserImpl();
		user.setLastName("Petrovic");
		
		assertNotNull(user);
		assertEquals(user.getLastName(), "Petrovic");
	}
	
	public void testExcludedAttributes() {
		user = new UserImpl();
		
		assertNotNull(user);
		assertEquals(user.getExcludedAttributes().length, 1);
		assertTrue(user.getExcludedAttributes()[0].equals("role"));
	}
	
	public void testIsAccountNonExpired() {
		user = new UserImpl();
		
		assertNotNull(user);
		assertTrue(user.isAccountNonExpired());
	}
	
	public void testIsAccountNonLocked() {
		user = new UserImpl();
		
		assertNotNull(user);
		assertTrue(user.isAccountNonLocked());
	}
	
	public void testIsCredentialsNonExpired() {
		user = new UserImpl();
		
		assertNotNull(user);
		assertTrue(user.isCredentialsNonExpired());		
	}
	
	public void testPassword() {
		user = new UserImpl();
		user.setPassword("password");
		
		assertNotNull(user);
		assertEquals(user.getPassword(), "password");
	}
	
	
	
}
