/**
 * 
 */
package rs.in.staleksit.timetracker.web.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import rs.in.staleksit.timetracker.core.account.User;
import rs.in.staleksit.timetracker.core.validation.UniqueEmailConstraint;
import rs.in.staleksit.timetracker.core.validation.UniqueNicknameConstraint;

/**
 * @author a.stoisavljevic
 *
 */
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1165828095458835521L;
	
	private static final String EMAIL_REG_EXP = "\\b[a-zA-Z0-9._%+-]+@[a-z0-9-]+\\.[a-z]{2,4}\\b";
	
	@NotEmpty(message = "{validation.fieldMustNotBeEmpty}")
	@Length(max = 30, message = "{validation.fieldExceedsMaxLength}")
	@UniqueNicknameConstraint
	private String username;
	
	@NotEmpty(message = "{validation.fieldMustNotBeEmpty}")
	@Email(regexp = EMAIL_REG_EXP, message="{validation.emailFormat}")
	@UniqueEmailConstraint
	private String email;
	
	@Length(max = 80, message = "{validation.fieldExceedsMaxLength}")
	private String firstName;
	
	@Length(max = 80, message = "{validation.fieldExceedsMaxLength}")
	private String lastName;
	
	public UserDTO() {
		
	}
	
	public UserDTO(User user) {
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
