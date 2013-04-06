/**
 * 
 */
package rs.in.staleksit.timetracker.core.project;

import static org.testng.Assert.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import rs.in.staleksit.timetracker.core.project.api.impl.TaskTypeImpl;
import rs.in.staleksit.timetracker.core.project.api.impl.TaskTypeRepository;

/**
 * @author a.stoisavljevic
 *
 */
@Test(groups = {"unit", "repository", "rs.in.staleksit.timetracker.core.project.TaskTypeRepositoryTest"})
@ContextConfiguration(locations = {"classpath:/rs/in/staleksit/timetracker/core/ctx/timetracker-data-ctx.xml", 
		"classpath:/rs/in/staleksit/timetracker/core/ctx/test-timetracker-data-ctx.xml"})
public class TaskTypeRepositoryTest extends AbstractTestNGSpringContextTests {
	
	private TaskTypeRepository repository;
	
	@BeforeClass
	public void setUp() {
		repository = applicationContext.getBean(TaskTypeRepository.class);
	}
	
	public void testNotNull() {
		assertNotNull(repository);
	}
	
	public void testFindOne() {
		assertNotNull(repository);
		TaskTypeImpl result = repository.findOne(1);
		assertNotNull(result);
		assertTrue(result.getName().equals("Features"));
	}
	

}
