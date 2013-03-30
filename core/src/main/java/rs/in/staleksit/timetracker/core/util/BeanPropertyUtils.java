/**
 * 
 */
package rs.in.staleksit.timetracker.core.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * @author d.gajic
 *
 */
public class BeanPropertyUtils {
	
	/**
	 * Copy values from source object to target object
	 * by matching property by name and type.
	 * 
	 * It is possible to define names of the properties to be copied,
	 * in which case only those properties will be copied. If that is
	 * omitted then all the properties of source object will be copied
	 * silently ignoring those which do not match.
	 * 
	 * @param source
	 * @param target
	 * @param properties
	 * @throws InvalidPropertyException if there is no such property or if the property isn't writable
	 */
	public static void copyBeanProperties(
		    final Object source,
		    final Object target,
		    final String...copyProperties){

		    final BeanWrapper src = new BeanWrapperImpl(source);
		    final BeanWrapper trg = new BeanWrapperImpl(target);
		    
		    if (copyProperties.length == 0) {
		    	BeanUtils.copyProperties(source, target);
		    } else {
		    	for(final String propertyName : copyProperties){
		    		trg.setPropertyValue(propertyName, src.getPropertyValue(propertyName));
		    	}
		    }
	}	    
}