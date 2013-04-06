/**
 * 
 */
package rs.in.staleksit.timetracker.core.account.api.impl;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author a.stoisavljevic
 *
 */
@Test(groups = {"unit", "core", "model", "rs.in.staleksit.timetracker.core.account.api.impl.RoleImplTest"})
public class RoleImplTest {

	// class under test
	private RoleImpl role;
	
	@BeforeClass
	public void setUp() {
		role = new RoleImpl();
	}
	
	public void testName() {
		assertNotNull(role);
		role.setName("ROLE_USER");
		
		assertEquals(role.getName(), "ROLE_USER");
	}
	
	public void testToString() {
		assertNotNull(role);
		role.setName("ROLE_USER");
		
		assertTrue(role.toString().contains("name=ROLE_USER"));
		
	}
	
}
