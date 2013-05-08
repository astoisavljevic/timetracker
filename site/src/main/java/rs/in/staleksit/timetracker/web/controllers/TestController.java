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
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	// rest-api
	@RequestMapping(value = "/api/test.json", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> handle(HttpServletRequest request, HttpServletResponse response, 
			@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
		log.info("-+- initiated test with JSONP -+-");
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", "ok");
		result.put("message", "User successfully authenticated");
		return result;
	}


}
