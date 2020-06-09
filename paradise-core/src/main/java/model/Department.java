package model;

import java.io.Serializable;
/**
 * 部门实体类
 * @author 
 *
 */

public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8269894466150747742L;

	String id;
	String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
