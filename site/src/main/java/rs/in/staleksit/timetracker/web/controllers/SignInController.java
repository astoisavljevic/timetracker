/**
 * 
 */
package rs.in.staleksit.timetracker.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.in.staleksit.timetracker.core.account.User;
import rs.in.staleksit.timetracker.core.account.api.UserService;
import rs.in.staleksit.timetracker.web.dto.SignInDTO;
import rs.in.staleksit.timetracker.web.router.TimeTrackerRouter;

/**
 * @author a.stoisavljevic
 *
 */
@Controller
public class SignInController {
	
	private UserService userService;
	
	@Autowired
	public SignInController(@Qualifier("userService") UserService userService) {
		this.userService = userService;
	}
	
	@ModelAttribute
	public void setUp(Model model) {
		model.addAttribute("signInUser", new SignInDTO());
	}
	
	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String handle() {
		return TimeTrackerRouter.SIGN_IN_VIEW;
	}
	
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public String handleSignInSubmit(@Valid @ModelAttribute("signInUser") SignInDTO signInDTO, BindingResult result) {
		if (result.hasErrors()) {
			return TimeTrackerRouter.SIGN_IN_VIEW;
		} else {
			User userData = userService.create(signInDTO.getUsername(), signInDTO.getPassword(), signInDTO.getEmail(), signInDTO.getFirstName(), signInDTO.getLastName());
			userService.save(userData);
			return "redirect:/login";
		}
	}

}
