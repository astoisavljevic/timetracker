/**
 * 
 */
package rs.in.staleksit.timetracker.core.account;

import static org.testng.Assert.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import rs.in.staleksit.timetracker.core.account.RoleImpl;
import rs.in.staleksit.timetracker.core.account.RoleRepository;

/**
 * @author a.stoisavljevic
 *
 */
@Test(groups = {"unit", "repository", "rs.in.staleksit.timetracker.core.account.RoleRepositoryTest"})
@ContextConfiguration(locations = {"classpath:/rs/in/staleksit/timetracker/core/ctx/timetracker-data-ctx.xml", 
		"classpath:/rs/in/staleksit/timetracker/core/ctx/test-timetracker-data-ctx.xml"})
public class RoleRepositoryTest extends AbstractTestNGSpringContextTests {
	
	private RoleRepository repository;
	
	@BeforeClass
	public void setUp() {
		repository = applicationContext.getBean(RoleRepository.class);
	}
	
	public void testNotNull() {
		assertNotNull(repository);
	}
	
	public void testFindOne() {
		assertNotNull(repository);
		RoleImpl result = repository.findOne(1);
		assertNotNull(result);
		assertTrue(result.getAuthority().equals("ADMIN"));
	}


}
