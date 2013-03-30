/**
 * 
 */
package rs.in.staleksit.timetracker.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.in.staleksit.timetracker.web.dto.SignInDTO;
import rs.in.staleksit.timetracker.web.router.TimeTrackerRouter;

/**
 * @author a.stoisavljevic
 *
 */
@Controller
public class SignInController {
	
	@ModelAttribute
	public void setUp(Model model) {
		model.addAttribute("signInUser", new SignInDTO());
	}
	
	
	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String handle() {
		return TimeTrackerRouter.SIGN_IN_VIEW;
	}
	
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public String handleSignInSubmit(@ModelAttribute("signInUser") SignInDTO signInDTO, Model model, BindingResult result) {
		
		if (result.hasErrors()) {
			return TimeTrackerRouter.SIGN_IN_VIEW;
		} else {
			return "redirect:/login";
		}
		
	}

}
