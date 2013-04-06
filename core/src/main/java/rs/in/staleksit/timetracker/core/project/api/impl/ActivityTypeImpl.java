/**
 * 
 */
package rs.in.staleksit.timetracker.core.project.api.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import rs.in.staleksit.timetracker.core.common.AbstractDomainModel;
import rs.in.staleksit.timetracker.core.project.ActivityType;

/**
 * @author a.stoisavljevic
 *
 */
@Entity
@Table(name = "stt_activity_type")
public class ActivityTypeImpl extends AbstractDomainModel implements ActivityType {
	private static final long serialVersionUID = 3372292275549510610L;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "color", nullable = false)
	private String color;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.common.AbstractDomainModel#getExcludedAttributes()
	 */
	@Override
	protected String[] getExcludedAttributes() {
		return new String[] {};
	}

}
