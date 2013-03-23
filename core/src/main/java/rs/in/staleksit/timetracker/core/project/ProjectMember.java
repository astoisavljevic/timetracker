/**
 * 
 */
package rs.in.staleksit.timetracker.core.project;

import rs.in.staleksit.timetracker.core.account.User;

/**
 * @author a.stoisavljevic
 *
 */
public interface ProjectMember {
	
	Project getProject();
	
	User getUser();
	
}
