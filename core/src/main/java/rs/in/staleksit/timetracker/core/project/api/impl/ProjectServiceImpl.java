/**
 * 
 */
package rs.in.staleksit.timetracker.core.project.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rs.in.staleksit.timetracker.core.dto.ProjectDTO;
import rs.in.staleksit.timetracker.core.project.Project;
import rs.in.staleksit.timetracker.core.project.ProjectMemberImpl;
import rs.in.staleksit.timetracker.core.project.ProjectMemberRepository;
import rs.in.staleksit.timetracker.core.project.ProjectRepository;
import rs.in.staleksit.timetracker.core.project.QProjectMemberImpl;
import rs.in.staleksit.timetracker.core.project.api.ProjectService;
import rs.in.staleksit.timetracker.core.util.ProjectMapper;

import com.mysema.query.types.expr.BooleanExpression;

/**
 * @author a.stoisavljevic
 *
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	
	private static final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);
	
	@SuppressWarnings("unused")
	private ProjectRepository projectRepository;
	
	private ProjectMemberRepository projectMemberRepository;
	
	@Autowired
	public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMemberRepository projectMemberRepository) {
		this.projectRepository = projectRepository;
		this.projectMemberRepository = projectMemberRepository;
	}

	/**
	 * @see rs.in.staleksit.timetracker.core.project.api.ProjectService#findAllProjectsForUser(java.lang.Integer)
	 */
	@Override
	@Transactional(value = "transactionManager", readOnly = true, propagation = Propagation.SUPPORTS)
	public List<ProjectDTO> findAllProjectsForUser(Integer userId) {
		if (log.isDebugEnabled()) {
			log.debug("-+- userId: {} -+-", userId);
		}
		QProjectMemberImpl projectMember = QProjectMemberImpl.projectMemberImpl;
		BooleanExpression isEqualUser = projectMember.user.id.eq(userId);
		
		Page<ProjectMemberImpl> projectsForUser = projectMemberRepository.findAll(isEqualUser, new PageRequest(0, 10));
		List<Project> projects = new ArrayList<Project>();
		
		for (ProjectMemberImpl item: projectsForUser) {
			if (log.isDebugEnabled()) {
				log.debug("-+- projectName: {} -+-", item.getProject().getName());
			}
			projects.add(item.getProject());
		}
		
		return ProjectMapper.map(projects);
	}
	
}
