/**
 * 
 */
package rs.in.staleksit.timetracker.web.controllers;

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
	
	@Autowired
	public HomeController(@Qualifier("userService") UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String handleHomeLoggedIn(@ModelAttribute("logHours") LogHoursDTO logHours, Model model) {
		model.addAttribute("currentUser", userService.findByUsername(SecurityUtils.getPrincipal()));
		return TimeTrackerRouter.HOME_VIEW;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String handleLogHoursSubmit(@ModelAttribute("logHours") LogHoursDTO logHours, Model model, BindingResult result) {
		if (log.isDebugEnabled()) {
			log.debug(logHours.toString());
		}
		return "redirect:/" + TimeTrackerRouter.HOME_VIEW;
	}
	

}
