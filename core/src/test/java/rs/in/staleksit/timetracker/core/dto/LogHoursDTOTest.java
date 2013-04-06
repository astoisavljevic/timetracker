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
@Test(groups = {"unit", "core", "rs.in.staleksit.timetracker.core.dto.LogHoursDTOTest"})
public class LogHoursDTOTest {

	// class under test
	private LogHoursDTO logHoursDTO;
	
	public void testDefaultConstructor() {
		logHoursDTO = new LogHoursDTO();
		assertNotNull(logHoursDTO);
	}
	
	public void testHours() {
		logHoursDTO = new LogHoursDTO();
		logHoursDTO.setHours("8:00");
		assertNotNull(logHoursDTO);
		
		assertEquals(logHoursDTO.getHours(), "8:00");
	}
	
	public void testProjectId() {
		logHoursDTO = new LogHoursDTO();
		logHoursDTO.setProjectId(1);
		assertNotNull(logHoursDTO);
		
		assertEquals(logHoursDTO.getProjectId().intValue(), 1);
	}
	
	public void testDescription() {
		logHoursDTO = new LogHoursDTO();
		logHoursDTO.setDescription("test description");
		assertNotNull(logHoursDTO);
		
		assertEquals(logHoursDTO.getDescription(), "test description");
	}
	
	public void testToString() {
		logHoursDTO = new LogHoursDTO();
		logHoursDTO.setHours("8:00");
		
		assertTrue(logHoursDTO.toString().contains("hours=8:00"));
	}
}
