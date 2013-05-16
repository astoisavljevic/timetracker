/**
 * 
 */
package rs.in.staleksit.timetracker.core.account;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author a.stoisavljevic
 *
 */
public interface User extends UserDetails {
	
	Integer getId();
	
	String getEmail();
	
	String getFirstName();
	
	String getLastName();
	
	Date getBirthDate();
	
	void merge(Object source, String... properties);
	

}
