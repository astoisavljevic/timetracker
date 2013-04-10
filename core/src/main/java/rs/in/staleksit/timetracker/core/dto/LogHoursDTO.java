/**
 * 
 */
package rs.in.staleksit.timetracker.core.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author a.stoisavljevic
 *
 */
public class LogHoursDTO implements Serializable {
	private static final long serialVersionUID = -6398225204983635273L;
	
	@NotEmpty(message = "{validation.fieldMustNotBeEmpty}")
	private String hours;
	@NotNull(message = "{validation.fieldMustNotBeEmpty}")
	private Integer projectId;
	@NotEmpty(message = "{validation.fieldMustNotBeEmpty}")
	private String projectName;
	@NotEmpty(message = "{validation.fieldMustNotBeEmpty}")
	private String description;
	@NotNull(message = "{validation.fieldMustNotBeEmpty}")
	private Integer projectTaskId;
	
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getProjectTaskId() {
		return projectTaskId;
	}
	public void setProjectTaskId(Integer projectTaskId) {
		this.projectTaskId = projectTaskId;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
