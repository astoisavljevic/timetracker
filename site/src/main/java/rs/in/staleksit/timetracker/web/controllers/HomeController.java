/**
 * 
 */
package rs.in.staleksit.timetracker.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.in.staleksit.timetracker.core.account.api.UserService;
import rs.in.staleksit.timetracker.web.router.TimeTrackerRouter;
import rs.in.staleksit.timetracker.web.security.util.SecurityUtils;

/**
 * @author a.stoisavljevic
 *
 */
@Controller
public class HomeController {
	
	private UserService userService;
	
	@Autowired
	public HomeController(@Qualifier("userService") UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String handle() {
		return TimeTrackerRouter.START_VIEW;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String handleHomeLoggedIn(Model model) {
		model.addAttribute("currentUser", userService.findByUsername(SecurityUtils.getPrincipal()));
		return TimeTrackerRouter.HOME_VIEW;
	}

}
