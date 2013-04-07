package rs.in.staleksit.timetracker.core.project.api.impl;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ActivityTypeRepository extends PagingAndSortingRepository<ActivityTypeImpl, Integer>, 
	QueryDslPredicateExecutor<ActivityTypeImpl> {

}
