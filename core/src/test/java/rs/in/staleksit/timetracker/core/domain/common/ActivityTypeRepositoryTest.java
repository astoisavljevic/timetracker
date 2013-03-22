/**
 * 
 */
package rs.in.staleksit.timetracker.core.domain.common;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author a.stoisavljevic
 *
 */
@Test(groups = {"unit", "repository", "rs.in.staleksit.timetracker.core.domain.common.ActivityTypeRepositoryTest"})
@ContextConfiguration(locations = {"classpath:/rs/in/staleksit/timetracker/core/ctx/timetracker-data-ctx.xml", 
		"classpath:/rs/in/staleksit/timetracker/core/ctx/test-timetracker-data-ctx.xml"})
public class ActivityTypeRepositoryTest extends AbstractTestNGSpringContextTests {
	
	public void testDummy() {
		System.out.println("test");
	}
}
