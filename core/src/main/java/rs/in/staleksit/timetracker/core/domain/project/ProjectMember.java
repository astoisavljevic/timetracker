/**
 * 
 */
package rs.in.staleksit.timetracker.core.domain.project;

import rs.in.staleksit.timetracker.core.domain.account.User;

/**
 * @author a.stoisavljevic
 *
 */
public interface ProjectMember {
	
	Project getProject();
	
	User getUser();
	
}
