package business.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author otniel
 *
 */
public class Contract {
	private List<Course> courses;
	
	/**
	 * Constructorul implcit
	 */
	public Contract(){
		courses = new ArrayList<Course>();
	}

	/**
	 * @param courses va fi lista de cursuri contractate
	 */
	public void setCourses(List<Course> courses) {
		this.courses.clear();
		this.courses.addAll(courses);
	}

	/**
	 * @return lista de cursuri contractate
	 */
	public List<Course> getCourses() {
		return courses;
	}	
}
