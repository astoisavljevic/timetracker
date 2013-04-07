/**
 * 
 */
package rs.in.staleksit.timetracker.core.project.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.LikeExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rs.in.staleksit.timetracker.core.dto.ProjectDTO;
import rs.in.staleksit.timetracker.core.project.ActivityType;
import rs.in.staleksit.timetracker.core.project.Project;
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
	
	private ActivityTypeRepository activityTypeRepository;
	
	@Autowired
	public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMemberRepository projectMemberRepository, 
			ActivityTypeRepository activityTypeRepository) {
		this.projectRepository = projectRepository;
		this.projectMemberRepository = projectMemberRepository;
		this.activityTypeRepository = activityTypeRepository;
	}

	/**
	 * @see rs.in.staleksit.timetracker.core.project.api.ProjectService#findAllProjectsForUser(java.lang.Integer)
	 */
	@Override
	@Transactional(value = "transactionManager", readOnly = true, propagation = Propagation.SUPPORTS)
	public List<ProjectDTO> findAllProjectsForUser(Integer userId, String query) {
		if (log.isDebugEnabled()) {
			log.debug("-+- userId: {}; query: {} -+-", new Object[] {userId, query});
		}
		QProjectMemberImpl projectMember = QProjectMemberImpl.projectMemberImpl;
		// find all projects in projectMember mapping that are corelated to user with given id
		BooleanExpression isEqualUser = projectMember.user.id.eq(userId);
		BooleanExpression likeExpression = projectMember.project.name.like("%" + query + "%");
		
		Page<ProjectMemberImpl> projectsForUser = projectMemberRepository.findAll(isEqualUser.and(likeExpression), new PageRequest(0, 10));
		List<Project> projects = new ArrayList<Project>();
		
		for (ProjectMemberImpl item: projectsForUser) {
			if (log.isDebugEnabled()) {
				log.debug("-+- projectName: {} -+-", item.getProject().getName());
			}
			projects.add(item.getProject());
		}
		
		return ProjectMapper.map(projects);
	}

	@Override
	@Transactional(value = "transactionManager", readOnly = true, propagation = Propagation.SUPPORTS)
	public List<ActivityType> findAllActivityTypes(String query) {
		QActivityTypeImpl activityType = QActivityTypeImpl.activityTypeImpl;
		// find activity types by name like
		BooleanExpression likeExpression = activityType.name.like("%" + query + "%");
		Page<ActivityTypeImpl> activityTypesResult = activityTypeRepository.findAll(likeExpression, new PageRequest(0, 10));
		List<ActivityType> result = new ArrayList<ActivityType>();
		for (ActivityTypeImpl item: activityTypesResult.getContent()) {
			result.add(item);
		}
		return result;
	}
	
}
