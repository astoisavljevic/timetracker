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

import rs.in.staleksit.timetracker.core.project.ActivityType;
import rs.in.staleksit.timetracker.core.project.api.ProjectService;

/**
 * @author aleksandar
 *
 */
@Controller
public class ActivityTypeController {
	
	private static final Logger log = LoggerFactory.getLogger(ProjectController.class);
	
	private ProjectService projectService;
	
	@Autowired
	public ActivityTypeController(@Qualifier("projectService") ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@RequestMapping(value = "/activitytype-list", method = RequestMethod.GET)
	public @ResponseBody
	List<ActivityType> getListOfActivityTypes(@RequestParam("query") String query) {
		if (log.isDebugEnabled()) {
			log.debug("-+- query: {} -+-", query);
		}
		return projectService.findAllActivityTypes(query);
	}

	
	


}
