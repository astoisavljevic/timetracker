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

}
