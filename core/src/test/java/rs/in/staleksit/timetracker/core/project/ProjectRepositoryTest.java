/**
 * 
 */
package rs.in.staleksit.timetracker.core.project;

import static org.testng.Assert.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import rs.in.staleksit.timetracker.core.project.ProjectImpl;
import rs.in.staleksit.timetracker.core.project.ProjectRepository;

/**
 * @author a.stoisavljevic
 *
 */
@Test(groups = {"unit", "repository", "rs.in.staleksit.timetracker.core.project.ProjectRepositoryTest"})
@ContextConfiguration(locations = {"classpath:/rs/in/staleksit/timetracker/core/ctx/timetracker-data-ctx.xml", 
		"classpath:/rs/in/staleksit/timetracker/core/ctx/test-timetracker-data-ctx.xml"})
public class ProjectRepositoryTest extends AbstractTestNGSpringContextTests {
	
	private ProjectRepository repository;
	
	@BeforeClass
	public void setUp() {
		repository = applicationContext.getBean(ProjectRepository.class);
	}
	
	public void testNotNull() {
		assertNotNull(repository);
	}
	
	public void testFindOne() {
		assertNotNull(repository);
		ProjectImpl result = repository.findOne(1);
		assertNotNull(result);
		assertTrue(result.getName().equals("Illness"));
	}

}
