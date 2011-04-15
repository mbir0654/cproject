package business.model;

import java.util.ArrayList;

/**
 * 
 * @author otniel
 *
 */
public class Contract {
	private ArrayList<Course> courses;

	/**
	 * @param courses este lista de cursuri contractate
	 */
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	/**
	 * @return lista de cursuri contractate
	 */
	public ArrayList<Course> getCourses() {
		return courses;
	}	
}
