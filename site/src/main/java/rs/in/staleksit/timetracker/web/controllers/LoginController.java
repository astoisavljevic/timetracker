/**
 * 
 */
package rs.in.staleksit.timetracker.web.controllers;

import java.util.HashMap;
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
import rs.in.staleksit.timetracker.web.router.TimeTrackerRouter;

/**
 * @author a.stoisavljevic
 *
 */
@Controller
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	private static final String LOGIN_USER_NOT_IN_SYSTEM = "user-null";
	private static final String LOGIN_USER_DISABLED = "user-disabled";
	private static final String LOGIN_USER_INVALID_LOGIN = "user-invalid-login";
	private static final String LOGIN_USER_OK = "ok";
	
	private UserService userService;
	
	@Autowired
	public LoginController(@Qualifier("userService") UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String handle() {
		return TimeTrackerRouter.LOGIN_VIEW;
	}
	
	// rest-api
	@RequestMapping(value = "/api/login.json", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> handle(HttpServletRequest request, HttpServletResponse response, 
			@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
		Map<String, Object> result = new HashMap<String, Object>();
		User user = userService.findByUsername(username);
		if (user != null) {
			if (user.isEnabled()) {
				if (user.getPassword().equals(password)) {
					result.put("username", user.getUsername());
					result.put("status", LOGIN_USER_OK);
				} else {
					result.put("status", LOGIN_USER_INVALID_LOGIN);
				}
			} else {
				result.put("status", LOGIN_USER_DISABLED);
			}
		} else {
			result.put("status", LOGIN_USER_NOT_IN_SYSTEM);
		}
		return result;
	}
}
