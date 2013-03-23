/**
 * 
 */
package rs.in.staleksit.timetracker.core.project;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import rs.in.staleksit.timetracker.core.account.User;
import rs.in.staleksit.timetracker.core.account.UserImpl;
import rs.in.staleksit.timetracker.core.common.AbstractDomainModel;

/**
 * @author a.stoisavljevic
 * 
 */
@Entity
@Table(name = "stt_time_sheet")
public class TimeSheetImpl extends AbstractDomainModel implements TimeSheet {
	private static final long serialVersionUID = 6259596186523933619L;

	@ManyToOne
	@JoinColumn(name = "project_task_id")
	private ProjectTaskImpl projectTask;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserImpl user;

	@ManyToOne
	@JoinColumn(name = "activity_type_id")
	private ActivityTypeImpl activityType;

	@Column(name = "started_at")
	private Date startedAt;

	@Column(name = "hours")
	private BigDecimal hours;

	@Column(name = "description")
	private String description;

	@Column(name = "status")
	private String status;

	public ProjectTask getProjectTask() {
		return (ProjectTask) projectTask;
	}

	public void setProjectTask(ProjectTaskImpl projectTask) {
		this.projectTask = projectTask;
	}

	public User getUser() {
		return (User) user;
	}
	
	public void setUser(UserImpl user) {
		this.user = user;
	}

	public ActivityType getActivityType() {
		return (ActivityType) activityType;
	}

	public void setActivityType(ActivityTypeImpl activityType) {
		this.activityType = activityType;
	}

	public Date getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public BigDecimal getHours() {
		return hours;
	}
	
	public void setHours(BigDecimal hours) {
		this.hours = hours;
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

	@Override
	protected String[] getExcludedAttributes() {
		return new String[] {"projectTask", "user", "activityType"};
	}

}
