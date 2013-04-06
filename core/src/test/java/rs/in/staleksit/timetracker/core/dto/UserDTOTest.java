/**
 * 
 */
package rs.in.staleksit.timetracker.core.dto;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import rs.in.staleksit.timetracker.core.account.api.impl.UserImpl;

/**
 * @author a.stoisavljevic
 *
 */
@Test(groups = {"unit", "core", "rs.in.staleksit.timetracker.core.dto.UserDTOTest"})
public class UserDTOTest {
	
	// class under test
	private UserDTO userDTO;
	
	public void testDefaultConstrctor() {
		userDTO = new UserDTO();
		
		assertNotNull(userDTO);
	}
	
	public void testFullConstructor() {
		UserImpl userImpl = new UserImpl();
		userImpl.setUsername("username");
		userImpl.setEmail("test@test.com");
		userImpl.setFirstName("test");
		userImpl.setLastName("lastname");
		
		userDTO = new UserDTO(userImpl);
		
		assertNotNull(userDTO);
	}
	
	public void testUsername() {
		userDTO = new UserDTO();
		userDTO.setUsername("username");
		
		assertNotNull(userDTO);
		
		assertEquals(userDTO.getUsername(), "username");
	}
	
	
	public void testEmail() {
		userDTO = new UserDTO();
		userDTO.setEmail("test@test.com");
		
		assertNotNull(userDTO);
		
		assertEquals(userDTO.getEmail(), "test@test.com");
		
	}
	
	public void testFirstname() {
		userDTO = new UserDTO();
		userDTO.setFirstName("test");
		
		assertNotNull(userDTO);
		
		assertEquals(userDTO.getFirstName(), "test");
	}
	
	public void testLastname() {
		userDTO = new UserDTO();
		userDTO.setLastName("name");
		
		assertNotNull(userDTO);
		
		assertEquals(userDTO.getLastName(), "name");
	}
	
	
	public void testToString() {
		userDTO = new UserDTO();
		userDTO.setEmail("test@test.com");

		assertTrue(userDTO.toString().contains("email=test@test.com"));
	}
}
