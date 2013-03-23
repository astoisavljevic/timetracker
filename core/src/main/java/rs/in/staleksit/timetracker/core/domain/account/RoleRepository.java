/**
 * 
 */
package rs.in.staleksit.timetracker.core.domain.account;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author a.stoisavljevic
 *
 */
public interface RoleRepository extends PagingAndSortingRepository<RoleImpl, Integer>{
	
}
