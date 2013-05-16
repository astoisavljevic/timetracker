/**
 * 
 */
package rs.in.staleksit.timetracker.core.project.api.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rs.in.staleksit.timetracker.core.account.User;
import rs.in.staleksit.timetracker.core.account.api.impl.UserImpl;
import rs.in.staleksit.timetracker.core.dto.ProjectDTO;
import rs.in.staleksit.timetracker.core.dto.TimeSheetDTO;
import rs.in.staleksit.timetracker.core.project.ActivityType;
import rs.in.staleksit.timetracker.core.project.Project;
import rs.in.staleksit.timetracker.core.project.TimeSheet;
import rs.in.staleksit.timetracker.core.project.api.ProjectService;
import rs.in.staleksit.timetracker.core.util.DateUtils;
import rs.in.staleksit.timetracker.core.util.ProjectMapper;
import rs.in.staleksit.timetracker.core.util.TimeSheetMapper;

import com.mysema.query.types.expr.BooleanExpression;


/**
 * @author a.stoisavljevic
 *
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	
	private static final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);
	
	private ProjectMemberRepository projectMemberRepository;
	
	private ActivityTypeRepository activityTypeRepository;
	
	private ProjectTaskRepository projectTaskRepository;
	
	private TimeSheetRepository timeSheetRepository;
	
	@Autowired
	public ProjectServiceImpl(ProjectMemberRepository projectMemberRepository, 
			ActivityTypeRepository activityTypeRepository, ProjectTaskRepository projectTaskRepository, TimeSheetRepository timeSheetRepository) {
		this.projectMemberRepository = projectMemberRepository;
		this.activityTypeRepository = activityTypeRepository;
		this.projectTaskRepository = projectTaskRepository;
		this.timeSheetRepository = timeSheetRepository;
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
		// find all projects in projectMember mapping that are correlated to user with given id
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

	@Override
	@Transactional(value = "transactionManager", readOnly = true, propagation = Propagation.SUPPORTS)
	public List<ProjectDTO> findAllProjectTasks(Integer projectId,
			String query) {
		
		QProjectTaskImpl projectTaskImpl = QProjectTaskImpl.projectTaskImpl;
		// find project tasks within certain project and with given query
		BooleanExpression isEqualProject = projectTaskImpl.project.id.eq(projectId);
		BooleanExpression likeExpression = projectTaskImpl.name.like("%" + query + "%");
		
		Page<ProjectTaskImpl> projectTaskResult = projectTaskRepository.findAll(isEqualProject.and(likeExpression), new PageRequest(0, 10));
		
		List<ProjectDTO> projectResults = new ArrayList<ProjectDTO>();
		
		for (ProjectTaskImpl item: projectTaskResult.getContent()) {
			ProjectDTO projectDTO = new ProjectDTO(item.getId(), item.getName());
			projectResults.add(projectDTO);
		}
		
		return projectResults;
	}

	@Override
	@Transactional(value = "transactionManager", readOnly = true, propagation = Propagation.SUPPORTS)
	public TimeSheet create(Integer projectTaskId, User user, Date startedAt, BigDecimal hours, String description) {
		ProjectTaskImpl projectTask = projectTaskRepository.findOne(projectTaskId);
		// for now use "Coding" - later see how we will pass activity type
		ActivityTypeImpl activityType = activityTypeRepository.findOne(4);
		TimeSheet result = new TimeSheetImpl(projectTask, (UserImpl)user, activityType, startedAt, hours, description);
		return result;
	}

	@Override
	@Transactional(value = "transactionManager")
	public TimeSheet saveTimeSheet(TimeSheet timeSheet) {
		return timeSheetRepository.save((TimeSheetImpl)timeSheet);
	}

	@Override
	@Transactional(value = "transactionManager", readOnly = true, propagation = Propagation.SUPPORTS)
	public List<TimeSheetDTO> findRecentLoggedHoursForUser(User user) {
		DateTime dtNow = new DateTime();
		DateTime dtBeginingToday = DateUtils.beginningOfDay(dtNow);
		DateTime dtEndToday = DateUtils.endOfDay(dtNow);
		
		QTimeSheetImpl timeSheet = QTimeSheetImpl.timeSheetImpl;
		// find timesheet records that belongs to this user
		BooleanExpression isEqualUser = timeSheet.user.username.eq(user.getUsername());
		BooleanExpression isToday = timeSheet.startedAt.between(dtBeginingToday.toDate(), dtEndToday.toDate());
		
		Page<TimeSheetImpl> timeSheetResults = timeSheetRepository.findAll(isEqualUser.and(isToday), new PageRequest(0, 10));
		List<TimeSheet> result = new ArrayList<TimeSheet>();
		for (TimeSheetImpl item: timeSheetResults) {
			result.add(item);
		}
		return TimeSheetMapper.map(result);
	}
		
}
