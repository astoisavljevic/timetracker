/**
 * 
 */
package rs.in.staleksit.timetracker.web.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author a.stoisavljevic
 *
 */
public class SignInDTO extends UserDTO implements Serializable {
	private static final long serialVersionUID = -9143532838458257935L;
	
	@NotEmpty(message = "{error.password.empty}")
	private String password;
	
	@NotEmpty(message = "{error.retypePassword.empty}")
	private String retypePassword;
	
	public SignInDTO() {

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
