/**
 * 
 */
package rs.in.staleksit.timetracker.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import rs.in.staleksit.timetracker.core.account.api.UserService;

/**
 * @author a.stoisavljevic
 *
 */
public class UniqueEmailConstraintValidator implements ConstraintValidator<UniqueEmailConstraint, String> {

	private UserService userService;
	
	@Autowired
	public UniqueEmailConstraintValidator(@Qualifier("userService") UserService userService) {
		this.userService = userService;
	}
	
	
	@Override
	public void initialize(UniqueEmailConstraint constraintAnnotation) {
		//
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return userService.findByEmail(value) == null;
	}

}
