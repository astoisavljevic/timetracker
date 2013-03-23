/**
 * 
 */
package rs.in.staleksit.timetracker.core.domain.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

import rs.in.staleksit.timetracker.core.domain.common.AbstractDomainModel;

/**
 * @author a.stoisavljevic
 *
 */
@Entity
@Table(name = "stt_role")
public class RoleImpl extends AbstractDomainModel implements GrantedAuthority {
	private static final long serialVersionUID = -6961198480979783518L;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Transient
	public String getAuthority() {
		return name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected String[] getExcludedAttributes() {
		return new String[] {};
	}

}
