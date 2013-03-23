/**
 * 
 */
package rs.in.staleksit.timetracker.core.account.api;

import org.springframework.data.repository.PagingAndSortingRepository;

import rs.in.staleksit.timetracker.core.account.api.impl.UserImpl;

/**
 * @author a.stoisavljevic
 *
 */
public interface UserRepository extends
		PagingAndSortingRepository<UserImpl, Integer> {
	
	UserImpl findByUsername(String username);

}
