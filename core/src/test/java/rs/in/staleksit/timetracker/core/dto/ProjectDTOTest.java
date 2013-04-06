/**
 * 
 */
package rs.in.staleksit.timetracker.core.dto;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

/**
 * @author a.stoisavljevic
 *
 */
@Test(groups = {"unit", "core", "rs.in.staleksit.timetracker.core.dto.ProjectDTOTest"})
public class ProjectDTOTest {

	// class under test
	private ProjectDTO projectDTO;
	
	
	public void testDefaultConstrcutor() {
		projectDTO = new ProjectDTO();
		assertNotNull(projectDTO);
	}
	
	public void testConstrcutor() {
		projectDTO = new ProjectDTO(1, "test name");
		assertNotNull(projectDTO);
	}
	
	public void testId() {
		projectDTO = new ProjectDTO();
		projectDTO.setId(1);
		
		assertNotNull(projectDTO);
		assertEquals(projectDTO.getId().intValue(), 1);
	}
	
	public void testName() {
		projectDTO = new ProjectDTO();
		projectDTO.setName("test name");
		
		assertNotNull(projectDTO);
		assertEquals(projectDTO.getName(), "test name");
	}
	
	public void testToString() {
		projectDTO = new ProjectDTO(1, "test name");
		assertNotNull(projectDTO);

		assertTrue(projectDTO.toString().contains("name=test name"));
	}
	
	

}


