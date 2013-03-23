/**
 * 
 */
package rs.in.staleksit.timetracker.core.project;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author a.stoisavljevic
 *
 */
public interface ProjectRepository extends PagingAndSortingRepository<ProjectImpl, Integer> {

}
