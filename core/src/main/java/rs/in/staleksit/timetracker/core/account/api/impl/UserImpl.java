/**
 * 
 */
package rs.in.staleksit.timetracker.core.account.api.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import rs.in.staleksit.timetracker.core.account.User;
import rs.in.staleksit.timetracker.core.common.AbstractDomainModel;

/**
 * @author a.stoisavljevic
 *
 */
@Entity
@Table(name = "stt_user")
public class UserImpl extends AbstractDomainModel implements User {
	private static final long serialVersionUID = -6523798643017729784L;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "username", nullable = false, length = 30)
	private String username;
	
	@Column(name = "password", nullable = false, length = 30)
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "enabled")
	private Boolean enabled;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private RoleImpl role;
	
	/**
	 * default constructor
	 */
	public UserImpl() {
		
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param email
	 * @param firstName
	 * @param lastName
	 */
	public UserImpl(String username, String password, String email, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.enabled = true;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<RoleImpl> grantedAuthorities = new ArrayList<RoleImpl>();
		grantedAuthorities.add(role);
		return grantedAuthorities;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
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

	public RoleImpl getRole() {
		return role;
	}

	public void setRole(RoleImpl role) {
		this.role = role;
	}

	@Override
	protected String[] getExcludedAttributes() {
		return new String[] {"role"};
	}

}
