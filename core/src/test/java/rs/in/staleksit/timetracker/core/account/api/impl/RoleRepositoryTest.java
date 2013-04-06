/**
 * 
 */
package rs.in.staleksit.timetracker.core.account.api.impl;

import static org.testng.Assert.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import rs.in.staleksit.timetracker.core.account.api.impl.RoleImpl;
import rs.in.staleksit.timetracker.core.account.api.impl.RoleRepository;

/**
 * @author a.stoisavljevic
 *
 */
@Test(groups = {"unit", "repository", "rs.in.staleksit.timetracker.core.account.api.RoleRepositoryTest"})
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
	
	public void testGetVersionOfEntity() {
		assertNotNull(repository);
		RoleImpl result = repository.findOne(1);
		assertNotNull(result);
		assertEquals(result.getVersion().intValue(), 0);
	}
	
	public void testToString() {
		assertNotNull(repository);
		RoleImpl result = repository.findOne(1);
		assertNotNull(result);
		assertTrue(result.toString().contains("name=ADMIN,version=0,id=1"));
	}
	


}
