/**
 * 
 */
package rs.in.staleksit.timetracker.core.domain.account;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author a.stoisavljevic
 *
 */
public interface UserRepository extends
		PagingAndSortingRepository<UserImpl, Integer> {

}
