/**
 * 
 */
package rs.in.staleksit.timetracker.core.util;

import org.joda.time.DateTime;

/**
 * @author aleksandar
 *
 */
public class DateUtils {
	
	/**
	 * end of the hour
	 * @param dateTime
	 * @return
	 */
	public static DateTime endOfHour(DateTime dateTime) {
		return dateTime.withMillisOfSecond(999).withSecondOfMinute(59).withMinuteOfHour(59);
	}
	
	/**
	 * begining of the hour
	 * @param dateTime
	 * @return
	 */
	public static DateTime beginningOfHour(DateTime dateTime) {
		return dateTime.withMillisOfSecond(0).withSecondOfMinute(0).withMinuteOfHour(0);
	}
	
	/**
	 * end of the day
	 * @param dateTime
	 * @return
	 */
	public static DateTime endOfDay(DateTime dateTime) {
		return endOfHour(dateTime).withHourOfDay(23);
	}
	
	/**
	 * beginning of the day
	 * @param dateTime
	 * @return
	 */
	public static DateTime beginningOfDay(DateTime dateTime) {
		return beginningOfHour(dateTime).withHourOfDay(0);
	}
	
	

}
