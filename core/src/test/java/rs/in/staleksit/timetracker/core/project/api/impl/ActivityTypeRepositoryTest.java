/**
 * 
 */
package rs.in.staleksit.timetracker.core.project.api.impl;

import static org.testng.Assert.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import rs.in.staleksit.timetracker.core.project.api.impl.ActivityTypeImpl;
import rs.in.staleksit.timetracker.core.project.api.impl.ActivityTypeRepository;

/**
 * @author a.stoisavljevic
 *
 */
@Test(groups = {"unit", "repository", "rs.in.staleksit.timetracker.core.project.ActivityTypeRepositoryTest"})
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
		ActivityTypeImpl result = repository.findOne(4);
		assertNotNull(result);
		assertTrue(result.getName().equals("coding"));
	}
	
}
