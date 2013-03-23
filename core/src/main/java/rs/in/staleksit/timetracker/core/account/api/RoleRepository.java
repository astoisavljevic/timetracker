/**
 * 
 */
package rs.in.staleksit.timetracker.core.account.api;

import org.springframework.data.repository.PagingAndSortingRepository;

import rs.in.staleksit.timetracker.core.account.api.impl.RoleImpl;

/**
 * @author a.stoisavljevic
 *
 */
public interface RoleRepository extends PagingAndSortingRepository<RoleImpl, Integer>{
	
}
