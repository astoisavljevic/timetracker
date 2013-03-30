/**
 * 
 */
package rs.in.staleksit.timetracker.web.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;

import rs.in.staleksit.timetracker.core.account.User;

/**
 * @author a.stoisavljevic
 *
 */
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1165828095458835521L;
	
	@NotEmpty(message = "{error.username.empty}")
	private String username;
	
	@NotEmpty(message = "{error.email.empty}")
	private String email;
	
	private String firstName;
	
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
