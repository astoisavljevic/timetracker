import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
 */

/**
 * @author aleksandar
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:/rs/in/staleksit/timetracker/web/ctx/applicationContext.xml")
@ActiveProfiles("development")
public class SampleTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		this.mvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testStart() throws Exception {
		this.mvc.perform(get("/start")).andExpect(status().isOk());
	}
	
	@Test
	public void testHome() throws Exception {
		this.mvc.perform(get("/home")).andExpect(status().isOk());
	}
	
	@Test
	public void testUnknown() throws Exception {
		this.mvc.perform(get("/unknown")).andExpect(status().isNotFound());
	}
	
	

}
