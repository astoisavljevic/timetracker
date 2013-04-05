/**
 * 
 */
package rs.in.staleksit.timetracker.web.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import rs.in.staleksit.timetracker.core.dto.ProjectDTO;
import rs.in.staleksit.timetracker.core.project.api.ProjectService;

/**
 * @author a.stoisavljevic
 * 
 */
@Controller
public class ProjectController {

	private static final Logger log = LoggerFactory.getLogger(ProjectController.class);
	
	private ProjectService projectService;
	
	@Autowired
	public ProjectController(@Qualifier("projectService") ProjectService projectService) {
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
		return projectService.findAllProjectsForUser(userId);
	}


}
