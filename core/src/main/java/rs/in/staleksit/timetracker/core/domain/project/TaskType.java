/**
 * 
 */
package rs.in.staleksit.timetracker.core.domain.project;

/**
 * @author a.stoisavljevic
 *
 */
public interface TaskType {
	
	Integer getId();
	
	String getName();
	
	String getDescription();
	
	String getColor();
	
	String getStatus();

}
