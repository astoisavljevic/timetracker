/**
 * 
 */
package rs.in.staleksit.timetracker.core.project.api.impl;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author a.stoisavljevic
 *
 */
public interface TaskTypeRepository extends
		PagingAndSortingRepository<TaskTypeImpl, Integer> {

}
