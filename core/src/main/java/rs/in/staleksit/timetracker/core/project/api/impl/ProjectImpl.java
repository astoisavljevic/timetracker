/**
 * 
 */
package rs.in.staleksit.timetracker.core.project.api.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import rs.in.staleksit.timetracker.core.common.AbstractDomainModel;
import rs.in.staleksit.timetracker.core.project.Project;

/**
 * @author a.stoisavljevic
 * 
 */
@Entity
@Table(name = "stt_project")
public class ProjectImpl extends AbstractDomainModel implements Project {
	private static final long serialVersionUID = -8678312819978540223L;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "start_on")
	private Date startOn;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "company_code", nullable =false)
	private String companyCode;
	
	@Column(name = "company_name", nullable = false)
	private String companyName;
	
	@Column(name = "status")
	private String status;
	
	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.Project#getName()
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.Project#getDescription()
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.Project#getStartOn()
	 */
	public Date getStartOn() {
		return startOn;
	}

	public void setStartOn(Date startOn) {
		this.startOn = startOn;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.Project#getColor()
	 */
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.Project#getCompanyCode()
	 */
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.Project#getCompanyName()
	 */
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.Project#getStatus()
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
