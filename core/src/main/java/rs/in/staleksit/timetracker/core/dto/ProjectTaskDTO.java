/**
 * 
 */
package rs.in.staleksit.timetracker.core.dto;

import java.io.Serializable;

/**
 * @author aleksandar
 *
 */
public class ProjectTaskDTO implements Serializable {
	private static final long serialVersionUID = -6537086558774022742L;
	
	private Integer id;
	private String name;
	
	public ProjectTaskDTO() {
		
	}
	
	public ProjectTaskDTO(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
