/**
 * 
 */
package rs.in.staleksit.timetracker.web.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.in.staleksit.timetracker.web.router.TimeTrackerRouter;

/**
 * @author a.stoisavljevic
 *
 */
@Controller
@RequestMapping("/error")
public class ErrorController {
	
	private static final Logger log = LoggerFactory.getLogger(ErrorController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String handle(HttpServletRequest request, Map<String, Object> map) {
		log.error("ERROR! Exception: {}", request.getAttribute("exception"));
		map.put("statusCode", request.getAttribute("javax.servlet.error.status_code"));
		map.put("reason", request.getAttribute("javax.servlet.error.message"));
		map.put("requestedURI", request.getAttribute("javax.servlet.error.request_uri"));
		map.put("exception", request.getAttribute("exception"));
		return TimeTrackerRouter.ERROR_VIEW;
	}
}
