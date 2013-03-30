/**
 * 
 */
package rs.in.staleksit.timetracker.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;

import rs.in.staleksit.timetracker.core.account.User;
import rs.in.staleksit.timetracker.core.account.api.UserService;

/**
 * @author a.stoisavljevic
 *
 */
public class UniqueNicknameConstraintValidator implements ConstraintValidator<UniqueNicknameConstraint, String> {
	
	private boolean excludeAuthenticatedUser;
	
	private UserService userService;
	
	@Autowired
	public UniqueNicknameConstraintValidator(@Qualifier("userService") UserService userService) {
		this.userService = userService;
	}

	@Override
	public void initialize(UniqueNicknameConstraint constraintAnnotation) {
		this.excludeAuthenticatedUser = constraintAnnotation.excludeAuthenticatedUser();
	}

	/**
	 * field is valid just in case that there are no other users with this username
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (excludeAuthenticatedUser) {
			if (SecurityContextHolder.getContext().getAuthentication() != null) {
				User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				if (user != null && user.getUsername().equals(value)) {
					return true;
				}
			} else {
				return true;
			}
		}
		return userService.findByUsername(value) == null; 
	}

}
