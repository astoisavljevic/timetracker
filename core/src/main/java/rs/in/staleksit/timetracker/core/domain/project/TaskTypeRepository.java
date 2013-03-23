/**
 * 
 */
package rs.in.staleksit.timetracker.core.domain.project;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author a.stoisavljevic
 *
 */
public interface TaskTypeRepository extends
		PagingAndSortingRepository<TaskTypeImpl, Integer> {

}
