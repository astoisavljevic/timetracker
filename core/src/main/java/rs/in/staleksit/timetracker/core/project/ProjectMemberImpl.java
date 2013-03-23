/**
 * 
 */
package rs.in.staleksit.timetracker.core.project;

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
@Table(name = "stt_project_member")
public class ProjectMemberImpl extends AbstractDomainModel implements
		ProjectMember {
	private static final long serialVersionUID = 971244292334419803L;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private ProjectImpl project;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserImpl user;
	
	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.ProjectMember#getProject()
	 */
	public Project getProject() {
		return (Project) project;
	}
	
	public void setProject(ProjectImpl project) {
		this.project = project;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.project.ProjectMember#getUser()
	 */
	public User getUser() {
		return (User) user;
	}

	public void setUser(UserImpl user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see rs.in.staleksit.timetracker.core.domain.common.AbstractDomainModel#getExcludedAttributes()
	 */
	@Override
	protected String[] getExcludedAttributes() {
		return new String[] {"project", "user"};
	}

}
