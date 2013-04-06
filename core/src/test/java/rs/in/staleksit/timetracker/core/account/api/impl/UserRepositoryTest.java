/**
 * 
 */
package rs.in.staleksit.timetracker.core.account.api.impl;

import static org.testng.Assert.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import rs.in.staleksit.timetracker.core.account.api.impl.UserImpl;
import rs.in.staleksit.timetracker.core.account.api.impl.UserRepository;

/**
 * @author a.stoisavljevic
 *
 */
@Test(groups = {"unit", "repository", "rs.in.staleksit.timetracker.core.account.api.UserRepositoryTest"})
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
	
	public void findByUsernameFound() {
		assertNotNull(repository);
		UserImpl user = repository.findByUsername("a.neric");
		assertNotNull(user);
		assertTrue(user.getId() == 2);
	}

	public void findByUsernameNotFound() {
		assertNotNull(repository);
		UserImpl user = repository.findByUsername("linux");
		assertNull(user);
	}
	
	public void findByEmail() {
		assertNotNull(repository);
		UserImpl user = repository.findByEmail("a.neric@yahoo.com");
		assertNotNull(user);
		assertEquals(user.getUsername(), "a.neric");
	}
	
	public void findByEmailNotFound() {
		assertNotNull(repository);
		UserImpl user = repository.findByEmail("p.petrovic@gmail.com");
		assertNull(user);
	}

}
