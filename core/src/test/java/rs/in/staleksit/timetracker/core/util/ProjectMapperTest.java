package rs.in.staleksit.timetracker.core.util;

import static org.testng.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import rs.in.staleksit.timetracker.core.dto.ProjectDTO;
import rs.in.staleksit.timetracker.core.project.api.impl.ProjectImpl;

@Test(groups = {"unit", "core", "rs.in.staleksit.timetracker.core.util.ProjectMapperTest"})
public class ProjectMapperTest {
	
	private static final Logger log = LoggerFactory.getLogger(ProjectMapperTest.class);
	
	
	private static final String LOG_HOURS_REGEX_PATTERN = "\\b[ 0-9]{1,2}:[0-9]{2}\\b";
	
	private static final String LOG_HOURS_OK_1 = "8:00";
	private static final String LOG_HOURS_OK_2 = "08:00";
	private static final String LOG_HOURS_OK_3 = "4:15";
	private static final String LOG_HOURS_OK_4 = "0:15";
	private static final String LOG_HOURS_OK_5 = "1:30";
	
	
	// class under test
	private ProjectMapper projectMapper;
	
	public void testMapProject() {
		ProjectImpl projectImpl = new ProjectImpl();
		projectImpl.setName("project name");

		@SuppressWarnings("static-access")
		ProjectDTO projectDTO = projectMapper.map(projectImpl);
		
		assertNotNull(projectDTO);
		assertEquals(projectDTO.getName(), "project name");
	}
	
	public void testValid1() {
		Pattern p1 = Pattern.compile(LOG_HOURS_REGEX_PATTERN);
		Matcher m1 = p1.matcher(LOG_HOURS_OK_1);
		assertTrue(m1.matches());
	}
	
	public void testValid2() {
		Pattern p1 = Pattern.compile(LOG_HOURS_REGEX_PATTERN);
		Matcher m1 = p1.matcher(LOG_HOURS_OK_2);
		assertTrue(m1.matches());
	}
	
	public void testValid3() {
		Pattern p1 = Pattern.compile(LOG_HOURS_REGEX_PATTERN);
		Matcher m1 = p1.matcher(LOG_HOURS_OK_3);
		assertTrue(m1.matches());
	}
	
	public void testValid4() {
		Pattern p1 = Pattern.compile(LOG_HOURS_REGEX_PATTERN);
		Matcher m1 = p1.matcher(LOG_HOURS_OK_4);
		assertTrue(m1.matches());
	}
	
	public void testValid5() {
		Pattern p1 = Pattern.compile(LOG_HOURS_REGEX_PATTERN);
		Matcher m1 = p1.matcher(LOG_HOURS_OK_5);
		assertTrue(m1.matches());
	}
	
	public void testNotValid1() {
		Pattern p1 = Pattern.compile(LOG_HOURS_REGEX_PATTERN);
		Matcher m1 = p1.matcher("p");
		assertFalse(m1.matches());
	}
	
	

}
