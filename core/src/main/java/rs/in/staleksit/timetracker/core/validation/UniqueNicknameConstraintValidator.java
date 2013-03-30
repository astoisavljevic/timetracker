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
public class UniqueNicknameConstraintValidator implements ConstraintValidator<UniqueNicknameConstraint, String> {
	
	private UserService userService;
	
	@Autowired
	public UniqueNicknameConstraintValidator(@Qualifier("userService") UserService userService) {
		this.userService = userService;
	}

	@Override
	public void initialize(UniqueNicknameConstraint constraintAnnotation) {
		//
	}

	/**
	 * field is valid just in case that there are no other users with this username
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return userService.findByUsername(value) == null; 
	}

}
