/**
 * 
 */
package rs.in.staleksit.timetracker.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import rs.in.staleksit.timetracker.core.account.User;
import rs.in.staleksit.timetracker.core.account.api.UserService;
import rs.in.staleksit.timetracker.web.router.TimeTrackerRouter;

/**
 * @author a.stoisavljevic
 *
 */
@Controller
public class AccountController {
	
	private static final Logger log = LoggerFactory.getLogger(AccountController.class);
	
	private UserService userService;
	
	@Autowired
	public AccountController(@Qualifier("userService") UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String handle(@RequestParam(value = "username", required = false) String username, Model model) {
		
		if (log.isDebugEnabled()) {
			log.debug("-+- req. params [ username: {} ] -+-", username);
		}
		
		User user =  null;
		if (username != null) {
			user = userService.findByUsername(username);
		} else {
			user = userService.findByUsername(((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
		}
		
		model.addAttribute("user", user);
		
		return TimeTrackerRouter.ACCOUNT_VIEW;
	}

}
