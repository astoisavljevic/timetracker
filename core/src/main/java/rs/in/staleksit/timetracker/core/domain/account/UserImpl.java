/**
 * 
 */
package rs.in.staleksit.timetracker.core.domain.account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import rs.in.staleksit.timetracker.core.domain.common.AbstractDomainModel;

/**
 * @author a.stoisavljevic
 *
 */
@Entity
@Table(name = "stt_user")
public class UserImpl extends AbstractDomainModel implements UserDetails {
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

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<RoleImpl> grantedAuthorities = new ArrayList<RoleImpl>();
		grantedAuthorities.add(role);
		return grantedAuthorities;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	public boolean isAccountNonExpired() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	public boolean isAccountNonLocked() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
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

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.common.AbstractDomainModel#getExcludedAttributes()
	 */
	@Override
	protected String[] getExcludedAttributes() {
		return new String[] {"role"};
	}

}
