/**
 * 
 */
package rs.in.staleksit.timetracker.core.project;

import java.math.BigDecimal;
import java.util.Date;

import rs.in.staleksit.timetracker.core.account.User;

/**
 * @author a.stoisavljevic
 * 
 */
public interface TimeSheet {
	
	Integer getId();
	
	ProjectTask getProjectTask();
	
	User getUser();
	
	ActivityType getActivityType();
	
	Date getStartedAt();
	
	BigDecimal getHours();
	
	String getDescription();
	
	String getStatus();
	
	void merge(Object source, String... properties);

}
