/**
 * 
 */
package rs.in.staleksit.timetracker.web.filter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author aleksandar
 *
 */
public class JsonpCallbackFilter implements Filter {
	
	private static final boolean GENERATE_JSESSION_ID = true;
	
	private static final String CALLBACK_PARAM_KEY_NAME = "callback";
	private static final String OPEN_PARANTHESIS = "(";
	private static final String CLOSED_PARANTHESIS = ")";
	private static final String SEMI_COLUMN_CHAR = ";";
	private static final String JSONP_CONTENT_TYPE = "text/javascript;charset=UTF-8";

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		// will associate request to current session, if no session will create one
		httpServletRequest.getSession(GENERATE_JSESSION_ID);
		
		@SuppressWarnings("unchecked")
		Map<String, String[]> requestParams = httpServletRequest.getParameterMap();
		if (requestParams.containsKey(CALLBACK_PARAM_KEY_NAME)) {
			OutputStream out = httpServletResponse.getOutputStream();
			GenericResponseWrapper wrapper = new GenericResponseWrapper(httpServletResponse);
			
			chain.doFilter(request, wrapper);

			/** generating out **/
			StringBuilder sbStart = new StringBuilder();
			sbStart.append(requestParams.get(CALLBACK_PARAM_KEY_NAME)[0]);
			sbStart.append(OPEN_PARANTHESIS);
			out.write(sbStart.toString().getBytes());
			out.write(wrapper.getData());
			
			StringBuilder sbEnd = new StringBuilder();
			sbEnd.append(CLOSED_PARANTHESIS);
			sbEnd.append(SEMI_COLUMN_CHAR);
			out.write(sbEnd.toString().getBytes());

			/** set out content type **/
			wrapper.setContentType(JSONP_CONTENT_TYPE);

			/** close output stream **/
			out.close();
		} else {
			// this is not callback JSONP call do not do nothing just pass it to next filter in chain
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
