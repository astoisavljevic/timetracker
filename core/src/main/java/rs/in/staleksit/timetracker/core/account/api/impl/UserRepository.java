/**
 * 
 */
package rs.in.staleksit.timetracker.core.account.api.impl;

import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * @author a.stoisavljevic
 *
 */
public interface UserRepository extends
		PagingAndSortingRepository<UserImpl, Integer> {
	
	UserImpl findByUsername(String username);

}
