/**
 * 
 */
package rs.in.staleksit.timetracker.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.in.staleksit.timetracker.web.router.TimeTrackerRouter;

/**
 * @author a.stoisavljevic
 *
 */
@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String handle() {
		return TimeTrackerRouter.LOGIN_VIEW;
	}

}
