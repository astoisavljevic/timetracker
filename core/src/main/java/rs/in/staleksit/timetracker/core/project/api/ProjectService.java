/**
 * 
 */
package rs.in.staleksit.timetracker.core.project.api;

import java.util.List;

import rs.in.staleksit.timetracker.core.dto.ProjectDTO;
import rs.in.staleksit.timetracker.core.project.ActivityType;

/**
 * @author a.stoisavljevic
 *
 */
public interface ProjectService {
	
	/**
	 * This method have to retrieve all projects that user is applied to
	 * @param userId
	 * @return
	 */
	List<ProjectDTO> findAllProjectsForUser(Integer userId, String query);
	
	List<ActivityType> findAllActivityTypes(String query);

}
