/**
 * 
 */
package rs.in.staleksit.timetracker.core.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author a.stoisavljevic
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UniqueEmailConstraintValidator.class)
public @interface UniqueEmailConstraint {
	
	String message() default "{rs.in.staleksit.timetracker.unique.email}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	

}
