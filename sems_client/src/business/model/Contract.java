package business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author otniel
 *
 */
public class Contract implements Serializable {
	private List<Course> courses;
	private Student student;
	
	/**
	 * Constructorul implcit
	 */
	public Contract(Student s){
            courses = new ArrayList<Course>();
            student = s;
	}

	/**
	 * @param course va fi lista de cursuri contractate
	 */
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	
	/**
	 * 
	 * @param c este cursul care va fi scos din contract
	 */
	public void removeCourse(Course c){
		courses.remove(c);
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

    @Override
    public String toString(){
        return courses + " " + student;
    }
}
