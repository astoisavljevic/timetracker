/**
 * 
 */
package rs.in.staleksit.timetracker.web.security.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author a.stoisavljevic
 *
 */
public class SecurityUtils {
	
	/**
	 * retrieve auth. object
	 * @return
	 */
	public static Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	/**
	 * retrieve username - used as principal
	 * @return
	 */
	public static String getPrincipal() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		if ( authentication == null) {
			return null;
		} else {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			return userDetails.getUsername();
		}
	}
}
