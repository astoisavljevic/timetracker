/**
 * 
 */
package rs.in.staleksit.timetracker.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import rs.in.staleksit.timetracker.core.account.User;
import rs.in.staleksit.timetracker.core.account.api.UserService;
import rs.in.staleksit.timetracker.core.dto.UserDTO;
import rs.in.staleksit.timetracker.web.router.TimeTrackerRouter;
import rs.in.staleksit.timetracker.web.security.util.SecurityUtils;

/**
 * @author a.stoisavljevic
 *
 */
@Controller
public class AccountController {
	
	private static final Logger log = LoggerFactory.getLogger(AccountController.class);
	
	private static final String[] ACCOUNT_DISSALOWED_FIELDS = {"id"};
	
	private UserService userService;
	
	@Autowired
	public AccountController(@Qualifier("userService") UserService userService) {
		this.userService = userService;
	}
	
	@InitBinder
	public void defaultInitBinder(WebDataBinder binder) {
		binder.setDisallowedFields(ACCOUNT_DISSALOWED_FIELDS);
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
			user = userService.findByUsername(SecurityUtils.getPrincipal());
		}
		
		model.addAttribute("user", user);
		
		return TimeTrackerRouter.ACCOUNT_VIEW;
	}
	
	@RequestMapping(value = "/accountChange/{userId}", method = RequestMethod.GET)
	public String handleChangeAccount(@ModelAttribute("user") UserDTO userDTO, @PathVariable("userId") Integer userId, Model model) {
		if (log.isDebugEnabled()) {
			log.debug("-+- pathVariable param: [userId: {}] -+-", userId);
		}
		User currentUser = userService.findOne(userId);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("user", new UserDTO(userService.findOne(userId)));
		return TimeTrackerRouter.ACCOUNT_CHANGE_VIEW;
	}
	
	@RequestMapping(value = "/accountChange/{userId}", method = RequestMethod.POST)
	public String handleChangeAccountSubmit(HttpServletRequest request, @PathVariable("userId") Integer userId, @Valid @ModelAttribute("user") UserDTO userDTO, BindingResult result) {
		String resultView;
		if (result.hasErrors()) {
			resultView = TimeTrackerRouter.ACCOUNT_CHANGE_VIEW;
		} else {
			User userData = userService.findOne(userId);
			userData.merge(userDTO);
			userService.save(userData);
			resultView =  "redirect:/" + TimeTrackerRouter.ACCOUNT_VIEW;
		}
		return resultView;
	}

}
