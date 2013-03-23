/**
 * 
 */
package rs.in.staleksit.timetracker.core.common;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * @author a.stoisavljevic
 *
 */
@MappedSuperclass
@SuppressWarnings("serial")
public abstract class AbstractDomainModel extends AbstractPersistable<Integer> {
	
	@Version
	private Integer version;
	
	/**
	 * @return
	 */
	public Integer getVersion() {
		return version;
	}
	
	@Transient
	protected abstract String[] getExcludedAttributes();
	
	
	@Override
	public String toString() {
		String result = "";
		final String[] excluded = getExcludedAttributes();
		if (excluded == null || excluded.length == 0) {
			result = ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		}
		result = ReflectionToStringBuilder.toStringExclude(this, excluded);
		return result;
	}
}
