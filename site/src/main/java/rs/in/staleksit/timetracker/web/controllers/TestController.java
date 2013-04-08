/**
 * 
 */
package rs.in.staleksit.timetracker.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.in.staleksit.timetracker.core.account.api.UserService;
import rs.in.staleksit.timetracker.web.router.TimeTrackerRouter;
import rs.in.staleksit.timetracker.web.security.util.SecurityUtils;

/**
 * @author aleksandar
 *
 */
@Controller
@Profile("development")
public class TestController {
	
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(TestController.class);
	
	private UserService userService;
	
	@Autowired
	public TestController(@Qualifier("userService") UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String handle(Model model) {
		model.addAttribute("currentUser", userService.findByUsername(SecurityUtils.getPrincipal()));
		return TimeTrackerRouter.TEST_VIEW;
	}

}
