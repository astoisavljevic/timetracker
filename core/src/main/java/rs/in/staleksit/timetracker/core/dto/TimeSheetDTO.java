/**
 * 
 */
package rs.in.staleksit.timetracker.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author aleksandar
 *
 */
public class TimeSheetDTO implements Serializable {
	private static final long serialVersionUID = -4995719708677089032L;
	
	private Integer id;
	private String projectTaskName;
	private String activityTypeName;
	private BigDecimal minutes;
	private String description;
	private String status;
	
	public TimeSheetDTO() {
		
	}
	
	public TimeSheetDTO(Integer id, String projectTaskName, String activityTypeName, BigDecimal minutes, String description, String status) {
		this.id = id;
		this.projectTaskName = projectTaskName;
		this.activityTypeName = activityTypeName;
		this.minutes = minutes;
		this.description = description;
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProjectTaskName() {
		return projectTaskName;
	}
	public void setProjectTaskName(String projectTaskName) {
		this.projectTaskName = projectTaskName;
	}
	public String getActivityTypeName() {
		return activityTypeName;
	}
	public void setActivityTypeName(String activityTypeName) {
		this.activityTypeName = activityTypeName;
	}
	public BigDecimal getMinutes() {
		return minutes;
	}
	public void setMinutes(BigDecimal minutes) {
		this.minutes = minutes;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMinutesHumanReadableFormat() {
		int hours = minutes.intValue() / 60;
		int leftOver = minutes.intValue() % 60;
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%dh:%02dm", hours, leftOver));
		return sb.toString();
	}

	public float getWorkPart() {
		float percentage = minutes.floatValue()/480; 
		return percentage * 100;
	}
	
	
	
	

}
