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
public class UniqueEmailConstraintValidator implements ConstraintValidator<UniqueEmailConstraint, String> {

	
	private boolean excludeAuthenticatedUser;
	
	private UserService userService;
	
	@Autowired
	public UniqueEmailConstraintValidator(@Qualifier("userService") UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public void initialize(UniqueEmailConstraint constraintAnnotation) {
		this.excludeAuthenticatedUser = constraintAnnotation.excludeAuthenticatedUser();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (excludeAuthenticatedUser) {
			if (SecurityContextHolder.getContext().getAuthentication() != null) {
				User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				if (user != null && user.getEmail().equals(value)) {
					return true;
				}
			} else {
				return true;
			}
		}
		return userService.findByEmail(value) == null;
	}

}
