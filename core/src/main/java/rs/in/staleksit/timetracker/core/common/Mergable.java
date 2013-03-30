/**
 * 
 */
package rs.in.staleksit.timetracker.core.common;

/**
 * @author a.stoisavljevic
 *
 */
public interface Mergable {
	
	
	void merge(Object source, String... copyProperties);

}
