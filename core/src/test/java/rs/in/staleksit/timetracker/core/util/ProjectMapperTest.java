package rs.in.staleksit.timetracker.core.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import rs.in.staleksit.timetracker.core.dto.ProjectDTO;
import rs.in.staleksit.timetracker.core.project.api.impl.ProjectImpl;

@Test(groups = {"unit", "core", "rs.in.staleksit.timetracker.core.util.ProjectMapperTest"})
public class ProjectMapperTest {
	
	// class under test
	private ProjectMapper projectMapper;
	
	public void testMapProject() {
		ProjectImpl projectImpl = new ProjectImpl();
		projectImpl.setName("project name");

		@SuppressWarnings("static-access")
		ProjectDTO projectDTO = projectMapper.map(projectImpl);
		
		Assert.assertNotNull(projectDTO);
		Assert.assertEquals(projectDTO.getName(), "project name");
	}

}
