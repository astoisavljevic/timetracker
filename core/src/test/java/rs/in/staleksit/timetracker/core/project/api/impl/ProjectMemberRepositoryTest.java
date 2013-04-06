/**
 * 
 */
package rs.in.staleksit.timetracker.core.project.api.impl;

import static org.testng.Assert.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import rs.in.staleksit.timetracker.core.project.api.impl.ProjectMemberImpl;
import rs.in.staleksit.timetracker.core.project.api.impl.ProjectMemberRepository;

/**
 * @author a.stoisavljevic
 *
 */
@Test(groups = {"unit", "repository", "rs.in.staleksit.timetracker.core.project.ProjectMemberRepositoryTest"})
@ContextConfiguration(locations = {"classpath:/rs/in/staleksit/timetracker/core/ctx/timetracker-data-ctx.xml", 
		"classpath:/rs/in/staleksit/timetracker/core/ctx/test-timetracker-data-ctx.xml"})
public class ProjectMemberRepositoryTest extends AbstractTestNGSpringContextTests {
	
	private ProjectMemberRepository repository;
	
	@BeforeClass
	public void setUp() {
		repository = applicationContext.getBean(ProjectMemberRepository.class);
	}
	
	public void testNotNull() {
		assertNotNull(repository);
	}

	public void testFindOne() {
		ProjectMemberImpl result = repository.findOne(1);
		assertNotNull(result);
		// first project - user mapping is user admin has project Illness
		assertEquals(result.getUser().getUsername(), "admin");
	}
	
	
		

}
