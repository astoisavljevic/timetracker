/**
 * 
 */
package rs.in.staleksit.timetracker.core.project.api.impl;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author a.stoisavljevic
 *
 */
public interface ProjectTaskRepository extends
		PagingAndSortingRepository<ProjectTaskImpl, Integer> {

}
