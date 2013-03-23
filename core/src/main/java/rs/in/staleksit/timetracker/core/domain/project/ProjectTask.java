/**
 * 
 */
package rs.in.staleksit.timetracker.core.domain.project;

import java.math.BigDecimal;
import java.util.Date;

import rs.in.staleksit.timetracker.core.domain.account.User;

/**
 * @author a.stoisavljevic
 *
 */
public interface ProjectTask {
	
	Integer getId();
	
	Project getProject();
	
	User getUser();
	
	TaskType getTaskType();
	
	String getName();
	
	String getDescription();
	
	Date getStartOn();
	
	Date getDueOn();
	
	BigDecimal getBidHours();
	
	String getColor();
	
	String getStatus();
	
}
