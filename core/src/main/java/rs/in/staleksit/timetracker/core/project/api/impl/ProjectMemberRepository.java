/**
 * 
 */
package rs.in.staleksit.timetracker.core.project.api.impl;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author a.stoisavljevic
 *
 */
public interface ProjectMemberRepository extends
		PagingAndSortingRepository<ProjectMemberImpl, Integer>, QueryDslPredicateExecutor<ProjectMemberImpl> {
	
	
	

}
