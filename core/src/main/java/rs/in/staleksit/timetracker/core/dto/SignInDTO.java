/**
 * 
 */
package rs.in.staleksit.timetracker.core.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import rs.in.staleksit.timetracker.core.validation.UniqueNicknameConstraint;

/**
 * @author a.stoisavljevic
 *
 */
public class SignInDTO extends UserDTO implements Serializable {
	private static final long serialVersionUID = -9143532838458257935L;
	
	@NotEmpty(message = "{validation.fieldMustNotBeEmpty}")
	@Length(max = 30, message = "{validation.fieldExceedsMaxLength}")
	@UniqueNicknameConstraint(excludeAuthenticatedUser = false)
	private String username;
	
	@NotEmpty(message = "{validation.fieldMustNotBeEmpty}")
	@Length(max = 30, message = "{validation.fieldExceedsMaxLength}")
	private String password;
	
	@NotEmpty(message = "{validation.fieldMustNotBeEmpty}")
	@Length(max = 30, message = "{validation.fieldExceedsMaxLength}")
	private String retypePassword;
	
	public SignInDTO() {

	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}
	
}
