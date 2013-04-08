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
	
	/**
	 * 
	 * @param query
	 * @return
	 */
	List<ActivityType> findAllActivityTypes(String query);
	
	
	/**
	 * 
	 * @param projectId
	 * @param query
	 * @return
	 */
	List<ProjectDTO> findAllProjectTasks(Integer projectId, String query);
	
}
