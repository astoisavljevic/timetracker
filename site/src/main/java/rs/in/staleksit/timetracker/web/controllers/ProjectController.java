/**
 * 
 */
package rs.in.staleksit.timetracker.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import rs.in.staleksit.timetracker.core.dto.ProjectDTO;

/**
 * @author a.stoisavljevic
 * 
 */
@Controller
public class ProjectController {

	private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

	@RequestMapping(value = "/project-list", method = RequestMethod.GET)
	public @ResponseBody
	List<ProjectDTO> getListOfProjects(@RequestParam("userId") Integer userId) {
		log.debug("-+- userId: {} -+-", userId);
		return dummyList();
	}

	private List<ProjectDTO> dummyList() {
		List<ProjectDTO> result = new ArrayList<ProjectDTO>();

		ProjectDTO project1 = new ProjectDTO(1, "Illness");
		result.add(project1);

		ProjectDTO project2 = new ProjectDTO(2, "Kick-off");
		result.add(project2);

		ProjectDTO project3 = new ProjectDTO(3, "JKP Cistoca");
		result.add(project3);

		ProjectDTO project4 = new ProjectDTO(4, "Startup Academy");
		result.add(project4);

		ProjectDTO project5 = new ProjectDTO(5, "Argo Insurance");
		result.add(project5);

		ProjectDTO project6 = new ProjectDTO(6, "Lidl");
		result.add(project6);

		ProjectDTO project7 = new ProjectDTO(7, "Timetracker");
		result.add(project7);

		ProjectDTO project8 = new ProjectDTO(8, "Levi9BB");
		result.add(project8);

		return result;
	}

}
