/**
 * 
 */
package rs.in.staleksit.timetracker.core.util;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import rs.in.staleksit.timetracker.core.account.api.impl.UserImpl;

/**
 * @author a.stoisavljevic
 *
 */
@Test(groups = {"unit", "model", "core", "rs.in.staleksit.timetracker.core.util.BeanPropertyUtilsTest"})
public class BeanPropertyUtilsTest {
	
	public void testCopyBeanProperties() {
		UserImpl user1 = new UserImpl("admin", "admin", "admin@gmail.com", "Admin", "Admin");
		UserImpl user2 = new UserImpl();
		
		BeanPropertyUtils.copyBeanProperties(user1, user2, new String[]{});
		
		assertNotNull(user1);
		assertNotNull(user2);
		
		assertEquals(user2.getEmail(), "admin@gmail.com");
		
	}

}
