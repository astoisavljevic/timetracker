/**
 * 
 */
package rs.in.staleksit.timetracker.core.dto;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

/**
 * @author a.stoisavljevic
 *
 */
@Test(groups = {"unit", "core", "rs.in.staleksit.timetracker.core.dto.SignInDTOTest"})
public class SignInDTOTest {
	
	// class under test
	private SignInDTO signInDTO;
	
	public void testDefaultConstructor() {
		signInDTO = new SignInDTO();
		
		assertNotNull(signInDTO);
	}
	
	public void testPassword() {
		signInDTO = new SignInDTO();
		signInDTO.setPassword("password");
		
		assertNotNull(signInDTO);
		assertEquals(signInDTO.getPassword(), "password");
	}
	
	public void testReTypePassword() {
		signInDTO = new SignInDTO();
		signInDTO.setRetypePassword("retypePassword");
		
		assertNotNull(signInDTO);
		assertEquals(signInDTO.getRetypePassword(), "retypePassword");		
	}
	
	

}
