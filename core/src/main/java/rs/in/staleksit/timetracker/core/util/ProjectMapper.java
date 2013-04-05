/**
 * 
 */
package rs.in.staleksit.timetracker.core.util;

import java.util.ArrayList;
import java.util.List;

import rs.in.staleksit.timetracker.core.dto.ProjectDTO;
import rs.in.staleksit.timetracker.core.project.Project;

/**
 * @author a.stoisavljevic
 *
 */
public class ProjectMapper {
	
	public static ProjectDTO map(Project project) {
		ProjectDTO result = new ProjectDTO(project.getId(), project.getName());
		return result;
	}
	
	public static List<ProjectDTO> map(List<Project> projects) {
		List<ProjectDTO> result = new ArrayList<ProjectDTO>();
		for (Project project: projects) {
			result.add(map(project));
		}
		return result;
	}

}
