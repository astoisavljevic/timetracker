/**
 * 
 */
package rs.in.staleksit.timetracker.core.account;

import static org.testng.Assert.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import rs.in.staleksit.timetracker.core.account.UserImpl;
import rs.in.staleksit.timetracker.core.account.UserRepository;

/**
 * @author a.stoisavljevic
 *
 */
@Test(groups = {"unit", "repository", "rs.in.staleksit.timetracker.core.account.UserRepositoryTest"})
@ContextConfiguration(locations = {"classpath:/rs/in/staleksit/timetracker/core/ctx/timetracker-data-ctx.xml", 
		"classpath:/rs/in/staleksit/timetracker/core/ctx/test-timetracker-data-ctx.xml"})
public class UserRepositoryTest extends AbstractTestNGSpringContextTests {
	
	private UserRepository repository;
	
	@BeforeClass
	public void setUp() {
		repository = applicationContext.getBean(UserRepository.class);
	}
	
	public void testNotNull() {
		assertNotNull(repository);
	}
	
	public void testFindOne() {
		assertNotNull(repository);
		UserImpl result = repository.findOne(1);
		assertNotNull(result);
		assertTrue(result.getUsername().equals("admin"));
	}

}
