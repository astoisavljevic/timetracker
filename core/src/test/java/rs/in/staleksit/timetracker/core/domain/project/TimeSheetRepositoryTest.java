/**
 * 
 */
package rs.in.staleksit.timetracker.core.domain.project;

import static org.testng.Assert.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author a.stoisavljevic
 *
 */
@Test(groups = {"unit", "repository", "rs.in.staleksit.timetracker.core.domain.project.TimeSheetRepositoryTest"})
@ContextConfiguration(locations = {"classpath:/rs/in/staleksit/timetracker/core/ctx/timetracker-data-ctx.xml", 
		"classpath:/rs/in/staleksit/timetracker/core/ctx/test-timetracker-data-ctx.xml"})
public class TimeSheetRepositoryTest extends AbstractTestNGSpringContextTests {
	
	private TimeSheetRepository repository;
	
	@BeforeClass
	public void setUp() {
		repository = applicationContext.getBean(TimeSheetRepository.class);
	}
	
	public void testNotNull() {
		assertNotNull(repository);
	}
	
	public void testFindOne() {
		assertNotNull(repository);
		TimeSheetImpl result = repository.findOne(1);
		assertNotNull(result);
		assertEquals(result.getUser().getUsername(), "java");
	}


}
