/**
 * 
 */
package rs.in.staleksit.timetracker.core.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author a.stoisavljevic
 *
 */
public class ProjectDTO implements Serializable {
	private static final long serialVersionUID = -6361924008066191916L;
	
	private Integer id;
	private String name;
	
	public ProjectDTO() {
		
	}
	
	public ProjectDTO(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	

}
