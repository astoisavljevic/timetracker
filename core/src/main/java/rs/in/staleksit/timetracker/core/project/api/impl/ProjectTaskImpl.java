/**
 * 
 */
package rs.in.staleksit.timetracker.core.project.api.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import rs.in.staleksit.timetracker.core.account.User;
import rs.in.staleksit.timetracker.core.account.api.impl.UserImpl;
import rs.in.staleksit.timetracker.core.common.AbstractDomainModel;
import rs.in.staleksit.timetracker.core.project.Project;
import rs.in.staleksit.timetracker.core.project.ProjectTask;
import rs.in.staleksit.timetracker.core.project.TaskType;

/**
 * @author a.stoisavljevic
 *
 */
@Entity
@Table(name = "stt_project_task")
public class ProjectTaskImpl extends AbstractDomainModel implements ProjectTask {
	private static final long serialVersionUID = 7721901375867521738L;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private ProjectImpl project;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserImpl user;
	
	@ManyToOne
	@JoinColumn(name = "task_type_id")
	private TaskTypeImpl taskType;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "start_on")
	private Date startOn;
	
	@Column(name = "due_on")
	private Date dueOn;
	
	@Column(name = "bid_hours")
	private BigDecimal bidHours;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "status")
	private String status;
	
	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.ProjectTask#getProject()
	 */
	public Project getProject() {
		return (Project)project;
	}
	
	public void setProject(ProjectImpl project) {
		this.project = project;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.ProjectTask#getUser()
	 */
	public User getUser() {
		return (User)user;
	}
	
	public void setUser(UserImpl user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.ProjectTask#getTaskType()
	 */
	public TaskType getTaskType() {
		return (TaskType)taskType;
	}
	
	public void setTaskType(TaskTypeImpl taskType) {
		this.taskType = taskType;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.ProjectTask#getName()
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.ProjectTask#getDescription()
	 */
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.ProjectTask#getStartOn()
	 */
	public Date getStartOn() {
		return startOn;
	}
	
	public void setStartOn(Date startOn) {
		this.startOn = startOn;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.ProjectTask#getDueOn()
	 */
	public Date getDueOn() {
		return dueOn;
	}
	
	public void setDueOn(Date dueOn) {
		this.dueOn = dueOn;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.ProjectTask#getBidHours()
	 */
	public BigDecimal getBidHours() {
		return bidHours;
	}
	
	public void setBidHours(BigDecimal bidHours) {
		this.bidHours = bidHours;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.ProjectTask#getColor()
	 */
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.ProjectTask#getStatus()
	 */
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.common.AbstractDomainModel#getExcludedAttributes()
	 */
	@Override
	protected String[] getExcludedAttributes() {
		return new String[] {"project", "user", "taskType"};
	}

}
