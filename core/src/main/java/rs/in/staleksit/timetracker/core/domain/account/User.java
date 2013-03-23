/**
 * 
 */
package rs.in.staleksit.timetracker.core.domain.account;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author a.stoisavljevic
 *
 */
public interface User extends UserDetails {
	
	String getEmail();
	
	String getFirstName();
	
	String getLastName();
	

}
