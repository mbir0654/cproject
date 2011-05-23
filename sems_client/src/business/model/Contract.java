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
	private Student student;
	
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

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}	
}
