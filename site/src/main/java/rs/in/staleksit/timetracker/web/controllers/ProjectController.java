/**
 * 
 */
package rs.in.staleksit.timetracker.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import rs.in.staleksit.timetracker.core.account.User;
import rs.in.staleksit.timetracker.core.account.api.UserService;
import rs.in.staleksit.timetracker.core.dto.ProjectDTO;
import rs.in.staleksit.timetracker.core.dto.TimeSheetDTO;
import rs.in.staleksit.timetracker.core.project.api.ProjectService;

/**
 * @author a.stoisavljevic
 * 
 */
@Controller
public class ProjectController {

	private static final Logger log = LoggerFactory.getLogger(ProjectController.class);
	
	private UserService userService;
	private ProjectService projectService;
	
	@Autowired
	public ProjectController(@Qualifier("userService") UserService userService, @Qualifier("projectService") ProjectService projectService) {
		this.userService = userService;
		this.projectService = projectService;
	}

	@RequestMapping(value = "/project-list", method = RequestMethod.GET)
	public @ResponseBody
	List<ProjectDTO> getListOfProjects(
			@RequestParam(value = "userId") Integer userId,
			@RequestParam("query") String query) {
		if (log.isDebugEnabled()) {
			log.debug("-+- userId: {}, query: {} -+-", new Object[] {userId, query});
		}
		return projectService.findAllProjectsForUser(userId, query);
	}
	
	@RequestMapping(value = "/projecttask-list", method = RequestMethod.GET)
	public @ResponseBody
	List<ProjectDTO> getListOfProjectsTasks(
			@RequestParam(value = "projectId") Integer projectId,
			@RequestParam("query") String query) {
		if (log.isDebugEnabled()) {
			log.debug("-+- projectId: {}, query: {} -+-", new Object[] {projectId, query});
		}
		return projectService.findAllProjectTasks(projectId, query);
	}
	
	// rest-api
	@RequestMapping(value = "/api/project-list.json", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> handle(HttpServletRequest request, HttpServletResponse response, 
			@RequestParam(value = "username") String username) {
		Map<String, Object> result = new HashMap<String, Object>();
		User currentUser = userService.findByUsername(username);
		List<TimeSheetDTO> loggedHours = projectService.findRecentLoggedHoursForUser(currentUser);
		result.put("loggedHours", loggedHours);
		return result;
	}

}
