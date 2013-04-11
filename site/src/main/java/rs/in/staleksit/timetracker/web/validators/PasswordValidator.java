/**
 * 
 */
package rs.in.staleksit.timetracker.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import rs.in.staleksit.timetracker.core.dto.SignInDTO;

/**
 * @author aleksandar
 *
 */
@Component("passwordValidator")
public class PasswordValidator implements Validator {

	/**
	 * @see http://www.vaannila.com/spring/spring-form-validation-1.html
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return SignInDTO.class.isAssignableFrom(clazz);
	}

	/**
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		SignInDTO signInDTO = (SignInDTO) target;
		
		if (!signInDTO.getPassword().equals(signInDTO.getRetypePassword())) {
			errors.rejectValue("password", "rs.in.staleksit.timetracker.password.notSame");
			errors.rejectValue("retypePassword", "rs.in.staleksit.timetracker.password.notSame");
		}

	}

}
