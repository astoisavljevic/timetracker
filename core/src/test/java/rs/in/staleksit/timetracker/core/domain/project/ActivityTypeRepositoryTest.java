/**
 * 
 */
package rs.in.staleksit.timetracker.core.domain.project;

import static org.testng.Assert.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import rs.in.staleksit.timetracker.core.domain.project.ActivityTypeImpl;
import rs.in.staleksit.timetracker.core.domain.project.ActivityTypeRepository;

/**
 * @author a.stoisavljevic
 *
 */
@Test(groups = {"unit", "repository", "rs.in.staleksit.timetracker.core.domain.project.ActivityTypeRepositoryTest"})
@ContextConfiguration(locations = {"classpath:/rs/in/staleksit/timetracker/core/ctx/timetracker-data-ctx.xml", 
		"classpath:/rs/in/staleksit/timetracker/core/ctx/test-timetracker-data-ctx.xml"})
public class ActivityTypeRepositoryTest extends AbstractTestNGSpringContextTests {
	
	private ActivityTypeRepository repository;
	
	@BeforeClass
	public void setUp() {
		repository = applicationContext.getBean(ActivityTypeRepository.class);
	}
	
	public void testNotNull() {
		assertNotNull(repository);
	}
	
	public void testFindOne() {
		assertNotNull(repository);
		ActivityTypeImpl result = repository.findOne(2);
		assertNotNull(result);
		assertTrue(result.getName().equals("Coding"));
	}
	
}
