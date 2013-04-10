/**
 * 
 */
package rs.in.staleksit.timetracker.web.controllers;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.in.staleksit.timetracker.core.account.api.UserService;
import rs.in.staleksit.timetracker.core.dto.LogHoursDTO;
import rs.in.staleksit.timetracker.core.project.TimeSheet;
import rs.in.staleksit.timetracker.core.project.api.ProjectService;
import rs.in.staleksit.timetracker.web.router.TimeTrackerRouter;
import rs.in.staleksit.timetracker.web.security.util.SecurityUtils;

/**
 * @author a.stoisavljevic
 *
 */
@Controller
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	private UserService userService;
	private ProjectService projectService;
	
	@Autowired
	public HomeController(@Qualifier("userService") UserService userService, @Qualifier("projectService") ProjectService projectService) {
		this.userService = userService;
		this.projectService = projectService;
	}
	
	@ModelAttribute("logHours")
	public void setUp(Model model) {
		model.addAttribute("currentUser", userService.findByUsername(SecurityUtils.getPrincipal()));
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String handleHomeLoggedIn(@ModelAttribute("logHours") LogHoursDTO logHours, Model model) {
		return TimeTrackerRouter.HOME_VIEW;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String handleLogHoursSubmit(@Valid @ModelAttribute("logHours") LogHoursDTO logHoursDTO, BindingResult result) {
		if (log.isDebugEnabled()) {
			log.debug("-+- LogHours: {} -+-" + logHoursDTO.toString());
		}
		if (result.hasErrors()) {
			return TimeTrackerRouter.HOME_VIEW;
		} else {
			TimeSheet timeSheet = projectService.create(logHoursDTO.getProjectTaskId(), userService.findByUsername(SecurityUtils.getPrincipal()), new Date(), new BigDecimal(logHoursDTO.getHours()), logHoursDTO.getDescription());
			projectService.saveTimeSheet(timeSheet);
			return "redirect:/" + TimeTrackerRouter.HOME_VIEW;
		}
	}
	

}
