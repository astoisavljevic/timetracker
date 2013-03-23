/**
 * 
 */
package rs.in.staleksit.timetracker.core.domain.project;

import java.util.Date;

/**
 * @author a.stoisavljevic
 */
public interface Project {
	
	Integer getId();
	
	String getName();
	
	String getDescription();
	
	Date getStartOn();
	
	String getColor();
	
	String getCompanyCode();
	
	String getCompanyName();
	
	String getStatus();

}
