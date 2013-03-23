/**
 * 
 */
package rs.in.staleksit.timetracker.core.domain.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import rs.in.staleksit.timetracker.core.domain.common.AbstractDomainModel;

/**
 * @author a.stoisavljevic
 *
 */
@Entity
@Table(name = "stt_task_type")
public class TaskTypeImpl extends AbstractDomainModel implements TaskType {
	private static final long serialVersionUID = -6439592355630388200L;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "color", nullable = false)
	private String color;
	
	@Column(name = "status", nullable = false)
	private String status;

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.TaskType#getName()
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.TaskType#getDescription()
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.TaskType#getColor()
	 */
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.TaskType#getStatus()
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
		return new String[] {};
	}

}
