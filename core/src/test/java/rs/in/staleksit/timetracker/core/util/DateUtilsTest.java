/**
 * 
 */
package rs.in.staleksit.timetracker.core.util;

import static org.testng.Assert.*;

import org.joda.time.DateTime;
import org.testng.annotations.Test;

/**
 * @author aleksandar
 *
 */
@Test(groups = {"unit", "model", "core", "rs.in.staleksit.timetracker.core.util.DateUtilsTest"})
public class DateUtilsTest {
	
	public void testEndOfTheHour() {
		DateTime dt = new DateTime(2013, 4, 16, 20, 45);
		
		DateTime endOfTheHour = DateUtils.endOfHour(dt);
		assertTrue(endOfTheHour.toString().contains("2013-04-16T20:59:59.999"));
	}
	
	public void testBeginningOfTheHour() {
		DateTime dt = new DateTime(2013, 4, 16, 20, 45);
		
		DateTime beginningOfTheHour = DateUtils.beginningOfHour(dt);
		assertTrue(beginningOfTheHour.toString().contains("2013-04-16T20:00:00.000"));
	}
	
	public void endOfTheDay() {
		DateTime dt = new DateTime(2013, 4, 16, 20, 45);
		
		DateTime endOfTheDay = DateUtils.endOfDay(dt);
		assertTrue(endOfTheDay.toString().contains("2013-04-16T23:59:59.999"));
	}
	
	public void beginningOfTheDay() {
		DateTime dt = new DateTime(2013, 4, 16, 20, 45);
		
		DateTime beginningOfTheDay = DateUtils.beginningOfDay(dt);
		assertTrue(beginningOfTheDay.toString().contains("2013-04-16T00:00:00.000"));
	}

}
